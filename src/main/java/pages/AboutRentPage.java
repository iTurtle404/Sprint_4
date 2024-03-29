package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertTrue;
import static pages.TestData.*;

public class AboutRentPage {

    final WebDriver driver;
    public AboutRentPage(WebDriver driver) {
        this.driver = driver;
    }

    //локатор для поля ввода даты начала аренды
    protected static final By startRent = By.xpath(".//input[@placeholder ='* Когда привезти самокат']");
    //локатор для дроп кнопки срока аренды
    protected static final By dropTimeRent = By.className("Dropdown-arrow");
    //локатор для поля ввода срока аредны
    protected static final By stopRent = By.xpath(TIME_OF_RENT);
    //локатор для чека выбора цвета самоката
    protected static final By colourBike = By.id(COLOUR_BIKE);
    //локатор для поля ввода комментария для курьера
    protected static final By commentForRent = By.xpath(".//input[@placeholder ='Комментарий для курьера']");
    //локатор для кнопки Заказать
    protected static final By orderButton = By.xpath(".//button[(contains(@class,'Button_Middle__1CSJM')) and (text() = 'Заказать')]");
    //локатор для кнопки Да ("оформить заказ?")
    protected static final By buttonYes = By.xpath(".//button[text() = 'Да']");
    //локатор для сообщения успешного заказа
    protected static final By orderSuccess = By.xpath(".//div[text() ='Заказ оформлен']");
    //локатор для кнопки Нет ("оформить заказ?")
    protected static final By buttonNo = By.xpath(".//button[text() = 'Нет']");

    //Методы второй части страницы оформления заказа - Про аренду

    //проверка на экран успеха после кнопки "Да". Можно использовать вейтер(метод закомментирован ниже), тогда тест просто упадет
    public AboutRentPage screenOrderSuccess(){
        assertTrue("Переход на экран успеха не произошел", driver.findElements(orderSuccess).size() != 0);
        return this;
    }
    /*метод если надо проверить через вейтер:
    public AboutRentPage screenOrderSuccess(){
        new WebDriverWait(driver, Duration.ofSeconds(DEF_TIMEOUT))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(orderSuccess));
        return this;
    }*/

    public AboutRentPage closeFormConfirmOrder(){
        assertTrue("Форма подтверждения заказа не закрылась", driver.findElements(buttonNo).size() == 0);
        return this;
    }
    public AboutRentPage clickButtonNo(){
        driver.findElement(buttonNo).click();
        return this;
    }
    public AboutRentPage clickButtonYes(){
        driver.findElement(buttonYes).click();
        return this;
    }
    public AboutRentPage clickOrderButton(){
        driver.findElement(orderButton).click();
        return this;
    }
    public AboutRentPage commentForRent(){
        driver.findElement(commentForRent).sendKeys(COMMENT_FOR_RENT);
        return this;
    }
    public AboutRentPage chooseColourBike(){
        driver.findElement(colourBike).click();
        return this;
    }

    public AboutRentPage inputStartRent(){
        driver.findElement(startRent).sendKeys(DATA_START_RENT);
        return this;

    }
    public AboutRentPage clickToDropTimeRent(){
        driver.findElement(dropTimeRent).click();
        return this;
    }
    public AboutRentPage chooseStopRent(){
        driver.findElement(stopRent).click();
        return this;
    }
}
