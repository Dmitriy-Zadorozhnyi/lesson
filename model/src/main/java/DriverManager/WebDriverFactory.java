package DriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static DriverManager.Browser.CHROME;


public class WebDriverFactory {
    private static WebDriver webDriver = null;

    public static WebDriver getInstance(String browser) {

        WebDriver webDriver = null;

        if (webDriver != null) {
            return webDriver;
        }
        browser = browser.toLowerCase();

        if (CHROME.getTitle().equals(browser)) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        } else {
            WebDriverManager.edgedriver().setup();
            webDriver = new EdgeDriver();
        }


        return webDriver;
    }
}
