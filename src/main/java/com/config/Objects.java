package com.config;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.IOException;

/**
 * @title 定义所有常用对象
 */
public class Objects {
    public static String configPath = "env.properties";
    private static Configuration configtion;
    private static Config config;

    ////  FreeMarker 模板的配置类 /////////////////////
    public static Configuration getConfigtion() throws IOException {
        if (configtion == null) {
            initConfiguration();
        }
        return configtion;
    }

    public static void setConfigtion(Configuration configtion1) {
        configtion = configtion1;
    }

    public synchronized static void initConfiguration() throws IOException {
        if (configtion == null) {
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
            File file = new File("template");
            file.mkdir();
            cfg.setDirectoryForTemplateLoading(file); // 指定模板根目录
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            cfg.setLogTemplateExceptions(false);
            setConfigtion(cfg);
        }
    }

    ////  DataXScript 的配置类 /////////////////////
    public static Config getConfig() {
        if (config == null) {
            initConfig();
        }
        return config;
    }

    public static void setConfig(Config config1) {
        config = config1;
    }

    public synchronized static void initConfig() {
        if (config == null) {
            setConfig(ConfigFactory.createConfig(configPath));
        }
    }
}
