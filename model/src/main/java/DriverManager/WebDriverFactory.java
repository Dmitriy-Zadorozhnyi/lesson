package DriverManager;

import Utility.ConfigProperty;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
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
                if (ConfigProperty.getInstance().isSelenoidMode()) {
                    Proxy proxy = new Proxy();
                    proxy.setHttpProxy(ConfigProperty.getInstance().getProxyHost() + ":" + ConfigProperty.getInstance().getProxyPort());
                    HashMap<String, Object> prefs = new HashMap<>();
                    prefs.put("profile.default_content_settings.popups", 0);
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.setExperimentalOption("useAutomationExtension", false);
                    chromeOptions.setExperimentalOption("prefs", prefs);
                    chromeOptions.addArguments("--no-sandbox");
                    chromeOptions.addExtensions(new File("../Extensions/yandexAccess.crx"));
                    //chromeOptions.addArguments("headless"); // запуск браузера без
                    chromeOptions.addArguments("window-size=1920,1080");
                    chromeOptions.setCapability("enableVNC", true);
                    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                    capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                    webDriver = new RemoteWebDriver(getURL("http://" + ConfigProperty.getInstance().getRemoteDriverUrl() + ":4444/wd/hub"), capabilities);
                } else {
                    ChromeOptions options = new ChromeOptions();
                    Map<String, Object> prefs = new HashMap<String, Object>();
                    prefs.put("profile.default_content_settings.popups", 0);
                    options.setExperimentalOption("prefs", prefs);
                    options.addArguments("start-maximized");
                    options.addExtensions(new File("../Extensions/yandexAccess.crx"));
                    WebDriverManager.chromedriver().setup();
                    webDriver = new ChromeDriver(options);
                }
                break;
            case FIREFOX:
                if (ConfigProperty.getInstance().isSelenoidMode()) {
                    Proxy proxy = new Proxy();
                    proxy.setHttpProxy(ConfigProperty.getInstance().getProxyHost() + ":" + ConfigProperty.getInstance().getProxyPort());
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.setAcceptInsecureCerts(true);
                    firefoxOptions.setCapability("enableVNC", true);
                    DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                    capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, firefoxOptions);
                    capabilities.setCapability(CapabilityType.PROXY, proxy);
                    webDriver = new RemoteWebDriver(getURL("http://" + ConfigProperty.getInstance().getRemoteDriverUrl() + ":4444/wd/hub"), capabilities);
                } else {
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.setAcceptInsecureCerts(true);
                    WebDriverManager.firefoxdriver().setup();
                    webDriver = new FirefoxDriver(firefoxOptions);
                }
                break;
            case SAFARI:
                break;
            case OPERA:
                break;
            case IE:
                break;
            case EDGE:
                break;
            default:
                throw new UnsupportedOperationException(String.format("Browser %1$s is not supported!", browser));
        }
        return webDriver;

    }
    public WebDriver getDriver() {
        return webDriver;
    }

    static URL getURL(String url) {
        try {
            return new URL(url);
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
