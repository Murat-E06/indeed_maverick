package com.indeed.uk.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static final Properties properties = new Properties();

    static {
        try {
            properties.load(new FileInputStream("configuration.properties"));
        } catch (IOException e) {
            System.out.println("File not found in the ConfigurationReader class.");
            e.printStackTrace();
        }
    }

    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }
    public static void setProperty(String keyword, String newValue){
        properties.setProperty(keyword, newValue);
    }

}
