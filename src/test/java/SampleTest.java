
import Utility.ExecutionListener;
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


@Listeners(ExecutionListener.class)

public class SampleTest {

    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(SampleTest.class);

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger.info("Драйвер поднят");
    }
    @Test(description = "open page")
    public void openPage() {
        driver.get("https://otus.ru/");
        logger.info("Открыта страница отус");
    }

    @Test(description = "login", dependsOnMethods = "open page")
    public void login(){
        driver.findElement(By.className("header2__auth js-open-modal")).click();
        driver.findElement(By.partialLinkText("/login/google-oauth2/")).click();
        driver.findElement(By.partialLinkText("/logout/"));
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
