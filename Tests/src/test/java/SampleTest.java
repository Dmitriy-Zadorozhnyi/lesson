
import DriverManager.WebDriverFactory;
import Utility.ExecutionListener;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;


@Listeners(ExecutionListener.class)
public class SampleTest {

    WebDriver wd = WebDriverFactory.getInstance("chrome");
    private Logger logger = LogManager.getLogger(SampleTest.class);

    @BeforeClass
    public void setUp() {
        logger.info("Драйвер поднят");
    }
    @Test(description = "openPage")
    public void openPage() {
        wd.get("https://otus.ru/");
        logger.info("Открыта страница отус");
    }

    @Test(description = "login", dependsOnMethods = "openPage")
    public void login(){
        driver.findElement(By.className("header2__auth")).click();
        driver.findElement(By.className("new-ic-google-white-square")).click();
        logger.info("Пользователь авторизовался");
    }

    @Test(description = "logout", dependsOnMethods = "login")
    public void logout(){
        driver.findElement(By.partialLinkText("/logout/"));
        logger.info("Пользователь вышел с личного кабинета");
    }

    @AfterClass
    public void setDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
