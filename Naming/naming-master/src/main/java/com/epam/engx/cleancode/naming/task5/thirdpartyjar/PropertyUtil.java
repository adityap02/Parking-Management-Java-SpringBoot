package com.epam.engx.cleancode.naming.task5.thirdpartyjar;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertyUtil {

    private static final Logger LOGGER = Logger.getLogger(PropertyUtil.class.getName());
    private static final String CONFIG_FILE_NAME = "config.properties";

    private PropertyUtil() {

    }

    public static String loadProperty(String property) {
        Properties props = loadProperties();
        return props.getProperty(property);
    }

    private static Properties loadProperties() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Properties props = new Properties();
        loadPropertiesFileFromClassLoader(classLoader, props);
        return props;
    }

    private static void loadPropertiesFileFromClassLoader(ClassLoader classLoader, Properties props) {
        try (InputStream is = classLoader.getResourceAsStream(CONFIG_FILE_NAME)) {
            if (is == null) {
                throw new MissingConfigFileException("Missing properties file...");
            }
            props.load(is);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error occurred while loading properties file", e);
        }
    }

}
