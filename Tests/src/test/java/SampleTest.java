
import Utility.ExecutionListener;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


@Listeners(ExecutionListener.class)
public class SampleTest extends BaseTest {

    @Test(description = "openPage")
    public void openPage() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://otus.ru/");
        logger.info("Открыта страница отус");
    }

    @Test(description = "switchProgramming", dependsOnMethods = "openPage")
    public void program(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@href=\"/categories/programming/\"]")).click();
    }
    @Test(description = "switchOperations", dependsOnMethods = "program")
    public void operations(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@href=\"/categories/operations/\"]")).click();
    }
    @Test(description = "switchInformation-security", dependsOnMethods = "operations")
    public void informationSecurity(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@href=\"/categories/information-security/\"]")).click();
    }
    @Test(description = "switchData-science", dependsOnMethods = "informationSecurity")
    public void dataScience(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@href=\"/categories/data-science/\"]")).click();
    }

}