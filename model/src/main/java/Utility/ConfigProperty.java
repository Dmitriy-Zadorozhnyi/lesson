package Utility;

import java.io.IOException;
import java.util.Properties;

public enum ConfigProperty {
    INSTANCE;

    private static final String PROPERTIES_FILE = "common.properties";
    private final Properties properties;

    public static ConfigProperty getInstance() {
        return INSTANCE;
    }

    ConfigProperty() {
        properties = new Properties();
        try {
            properties.load(ConfigProperty.class.getResourceAsStream(PROPERTIES_FILE));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Can't get properties from " + PROPERTIES_FILE, e);
        }
    }

    public String getBrowserName() {
        return System.getProperty("browser") != null
                ? System.getProperty("browser")
                : properties.getProperty("browser");
    }
}
