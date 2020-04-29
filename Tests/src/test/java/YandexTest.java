import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class YandexTest extends BaseTest {

    @Test(description = "openYandexMarket")
    public void openPage() {
        driver.get("https://market.yandex.ua/");
        logger.info("Открыта страница отус");

        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[contains(@href,'catalog--elektronika')]")));
//        ExpectedConditions.elementToBeClickable(catalogElektronika);
        WebElement catalogElektronika = driver.findElement(By.xpath("//a[contains(@href,'catalog--elektronika')]"));
        new WebDriverWait(driver,5).until(ExpectedConditions.elementToBeClickable(catalogElektronika));
        catalogElektronika.click();
        logger.info("Открыта страница электроники");

        new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[contains(@href, 'catalog--mobilnye-telefony')]")));
        WebElement mobilnyeTelefony = driver.findElement(By.xpath("//a[contains(@href, 'catalog--mobilnye-telefony')]"));
        mobilnyeTelefony.click();
        logger.info("Открыта страница Мобильные телефоны");

    }


//    @Test(description = "openCategory")
//    public void openCategory(){
//
//
//    }

}
