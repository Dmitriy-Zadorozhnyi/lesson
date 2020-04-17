package DriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static DriverManager.Browser.*;

public enum WebDriverFactory {
    INSTANCE;

    public static WebDriverFactory getInstance() {
        return INSTANCE;
    }
    private static WebDriver webDriver = null;

    public static WebDriver createDriver(String browser) {

        if (webDriver != null) {
            return webDriver;
        }

        if (CHROME.getTitle().equalsIgnoreCase(browser)) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        } else {
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        }
        return webDriver;
    }
    public WebDriver getDriver() {
        return webDriver;
    }
}
