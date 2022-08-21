package com.run;

import com.entity.TPubEtlJobs;
import com.utils.XStringUtil;
import src.afsql.db.AfSimpleDB;
import src.afsql.util.AfSqlStringUtils;
import src.afsql.util.AfSqlWhere;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Entry {
    public static void main(String[] args) throws Exception {
        // 1、拿到输入的参数：
        // 1、参数转换：1 ZZ1 CG8TZ1.TDOBC01
        Map<String, String> paramMap = parametricTransform(args);

        // 2、查询配置
        String sql = "SELECT * FROM t_pub_etl_jobs";
        AfSqlWhere where = new AfSqlWhere();
        where.add2("valid_flag", Integer.valueOf(paramMap.get("validFlag")), paramMap.get("validFlag") != null);
        where.add2("module_type", paramMap.get("moduleType"), paramMap.get("moduleType") != null);
        where.add2("src_system_id", paramMap.get("srcObjectId"), paramMap.get("srcObjectId") != null);
        where.add2("src_object_name", paramMap.get("srcObjectName"), paramMap.get("srcObjectName") != null);
        List<TPubEtlJobs> queryJobs = AfSimpleDB.query(sql + where, TPubEtlJobs.class);
        for (TPubEtlJobs queryJob : queryJobs) {
            System.out.println(queryJob);
        }

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
            throw new RuntimeException("参数个数输入有误，请检查后再试！");
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
}
