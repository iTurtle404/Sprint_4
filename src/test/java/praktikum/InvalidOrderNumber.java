package praktikum;

import org.junit.Rule;
import org.junit.Test;
import pages.MainPage;
import pages.TrackPage;

import static pages.TestData.INVALID_ORDER_NUMBER;

public class InvalidOrderNumber {
    @Rule
    public DriverRule driverRule = new DriverRule();

    @Test
    public void InvalidOrderNumber (){
    MainPage mainPage = new MainPage(driverRule.getDriver());

    mainPage.openPage()
             .showStatus()
             .typeOrderNumber(INVALID_ORDER_NUMBER);
    TrackPage trackPage = mainPage.clickOnGo();
    trackPage.waitForNotFound();
    }
}
