package praktikum;

import org.junit.Rule;
import org.junit.Test;
import pages.AboutRentPage;
import pages.MainPage;
import pages.OrderPage;

public class OrderBikePositive {
    @Rule
    public DriverRule driverRule = new DriverRule();

    //основной сквозной (путь через кнопку в хидере)
    @Test
    public void mainEtoEPositiveYes(){
    MainPage mainPage = new MainPage(driverRule.getDriver());

    mainPage.openPage();
    OrderPage orderPage = mainPage.clickOnUpOrderButton();//клик по кнопке в хидере страницы
    orderPage.inputName()
                .inputSurname()
                .inputAddress()
                .inputPhoneNumber()
                .clickDropMetro()
                .chooseMetro();

    AboutRentPage aboutRentPage = orderPage.clickFurthOrderButton();
    aboutRentPage.clickToDropTimeRent()
            .chooseStopRent()
            .chooseColourBike()
            .commentForRent()
            .inputStartRent()
            .clickOrderButton()
            .clickButtonYes(); //Баг - после нажатия кнопки не происходит переход на страницу успеха

    }

    //Проверка второй конпки "Заказать" на главной + отказ от оформления заказа
    @Test

    public void mainEtoEPositiveNo() {
    MainPage mainPage = new MainPage(driverRule.getDriver());

    mainPage.openPage()
            .ScrollForOrderInsideButton();
    OrderPage orderPage = mainPage.clickOnInsideOrderButton(); //клик по кнопке в теле страницы
    orderPage.inputName()
                .inputSurname()
                .inputAddress()
                .inputPhoneNumber()
                .clickDropMetro()
                .chooseMetro();
    AboutRentPage aboutRentPage = orderPage.clickFurthOrderButton();
    aboutRentPage.clickToDropTimeRent()
                .chooseStopRent()
                .chooseColourBike()
                .commentForRent()
                .inputStartRent()
                .clickOrderButton()
                .clickButtonNo(); //возврат на ввод инфо Про Аренду
    }
}
