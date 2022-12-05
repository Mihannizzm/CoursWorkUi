package testSteps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.DetailsWeatherPage;
import pageObjects.YandexWeatherMainPage;


import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class YandexWeatherTestSteps {
    private static String cityForPrint;

    @Given("^Открываю главную страницу сервиса Яндекс погода$")
    public void openMainPage() {
        YandexWeatherMainPage.openMainPage();
    }

    @When("^Ввожу в строку поиска города - '(.+)'$")
    public void selectCity(String city) {
        YandexWeatherMainPage.valCityOnInput(city);
        cityForPrint = city;
    }

    @And("^Закрываю всплывающее окно$")
    public void closeModalWindow() {
        if (YandexWeatherMainPage.buttonClose.isDisplayed()) {
            YandexWeatherMainPage.clickClose();
        }
    }

    @Then("^Проверяю что отображается выпадающий список населенных пунктов$")
    public void checkListSites() {
        for (int i = 0; i < YandexWeatherMainPage.citesForSelect.size(); i++) {
            YandexWeatherMainPage.citesForSelect.get(i).shouldBe(Condition.visible);
        }
    }

    @And("^Выбираю первый населенный пункт из списка$")
    public void selectFirstCity() {
        if (YandexWeatherMainPage.buttonClose.isDisplayed()) {
            YandexWeatherMainPage.clickClose();
            selectCity(cityForPrint);
        }
        YandexWeatherMainPage.selectFirstCity();
    }

    @And("^Нажимаю на '(.+)'$")
    public void clickOn (String text) {
        $(byText(text)).click();
    }

    @Then("^Проверяю, что отображаются карточки с подробным прогнозом$")
    public void checkTableWithWeather() {
        for (int i = 0; i < DetailsWeatherPage.tablesWithWeather.size(); i++) {
            DetailsWeatherPage.tablesWithWeather.get(i).shouldBe(Condition.visible);
        }
    }

    @And("^Вывожу в консоль прогноз погоды за (\\d+) дней$")
    public void printWeather (int countDays) {
        System.out.println("Прогноз погоды в городе " + cityForPrint + " за " + countDays + " дней:");
        for (int i = 0; i < countDays; i++) {
            DetailsWeatherPage.getWeatherForDay(i).forEach(System.out::println
            );
            System.out.println("\n");
        }
    }
}