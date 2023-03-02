package com.automation.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileUtils {
    private static String CONFIG_PATH= "src/main/java/com/automation/configuration/configs.properties";

    public static String getProperty(String key){
        Properties properties = new Properties();
        String value = null;
        FileInputStream file = null;

        try{
            file = new FileInputStream(CONFIG_PATH);
            properties.load(file);
            value = properties.getProperty(key);
            file.close();
            return value;
        }catch (Exception e){
            System.out.println("Error: "+ e.getMessage());
        }
        return value;
    }

    public static void setProperty(String key, String value){
        Properties properties = new Properties();
        FileOutputStream file = null;

        try{
            file = new FileOutputStream(CONFIG_PATH);
            properties.setProperty(key, value);
            properties.store(file,"Set success");
            file.close();
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
