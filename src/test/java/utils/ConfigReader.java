package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();
    private static final String env;
    static {
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config/config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Error loading config.properties");
        }
        env = System.getProperty("env", properties.getProperty("env"));
    }


    public static String get(String key) {
        return properties.getProperty(env + "." + key);
    }
}