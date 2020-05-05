
import Utility.ExecutionListener;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


@Listeners(ExecutionListener.class)
public class Sample extends BaseTest {

    @Test(description = "openPage")
    public void openPage() {
//        driver.manage().addCookie(new Cookie("Otus1","Value1"));
//        driver.manage().addCookie(new Cookie("Otus2","Value2"));
//        driver.manage().addCookie(new Cookie("Otus3","Value3"));
//        driver.manage().addCookie(new Cookie("Otus4","Value4"));
//
//        System.out.println(driver.manage().getCookies());
//        System.out.println(driver.manage().getCookieNamed("Otus1"));
//        driver.manage().deleteCookieNamed("Otus2");
//        //driver.manage().deleteCookie(Cookie);
//        driver.manage().deleteAllCookies();
//
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().setSize(new Dimension(800,600));
//        driver.manage().window().setPosition(new Point(0,0));
//        driver.manage().window().setPosition(new Point(0,600));
//        driver.manage().window().setPosition(new Point(800,0));
//        driver.manage().window().setPosition(new Point(800,600));
//
//        WebElement element = driver.findElement(By.xpath("//a[@href=\"/categories/programming/\"]"));
//        element.getCssValue("123");
//        element.sendKeys("Hello world");
//        element.getSize();
//        element.isDisplayed();
//        element.isEnabled();

        //new WebDriverWait(driver,10).until(ExpectedConditions.visi)


        driver.get("https://ng-bootstrap.github.io/#/components/alert/examples\n");
        logger.info("Открыта страница отус");
    }

//    @Test(description = "switchProgramming", dependsOnMethods = "openPage")
//    public void program(){
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.findElement(By.xpath("//ngbd-alert-selfclosing/p/button")).click();
//        driver.findElement(By.xpath("//ngbd-alert-selfclosing/ngb-alert")).getText();
//    }
////    @Test(description = "switchOperations", dependsOnMethods = "program")
////    public void operations(){
////        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////        driver.findElement(By.xpath("//a[@href=\"/categories/operations/\"]")).click();
////    }
////    @Test(description = "switchInformation-security", dependsOnMethods = "operations")
////    public void informationSecurity(){
////        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////        driver.findElement(By.xpath("//a[@href=\"/categories/information-security/\"]")).click();
////    }
////    @Test(description = "switchData-science", dependsOnMethods = "informationSecurity")
////    public void dataScience(){
////        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////        driver.findElement(By.xpath("//a[@href=\"/categories/data-science/\"]")).click();
////    }

}