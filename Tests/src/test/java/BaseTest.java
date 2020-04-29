import DriverManager.WebDriverFactory;
import Utility.ConfigProperty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

public abstract class BaseTest {
    public Logger logger = LogManager.getLogger(BaseTest.class);
    protected WebDriver driver;
    protected WebElement element;

    @BeforeClass
    public void beforeClass() {
        driver = WebDriverFactory.getInstance().createDriver(ConfigProperty.getInstance().getBrowserName());
        logger.info("Драйвер поднят");
    }

//    @AfterClass
//    public void afterClass() {
//        WebDriverFactory.getInstance().getDriver().quit();
//    }


}
