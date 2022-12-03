package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;


public class YandexWeatherMainPage {

    private final static String BASE_URL = "https://yandex.ru/pogoda/";
    private final static SelenideElement selectCityInput = $x("//input[@placeholder='Город или район']");
    public final static ElementsCollection citesForSelect = $$x("//li[@class='mini-suggest__item mini-suggest__item_type_nav']");

    public static void openMainPage() {
        Selenide.open(BASE_URL);
    }

    public static void valCityOnInput(String city) {
        selectCityInput.val(city);
    }

    public static void selectFirstCity() {
        citesForSelect.first().click();
    }
}