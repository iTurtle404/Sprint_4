package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.Assert.assertEquals;
import static pages.TestData.*;

public class MainPage {

    final WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //локатор для кнопки Заказать в хидере
    protected static final By orderUpButton = By.className("Button_Button__ra12g");
    //локатор для кнопки Заказать в теле страницф
    protected static final By orderInsideButton = By.xpath(".//button[contains(@class,'Button_Middle__1CSJM')]");
    //локатор для кнопки Статус заказа
    protected static By statusButtom = By.className("Header_Link__1TAG7");
    //локатор для поля ввода номера заказа
    protected static final By inputOrder = By.className("Input_Input__1iN_Z");
    //локатор для кнопки Go
    protected static final By buttonGo = By.cssSelector("[class = 'Button_Button__ra12g Header_Button__28dPO']");

    //Методы Основной страницы
    public Object ScrollForOrderInsideButton() {
        return ((JavascriptExecutor) driver).executeScript(String.valueOf(ARG_FOR_SCROLL), driver.findElement(orderInsideButton));
    }

    public OrderPage clickOnInsideOrderButton() {
        driver.findElement(orderInsideButton).click();
        return new OrderPage(driver);
    }

    public OrderPage clickOnUpOrderButton() {
        driver.findElement(orderUpButton).click();
        return new OrderPage(driver);
    }

    public MainPage weitForDropList(By lokalOfList) {
        new WebDriverWait(driver, Duration.ofSeconds(DEF_TIMEOUT))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(lokalOfList));
        return this;
    }

    public MainPage clickOnSection(By dropOfList) {
        driver.findElement(dropOfList).click();
        return this;
    }

    public Object ScrollForDropList(By dropOfList) {
        return ((JavascriptExecutor) driver).executeScript(String.valueOf(ARG_FOR_SCROLL), driver.findElement(dropOfList));
    }

    public MainPage openPage() {
        driver.get(BASE_URL);
        return this;
    }

    public MainPage checkOfText(By lokalOfList, String textOfSection) {
        assertEquals(textOfSection, driver.findElement(lokalOfList).getText());
        return this;
    }

    public MainPage showStatus() {
        driver.findElement(statusButtom).click();
        return this;
    }

    public MainPage typeOrderNumber(String orederNumber) {
        driver.findElement(inputOrder).sendKeys(orederNumber);
        return this;
    }

    public TrackPage clickOnGo() {
        driver.findElement(buttonGo).click();
        return new TrackPage(driver);
    }
}
