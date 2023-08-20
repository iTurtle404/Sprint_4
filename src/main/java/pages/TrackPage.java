package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static pages.TestData.DEF_TIMEOUT;

public class TrackPage {

    final WebDriver driver;
    public TrackPage(WebDriver driver) {
        this.driver = driver;
    }

    //локатор картинки notFound
    protected static final By imgNotFound = By.cssSelector("[alt = 'Not found']");

    //Методы страницы проверки Заказа
    public TrackPage waitForNotFound() {
        new WebDriverWait(driver, Duration.ofSeconds(DEF_TIMEOUT))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(imgNotFound));
        return this;
    }
}
