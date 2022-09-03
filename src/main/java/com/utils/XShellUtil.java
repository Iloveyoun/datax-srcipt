package com.utils;

import src.afsql.util.AfSqlStringUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * @title 执行Shell命令工具类
 */
public class XShellUtil {
    private static ProcessBuilder processBuilder = new ProcessBuilder();

    /**
     * 执行Shell命令
     * @param cmd 命令
     * @param path 命令的工作目录
     * @return
     */
    public static Map<String, String> run(String cmd, String path) {
        Map<String, String> runingInfo = new HashMap<>();
        try {
            if (AfSqlStringUtils.isNotEmpty(path)) {
                processBuilder.directory(new File(path));
            }
            if(System.getProperties().getProperty("os.name").toUpperCase().indexOf("WINDOWS") != -1) {
                processBuilder.command("cmd", "/c", cmd);
            } else {
                processBuilder.command("/bin/sh", "-c", cmd);
            }
            Process process = processBuilder.start();
            runingInfo.putAll(printResults(process));
        } catch (Exception e) {
            e.printStackTrace();
            runingInfo.put("error_2", e.getMessage());
            runingInfo.put("is_successful", "F");
        }
        return runingInfo;
    }

    /**
     * 将执行命令的打印输出
     * @param process
     * @throws IOException
     * @throws InterruptedException
     */
    public static Map printResults(Process process) throws IOException {
        Map<String, String> runingInfo = new HashMap<>();
        try {
            // 阻塞等待执行完之后才继续执行后面的代码，0：表示正常执行。
            // 如果不加这个，打印日志就是陆续打印，
            // int i = process.waitFor();
            String[] infoKey = new String[]{"datax_start_time", "datax_end_time", "datax_elapsed"
                    , "datax_avg_flowrate", "datax_input_speed", "datax_output_num", "datax_fail_num"};
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream(), Charset.forName("UTF-8")));
            String line = null;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                if (line.indexOf("总数") != -1 || line.indexOf("速度") != -1
                        || line.indexOf("任务启动时刻") != -1 || line.indexOf("任务结束时刻") != -1
                        || line.indexOf("任务总计耗时") != -1 || line.indexOf("任务平均流量") != -1 ) {
                    String[] strArray = XStringUtil.getStrArray(line, ":");
                    runingInfo.put(infoKey[i], strArray[1].trim());
                    i ++;
                }
                System.out.println(line);
            }
            if (!AfSqlStringUtils.isNotEmpty(runingInfo.get("datax_end_time"))) {
                runingInfo.put("is_successful", "F");
                runingInfo.put("error_3", "DataX脚本执行错误，请查看控制台或者日志的报错信息，认真检查JSON文件。");
            }
        } catch (Exception e) {
            e.printStackTrace();
            runingInfo.put("error_3", e.getMessage());
            runingInfo.put("is_successful", "F");
        }
        return runingInfo;
    }
}
