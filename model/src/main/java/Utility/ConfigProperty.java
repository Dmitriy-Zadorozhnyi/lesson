package Utility;

import java.util.Properties;

public class ConfigProperty {
    Properties properties = new Properties();

    public String getBrowserName() {
        return System.getProperty("browser");
    }

}
