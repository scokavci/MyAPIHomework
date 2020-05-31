package com.automation.utilities;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ConfigurationReader {
    private static final Properties properties;

    static{
        try {
            FileInputStream fileInputStream = new FileInputStream("configuration.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties file!");
        }

    }

    public static String getProperty(String propertyName){
           return properties.getProperty(propertyName);
    }
}
