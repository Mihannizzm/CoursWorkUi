package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class YandexWeatherMainPage {

    private final static String BASE_URL = "https://yandex.ru/pogoda/";
    private final static SelenideElement selectCityInput = $x("//input[@placeholder='Город или район']");
    public final static ElementsCollection citesForSelect = $$x("//li[@class='mini-suggest__item mini-suggest__item_type_nav']");
    public static SelenideElement buttonClose = $(byText("Закрыть"));

    public static void openMainPage() {
        Selenide.open(BASE_URL);
        getWebDriver().manage().window().maximize();
    }

    public static void valCityOnInput(String city) {
        selectCityInput.val(city);
    }

    public static void selectFirstCity() {
        citesForSelect.first().click();
    }

    public static void clickClose() {
        buttonClose.click();
    }
}