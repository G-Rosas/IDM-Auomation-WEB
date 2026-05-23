package utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Properties properties =
            new Properties();
    static {
        try {
            InputStream input =
                    ConfigReader.class.getClassLoader().getResourceAsStream("config/config.properties");
            properties.load(input);

        } catch (Exception e) {
            throw new RuntimeException("Error loading config.properties");
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}