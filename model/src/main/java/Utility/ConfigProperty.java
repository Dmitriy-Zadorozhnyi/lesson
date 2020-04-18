package Utility;

import java.io.IOException;
import java.util.Properties;

import static java.lang.String.format;

public enum ConfigProperty {
    INSTANCE;

    public static ConfigProperty getInstance() { return INSTANCE; }

    private static final String PROPERTIES_FILE = "common.properties";
    private Properties properties;

    ConfigProperty() {
        properties = new Properties();
        loadPropertiesFromFile();
    }

    private void loadPropertiesFromFile(){
        try {
            properties.load(ConfigProperty.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getBrowserName() {
        return System.getProperty("browser") != null
                ? System.getProperty("browser")
                : properties.getProperty("browser");
    }

}
