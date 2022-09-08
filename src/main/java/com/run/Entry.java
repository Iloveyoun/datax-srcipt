package com.run;

import com.config.Objects;
import com.entity.TPubEtlLogs;
import com.utils.MyUtil;
import com.utils.XShellUtil;
import com.utils.XStringUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import src.afsql.db.AfSimpleDB;
import src.afsql.util.AfSqlStringUtils;
import src.afsql.util.AfSqlUpdate;
import src.afsql.util.AfSqlWhere;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Entry {
    public static void main(String[] args) throws Exception {
        XStringUtil.printDataXScript();
        // 1、拿到输入的参数：1 ZZ1 CG8TZ1.TDOBC01
        Map<String, String> paramMap = parametricTransform(args);

        // 2、查询配置
        String sql = "SELECT * FROM t_pub_etl_jobs";
        AfSqlWhere where = new AfSqlWhere();
        where.add2("valid_flag", Integer.valueOf(paramMap.get("validFlag")), paramMap.get("validFlag") != null);
        where.add2("module_type", paramMap.get("moduleType"), paramMap.get("moduleType") != null);
        where.add2("src_system_id", paramMap.get("srcObjectId"), paramMap.get("srcObjectId") != null);
        where.add2("src_object_name", paramMap.get("srcObjectName"), paramMap.get("srcObjectName") != null);
        List<Map> queryJobs = AfSimpleDB.query(sql + where + " ORDER BY job_seq", 0);
        if (queryJobs.size() == 0) {
            System.out.println("**无可执行JOB信息，程序结束。");
            return;
        }
        // 3、根据配置生成JSON文件并执行
        createJSONsInit(queryJobs);
    }

    /**
     * 把输入的参数转换成Map
     * @param args
     * @return 数据数组
     */
    private static Map<String, String> parametricTransform(String[] args) {
        // job是否有效标志、job模块类型、源系统Schema、源系统对象名称，srcObjectId,srcObjectName
        // 参数转换：1 ZZ1 CG7VM1.TMMSM01
        String[] paramName = new String[] {"validFlag", "moduleType", "srcSystemTable"};
        if (args.length > paramName.length) {
            throw new RuntimeException("**参数个数输入有误，请检查后再试！");
        }
        Map<String, String> paramMap = new HashMap<>();
        for (int i = 0; i < args.length; i++) {
            paramMap.put(paramName[i], args[i]);
        }
        // 如 CG8TZ1.TDOBC01 分开成 CG8TZ1 | TDOBC01
        if (AfSqlStringUtils.isNotEmpty(paramMap.get("srcSystemTable"))) {
            String[] srcSystemTables = XStringUtil.getStrArray(paramMap.get("srcSystemTable"));
            if (srcSystemTables.length == 2) {
                paramMap.put("srcObjectId", srcSystemTables[0]);
                paramMap.put("srcObjectName", srcSystemTables[1]);
            } else {
                paramMap.put("srcObjectName", srcSystemTables[0]);
            }
        }
        return paramMap;
    }

    /**
     * 根据配置信息列表，生成可供DataX执行的JSON文件
     * @param queryJobs
     * @return 是否成功
     */
    private static void createJSONsInit(List<Map> queryJobs) throws Exception {
        for (Map<String, String> queryJob : queryJobs) {
            // 日志信息
            Map<String, String> tPubEtlLogs = new HashMap<>();
            long start = System.currentTimeMillis();
            String dataTime = MyUtil.getPresentDateTime();
            tPubEtlLogs.put("start_time", dataTime);
            try {
                // 生成要执行的JSON文件
                String jobScriptRunName = createJSONINIt(queryJob, MyUtil.getPresentDateTime1()).replace("\\", "/");
                System.out.println("**要执行的JSON文件确认成功为：" + jobScriptRunName);

                // 更新数据库的执行JSON名跟更新时间
                AfSqlUpdate updateSql = new AfSqlUpdate("t_pub_etl_jobs");
                updateSql.add("last_update", dataTime);
                updateSql.add("job_script_run_name", jobScriptRunName);
                AfSqlWhere whereSql = new AfSqlWhere().add2("job_id", queryJob.get("job_id"));

                // 执行 JSON文件
                String jvm = "";
                if (AfSqlStringUtils.isNotEmpty(queryJob.get("job_jvm_xms")) && AfSqlStringUtils.isNotEmpty(queryJob.get("job_jvm_xmx"))) {
                    jvm = String.format("--jvm=\"-Xms%sG -Xmx%sG\"", queryJob.get("job_jvm_xms"), queryJob.get("job_jvm_xmx"));
                }
                String cd = "python " + Objects.getConfig().getPythonPath() + " " + jvm + " " + jobScriptRunName;
                System.out.println("**即将执行DataX命令：" + cd);
                tPubEtlLogs.put("datax_script_name", cd);
                Map<String, String> run = XShellUtil.run(cd, null);
                tPubEtlLogs.putAll(run);

                // 更新配置表的cols字段
                if ("1".equals(queryJob.get("ddl_auto_sync"))) {
                    if (AfSqlStringUtils.isNotEmpty(run.get("all_columns")) && ("*".equals(queryJob.get("cols")) || !AfSqlStringUtils.isNotEmpty(queryJob.get("cols")))) {
                        String all_columns = XStringUtil.getStrArray(XStringUtil.getStrArray(run.get("all_columns"), "(")[1], ")")[0];
                        System.out.println("**触发条件，更新cols，值为：" + all_columns);
                        updateSql.add("cols", all_columns);
                    }
                }
                AfSimpleDB.execute(updateSql + whereSql.toString());
            } catch (Exception e) {
                e.printStackTrace();
                tPubEtlLogs.put("error_1", e.getMessage());
                tPubEtlLogs.put("is_successful", "F");
            } finally {
                tPubEtlLogs.put("job_name", queryJob.get("module_type"));
                tPubEtlLogs.put("src_object_name", queryJob.get("src_object_name"));
                tPubEtlLogs.put("des_object_name", queryJob.get("des_object_name"));
                tPubEtlLogs.put("elapsed", (System.currentTimeMillis() - start) / 1000 + "s");
            }
            try {
                // 新增日志
                AfSimpleDB.insert(new TPubEtlLogs().fromMap(tPubEtlLogs));
            } catch (Exception e) {
                System.out.println(queryJob.get("module_type") + "写入日志失败：" + e.getMessage());
            }
        }
    }

    /**
     * 根据配置信息，生成可供DataX执行的JSON文件
     * @param queryJob
     * @return 生成的文件名称
     */
    private static String createJSONINIt(Map<String, String> queryJob, String dateTime) {
        // 准备数据，把表名拼成 Schema.Table 格式
        if (AfSqlStringUtils.isNotEmpty(queryJob.get("src_system_id"))) {
            queryJob.put("src_object_name", queryJob.get("src_system_id") + "." + queryJob.get("src_object_name"));
        }
        if (AfSqlStringUtils.isNotEmpty(queryJob.get("des_system_id"))) {
            queryJob.put("des_object_name", queryJob.get("des_system_id") + "." + queryJob.get("des_object_name"));
        }

        // 判断是否需要生成,1:为空时才生成
        if (queryJob.get("is_create_script").equals("1")) {
            if (AfSqlStringUtils.isNotEmpty(queryJob.get("job_script_run_name"))) {
                String job_script_run_name = queryJob.get("job_script_run_name");
                System.out.println("不生成JSON文件：要执行的JSON文件铭为：" + job_script_run_name);
                return job_script_run_name;
            }
        }

        ///////// 生成JSON ////////////
        // 处理列
        if (!AfSqlStringUtils.isNotEmpty(queryJob.get("cols"))) {
            queryJob.put("cols", "*");
        } else {
            String cols = queryJob.get("cols").replace(" ", "").replace(",", "\",\"");
            queryJob.put("cols", cols);
        }
        // 处理split_pk
        if (!AfSqlStringUtils.isNotEmpty(queryJob.get("split_pk"))) {
            queryJob.put("split_pk", "");
        }
        // 处理where
        if (!AfSqlStringUtils.isNotEmpty(queryJob.get("where"))) {
            queryJob.put("where", "1=1");
        }

        File file = null;
        try {
            // 提取模板
            Configuration cfg = Objects.getConfigtion();
            Template tp = cfg.getTemplate(queryJob.get("job_script_template_name"));  // template/xx.xx

            // 合成输出 (output) : 直接输出到控制台显示
            // Writer out = new OutputStreamWriter(System.out);
            // tp.process(model, out);

            // 合成输出（output）：把内容输出到文件
            file = new File(getOutPutPath(), queryJob.get("src_object_name").replace(".", "_") + "_" + dateTime + ".json");
            FileWriter out1 = new FileWriter(file);
            tp.process(queryJob, out1);
        } catch (Exception e) {
            throw new RuntimeException("根据模板生成JSON文件时发生错误，具体为：" + e.getMessage());
        }
        return file.getPath();
    }

    /**
     * 根据时间，创建一个文件路径
     * @return
     */
    public static String getOutPutPath() {
        File file = new File("job", MyUtil.getPresentDate("yyyy-MM-dd"));
        file.mkdirs();
        return file.getPath();
    }
}
