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

    public String getBaseUrl() {
        return properties.getProperty("site.url");
    }

    public String getBrowserName() {
        return System.getProperty("browser") != null
                ? System.getProperty("browser")
                : properties.getProperty("browser");
    }

    public boolean isSelenoidMode() {
        return System.getProperty("selenoid.mode") != null
                ? Boolean.parseBoolean(System.getProperty("selenoid.mode"))
                : Boolean.parseBoolean(properties.getProperty("selenoid.mode"));
    }

    public String getRemoteDriverUrl() {
        return System.getProperty("remote.driver.url") != null
                ? System.getProperty("remote.driver.url")
                : properties.getProperty("remote.driver.url");
    }

    public String getProxyHost() {
        return properties.getProperty("proxy.host");
    }

    public int getProxyPort() {
        return Integer.valueOf(properties.getProperty("proxy.port"));
    }

}
