package utils;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {

    //private static final String CONFIG_FILE_PATH = System.getProperty("user.dir") + "/src/test/resources/config_dev.properties";
    private static final Properties properties = new Properties();
    static String env = System.getProperty("env", "prep"); // Varsayılan olarak 'dev' ortamı

    static {
        try {

            FileInputStream file = new FileInputStream("src/test/resources/config_" + env + ".properties");
            properties.load(file);
        } catch (IOException e) {
            throw new RuntimeException("Konfigürasyon dosyası yüklenemedi: " + e.getMessage());
        }
    }

    public static void setProperty(String propertyName, String customProperty) {
        try {
            PropertiesConfiguration config = new PropertiesConfiguration("src/test/resources/config_" + env + ".properties");
            config.setProperty(propertyName, customProperty);
            config.save();
        } catch (ConfigurationException e) {
            throw new RuntimeException("Error loading config_dev.properties", e);
        }

    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }


}
