import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class YandexTest extends BaseTest {

    @DataProvider(name = "test1")
    public Object[][] createData1() {
        return new Object[][] {
                { "1" }, { "2" }, { "3" }, { "4" }, { "5" },
                { "6" }, { "7" }, { "8" }, { "9" }, { "10" },
                { "11" }, { "12" }, { "13" }, { "14" }, { "15" },
                { "16" }, { "17" }, { "18" }, { "19" }, { "20" },
        };
    }


    @Test(dataProvider = "test1")
    public void openPage(String n1) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        //driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
        driver.get("https://market.yandex.ua/catalog--elektronika/54440");
//        logger.info("Открыта главная страница сайта");
//
//
////        new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'catalog--elektronika')]")));
//        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//        WebElement catalogElektronika = driver.findElement(By.xpath("//a[contains(@href,'catalog--elektronika')]"));
//        catalogElektronika.click();
        logger.info("Открыта страница электроники");

        new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[contains(@href, 'catalog--mobilnye-telefony')]")));
        driver.findElement(By.xpath("//a[contains(@href, 'catalog--mobilnye-telefony')]")).click();
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


        new WebDriverWait(driver,30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id=\"7893318_1007740\"]")));
        WebElement ZTE = driver.findElement(By.xpath("//input[@id=\"7893318_1007740\"]"));
        Actions builder = new Actions(driver);
        builder.moveToElement(ZTE).build().perform();
        logger.info("Переходим к ZTE");

        WebElement setCompanyXiaomi = driver.findElement(By.xpath("//input[@id=\"7893318_7701962\"]/../div"));
        setCompanyXiaomi.click();
        logger.info("Выбрать в фильтре Xiaomi");



        new WebDriverWait(driver,30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id=\"7893318_153061\"]")));
        WebElement setCompanySamsung = driver.findElement(By.xpath("//input[@id=\"7893318_153061\"]/../div"));
        builder.moveToElement(setCompanySamsung).build().perform();
        setCompanySamsung.click();
        logger.info("Выбрать в фильтре OnePlus");

        new WebDriverWait(driver,30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@data-bem, 'aprice')]")));
        WebElement setFilterPrice = driver.findElement(By.xpath("//div[contains(@data-bem, 'aprice')]"));
        builder.moveToElement(setFilterPrice).build().perform();
        setFilterPrice.click();
        logger.info("Фильтруем по цене");


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement addXiaomi = returnOneLocator("//img[contains(@title, 'Xiaomi')]/../../..//div[@data-zone-name=\"ComparisonTumbler\"]", "//a[contains(@title, 'Xiaomi')]/..//div[contains(@data-bem, 'compare')]");
        builder.moveToElement(addXiaomi).build().perform();
        logger.info("Перешли к елементу");
        builder.click(addXiaomi).build().perform();
        logger.info("Кликнули на елемент");

        new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"popup-informer__content\"]")));
        WebElement notifyer = driver.findElement(By.xpath("//div[@class=\"popup-informer__content\"]"));

        Assert.assertNotNull(notifyer);
        logger.info("Появился нотификейшн");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement addSamsung = returnOneLocator("//img[contains(@title, 'Samsung')]/../../..//div[@data-zone-name=\"ComparisonTumbler\"]", "//a[contains(@title, 'Samsung')]/..//div[contains(@data-bem, 'compare')]");
        builder.moveToElement(addSamsung).build().perform();
        logger.info("Перешли к елементу");
        builder.click(addSamsung).build().perform();
        logger.info("Кликнули на елемент");

        new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"popup-informer__content\"]")));
        notifyer = driver.findElement(By.xpath("//div[@class=\"popup-informer__content\"]"));


        Assert.assertNotNull(notifyer);
        logger.info("Появился нотификейшн");

        WebElement compareButton = driver.findElement(By.xpath("//a[contains(@href,'compare?track=rmmbr')]"));
        compareButton.click();
        logger.info("Переход на сравнение");

        new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@data-bem, 'n-compare-cell')]")));
        ArrayList<WebElement> list = new ArrayList<WebElement>(driver.findElements(By.xpath("//div[contains(@data-bem, 'n-compare-cell')]")));

        Assert.assertEquals(list.size(),2, "Колличество елементов 2");
        logger.info("Колличество елементов 2");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement allCharacters = driver.findElement(By.xpath("//span[text()=\"все характеристики\"]"));
        allCharacters.click();
        logger.info("Все характеристики");

        new WebDriverWait(driver,30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()=\"Операционная система\"]")));
        WebElement os = driver.findElement(By.xpath("//div[text()=\"Операционная система\"]"));

        Assert.assertNotNull(os, "Характеристика ОС присутствует");
        logger.info("Характеристика ОС присутствует");

        WebElement distinctCharacters = driver.findElement(By.xpath("//span[text()=\"различающиеся характеристики\"]"));
        distinctCharacters.click();


        Assert.assertFalse(isElementVisible("//div[text()=\"Операционная система\"]"));
        logger.info("Характеристика ОС отсутствует");

    }

    public WebElement returnOneLocator(String locator1, String locator2) {
        try {
            driver.findElement(By.xpath(locator1));
            return driver.findElement(By.xpath(locator1));
        } catch (Exception e) {
            return driver.findElement(By.xpath(locator2));
        }
    }

    public boolean isElementVisible(String xPathLocator) {
        return driver.findElement(By.xpath(xPathLocator)).isDisplayed();
    }

    public boolean isElementPresent(String xPathLocator) {
        try {
            driver.findElement(By.xpath(xPathLocator));
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}
