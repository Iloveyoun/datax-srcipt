package com.config;

import src.afsql.util.AfSqlStringUtils;

import java.util.Map;

/**
 * @title 配置类
 */
public class Config {
    private String pythonPath = "/datax.py";

    public String getPythonPath() {
        return pythonPath;
    }

    public void setPythonPath(String pythonPath) {
        this.pythonPath = pythonPath;
    }

    /**
     * 传入的MAP转换为配置类的属性
     * @param map Map
     * @return 当前对象
     */
    public Config fromMap(Map<String, String> map) {
        setPythonPath(AfSqlStringUtils.defaultIfEmpty(map.get("pythonPath"), "/datax.py"));
        return this;
    }

    @Override
    public String toString() {
        return "Config{" +
                "pythonPath='" + pythonPath + '\'' +
                '}';
    }
}
