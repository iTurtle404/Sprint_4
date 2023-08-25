package praktikum;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import pages.MainPage;

@RunWith(Parameterized.class)
public class DropList{
    @Rule
    public DriverRule driverRule = new DriverRule();

    //локатор для секции из дроп списка
    private final String lokOfDrop;
    //локатор для текста из секции дроп списка
    private final String lokForTextOfList;
    //установленный текст секции (с которым нужно стравнить фактическое значение)
    private final String textOfDrop;

    public DropList(String lokOfDrop, String lokForTextOfList, String textOfDrop){
        this.lokOfDrop = lokOfDrop;
        this.lokForTextOfList = lokForTextOfList;
        this.textOfDrop = textOfDrop;
    }

    @Parameterized.Parameters

    public static Object[][] dropList(){
         return new Object[][]{
                    {"accordion__heading-0","accordion__panel-0","Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                    {"accordion__heading-1","accordion__panel-1","Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                    {"accordion__heading-2","accordion__panel-2","Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                    {"accordion__heading-3","accordion__panel-3","Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                    {"accordion__heading-4","accordion__panel-4","Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                    {"accordion__heading-5","accordion__panel-5","Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                    {"accordion__heading-6","accordion__panel-6","Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                    {"accordion__heading-7","accordion__panel-7","Да, обязательно. Всем самокатов! И Москве, и Московской области."}
         };

    }

    //проверка отображения текста секций
    @Test

    public void dropListOpenPositive(){
    MainPage mainPage = new MainPage(driverRule.getDriver());

    By dropOfList= By.id(lokOfDrop);// локатор секции дроп листа(из сформированного массива текущего класса)
    By lokalOfList= By.id(lokForTextOfList);//локатор текста внутри секции (из сформированного массива текущего класса)

    mainPage.openPage()
                .ScrollForDropList(dropOfList);
    mainPage.clickOnSection(dropOfList)
                .weitForDropList(lokalOfList)
                .checkOfText(lokalOfList, textOfDrop);
    }
}
