package pageObjects;

import com.codeborne.selenide.ElementsCollection;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;

public class DetailsWeatherPage {
    public final static ElementsCollection tablesWithWeather = $$x("//article[@class='card']");
    private final static ElementsCollection dayInfo = $$x("//h2[contains(@class,'title')]/..//span[@class='a11y-hidden']");
    private final static ElementsCollection tempMorning = $$x("//td[contains(@class, 'body-cell_wrapper')]/..//span[contains(text(),'утром')]");
    private final static ElementsCollection tempDay = $$x("//td[contains(@class, 'body-cell_wrapper')]/..//span[contains(text(),'днём')]");
    private final static ElementsCollection tempEvening = $$x("//td[contains(@class, 'body-cell_wrapper')]/..//span[contains(text(),'вечером')]");
    private final static ElementsCollection tempNight = $$x("//td[contains(@class, 'body-cell_wrapper')]/..//span[contains(text(),'ночью')]");


    public static List getWeatherForDay(int indexDay) {
        List<String> stringsForPrint = new ArrayList<>();
        stringsForPrint.add(dayInfo.get(indexDay).getOwnText());
        stringsForPrint.add(tempMorning.get(indexDay).getOwnText());
        stringsForPrint.add(tempDay.get(indexDay).getOwnText());
        stringsForPrint.add(tempEvening.get(indexDay).getOwnText());
        stringsForPrint.add(tempNight.get(indexDay).getOwnText());
        return stringsForPrint;
    }
}