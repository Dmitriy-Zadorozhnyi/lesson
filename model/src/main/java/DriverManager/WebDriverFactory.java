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

     Browser currentBrowser = Browser.valueOf(browser.toUpperCase());

        switch (currentBrowser) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                break;
            default:
                throw new UnsupportedOperationException(String.format("Browser %1$s is not supported!", browser));
        }
        return webDriver;

    }
    public WebDriver getDriver() {
        return webDriver;
    }
}
