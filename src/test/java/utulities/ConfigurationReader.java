package utulities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties;
    static {
        //Path of the configuration.properties file
        String path = "config.properties";
        FileInputStream fileInputStream;
        try {
            //Opening the configuration.properties file
            fileInputStream = new FileInputStream(path);
            //Loading and reading the file
            properties = new Properties();
            properties.load(fileInputStream);
            //Closing the file
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    //Create a method to READ
    //This method will get the KEY and return the VALUE
    public static String getProperty(String key){

        return properties.getProperty(key);
    }
}


