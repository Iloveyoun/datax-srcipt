package com.config;

import com.utils.MyUtil;

import java.util.Map;

/**
 * @title 创建配置类的工厂
 */
public class ConfigFactory {
    public static Config createConfig(String configPath) {
        Map<String, String> map = MyUtil.readPropToMap(configPath);
        if(map == null){
            throw new RuntimeException("找不到配置文件：" + configPath, null);
        }
        return new Config().fromMap(map);
    }
}
