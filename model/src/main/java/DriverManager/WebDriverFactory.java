package DriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;

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
                ChromeOptions options = new ChromeOptions();
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("profile.default_content_settings.popups", 0);
                options.setExperimentalOption("prefs", prefs);
                options.addArguments("start-maximized");
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver(options);
                break;
            case FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setAcceptInsecureCerts(true);
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver(firefoxOptions);
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
