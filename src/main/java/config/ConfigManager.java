package config;

import enums.Environment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class ConfigManager {

    public static final Properties properties=new Properties();
    public static final Logger logger=LogManager.getLogger(ConfigManager.class);

    static {
        loadProperties();
    }


    private static void loadProperties() {

        try{
        
        FileInputStream baseFile=new FileInputStream("src/main/resources/config/config.properties");
        properties.load(baseFile);
        baseFile.close();

        Environment env= Environment.valueOf(properties.getProperty("env").toUpperCase());

        FileInputStream envConfigPath=new FileInputStream("src/main/resources/config/"+env.name().toLowerCase()+"-config.properties");
        properties.load(envConfigPath);
        envConfigPath.close();

        logger.info("Configuration Files are Loaded: Successfully");



    }catch (IOException e){

            logger.error("failed to load properties");

        }

        }

        public static  String getProperty(String key){
        return properties.getProperty(key);
        }

        public static  String getProperty(String key, String defaultValue ){
        return properties.getProperty(key, defaultValue);
          }



}
