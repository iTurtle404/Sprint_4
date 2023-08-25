package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static pages.TestData.*;

public class OrderPage {

    final WebDriver driver;
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //локатотр для поля ввода имени пользователя
    protected static final By inputName = By.xpath (".//input[@placeholder ='* Имя']");
    //локатор для поля ввода фамилии пользователя
    protected static final By inputSurname = By.xpath(".//input[@placeholder ='* Фамилия']");
    //локатор для поля ввода адреса доставки
    protected static final By inputAddress = By.xpath(".//input[@placeholder ='* Адрес: куда привезти заказ']");
    //локатор для поля выбора станции метро
    protected static final By DropMetro = By.xpath(".//input[@placeholder ='* Станция метро']");
    //локатор для выбора станции метро пользователя из списка
    protected static final By chooseMetro = By.xpath(METRO_USER);
    //локатор для поля ввода номера телефона пользователя
    protected  static final By inputPhoneNumber = By.xpath(".//input[@placeholder ='* Телефон: на него позвонит курьер']");
    //локатор для кнопки Далее
    protected static final By furthOrderButton = By.xpath("//button[contains(@class, 'Button_Middle__1CSJM')]");

    //Методы страницы Заказа

    public AboutRentPage clickFurthOrderButton(){
        driver.findElement(furthOrderButton).click();
        return new AboutRentPage(driver);
    }
    public OrderPage inputName(){
        driver.findElement(inputName).sendKeys(NAME_USER);
        return this;
    }
    public OrderPage inputSurname(){
        driver.findElement(inputSurname).sendKeys(SURNAME_USER);
        return this;
    }
    public OrderPage inputAddress(){
        driver.findElement(inputAddress).sendKeys(ADRESS_USER);
        return this;
    }
    public OrderPage clickDropMetro(){
        driver.findElement(DropMetro).click();
        return this;
    }
    public OrderPage chooseMetro(){
        driver.findElement(chooseMetro).click();
        return this;
    }
    public OrderPage inputPhoneNumber(){
        driver.findElement(inputPhoneNumber).sendKeys(PHONENUMBER_USER);
        return this;
    }
}
