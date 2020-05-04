import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class YandexTest extends BaseTest {




    @Test(description = "openYandexMarket")
    public void openPage() {
        //driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        //driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        //driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);


        driver.get("https://market.yandex.ua/");
        logger.info("Открыта главная страница сайта");

        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'catalog--elektronika')]")));
//        ExpectedConditions.elementToBeClickable(catalogElektronika);
        WebElement catalogElektronika = driver.findElement(By.xpath("//a[contains(@href,'catalog--elektronika')]"));
        //new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(catalogElektronika));
        catalogElektronika.click();
        logger.info("Открыта страница электроники");

        new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[contains(@href, 'catalog--mobilnye-telefony')]")));
        WebElement mobilnyeTelefony = driver.findElement(By.xpath("//a[contains(@href, 'catalog--mobilnye-telefony')]"));
        mobilnyeTelefony.click();
        logger.info("Открыта страница Мобильные телефоны");

        new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@data-apiary-widget-name=\"@MarketNode/HeaderRegionPopup\"]")));
        WebElement region = driver.findElement(By.xpath("//div[@data-apiary-widget-name=\"@MarketNode/HeaderRegionPopup\"]"));
        region.click();
        logger.info("Кликнуть на выбор региона");

        new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@id=\"header-search\" and @placeholder=\"Укажите другой регион\"]")));
        WebElement inputRegion = driver.findElement(By.xpath("//input[@id=\"header-search\" and @placeholder=\"Укажите другой регион\"]"));
        inputRegion.sendKeys("Москва");
        logger.info("Написать г. Москва");

        new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//i[contains(text(), 'Москва и Московская область, Россия')]")));
        WebElement setRegion = driver.findElement(By.xpath("//i[contains(text(), 'Москва и Московская область, Россия')]"));
        setRegion.click();
        logger.info("Выбрать г. Москва");

        new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[contains(text(), 'Продолжить с новым регионом')]")));
        WebElement confirmRegion = driver.findElement(By.xpath("//span[contains(text(), 'Продолжить с новым регионом')]"));
        confirmRegion.click();
        logger.info("Нажать кнопку подтверждения");



        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement setCompanyXiaomi = driver.findElement(By.xpath("//input[@id=\"7893318_7701962\"]/../div"));
        WebElement ZTE = driver.findElement(By.xpath("//input[@id=\"7893318_1007740\"]"));

        Actions builder = new Actions(driver);
        builder.moveToElement(ZTE).build().perform();
        new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(setCompanyXiaomi));
        setCompanyXiaomi.click();
        logger.info("Выбрать в фильтре Xiaomi");

        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        //new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@id=\"7893318_10796752\"]")));
        WebElement setCompanyOnePlus = driver.findElement(By.xpath("//input[@id=\"7893318_10796752\"]/../div"));
        builder.moveToElement(setCompanyOnePlus).build().perform();
        setCompanyOnePlus.click();
        logger.info("Выбрать в фильтре OnePlus");

        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        //new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@data-bem, 'aprice')]")));
        WebElement setFilterPrice = driver.findElement(By.xpath("//div[contains(@data-bem, 'aprice')]"));
        builder.moveToElement(setFilterPrice).build().perform();
        setFilterPrice.click();
        logger.info("Фильтруем по цене");

    }


//    @Test(description = "openCategory")
//    public void openCategory(){
//
//
//    }

}
