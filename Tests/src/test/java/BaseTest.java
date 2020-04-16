import DriverManager.WebDriverFactory;
import Utility.ConfigProperty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public abstract class BaseTest {
    public Logger logger = LogManager.getLogger(BaseTest.class);
    protected WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = WebDriverFactory.getInstance().createDriver("chrome");
        logger.info("Драйвер поднят");
        //String browserName = ConfigProperty.getInstance().getBrowserName();
    }

    @AfterClass
    public void afterClass() {
        WebDriverFactory.getInstance().getDriver().quit();
    }

}
