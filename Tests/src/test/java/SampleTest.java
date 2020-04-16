
import Utility.ExecutionListener;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(ExecutionListener.class)
public class SampleTest extends BaseTest {

    @Test(description = "openPage")
    public void openPage() {
        driver.get("https://otus.ru/");
        logger.info("Открыта страница отус");
    }

    @Test(description = "login", dependsOnMethods = "openPage")
    public void login(){
        driver.findElement(By.className("header2__auth")).click();
        driver.findElement(By.className("new-ic-google-white-square")).click();
        logger.info("Пользователь авторизовался");
    }

}