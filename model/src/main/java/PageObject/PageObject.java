package PageObject;

import DriverManager.WebDriverFactory;
import Utility.ConfigProperty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.util.ArrayList;
import java.util.List;




public abstract class PageObject {

    protected WebElement element;
    protected final WebDriver driver;
    protected Logger logger;
    protected String baseUrl;

    public PageObject() {
        driver = WebDriverFactory.getInstance().getDriver();
        logger = LogManager.getLogger(PageObject.class);
        baseUrl = ConfigProperty.getInstance().getBaseUrl();
    }

    private boolean isXPath(final String xpathExpression) {
        XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();
        try {
            xpath.compile(xpathExpression);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    protected final void waitUntilClickableAndClick(final String xpathOrCssSelector, final long time) {
        logger.info("WaitUntilClickable: " + xpathOrCssSelector + " | Click");
        if (isXPath(xpathOrCssSelector)) new WebDriverWait(driver, time, 250)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xpathOrCssSelector))).click();
        else new WebDriverWait(driver, time, 250)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(xpathOrCssSelector))).click();
    }

    private WebElement waitUntilVisible(final String xpathOrCssSelector, final long time) {
        logger.info("WaitUntilVisible: " + xpathOrCssSelector);
        if (isXPath(xpathOrCssSelector)) return new WebDriverWait(driver, time, 250)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathOrCssSelector)));
        else return new WebDriverWait(driver, time, 250)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(xpathOrCssSelector)));
    }

    protected final void waitUntilVisibleAndClick(final String xpathOrCssSelector, final long time) {
        logger.info("Click");
        waitUntilVisible(xpathOrCssSelector, time).click();
    }

    protected final void openUrl(final String url) {
        logger.info("Open: " + url);
        driver.get(url);
    }


}
