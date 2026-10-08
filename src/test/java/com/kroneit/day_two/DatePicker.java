package com.kroneit.day_two;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
public class DatePicker {
    public static void main(String[] args) {
        open("https://www.globalsqa.com/demo-site/datepicker/");

        if ($("button.fc-cta-consent").is(visible)) {
            $("button.fc-cta-consent").click();
        }

        //Actual day
        switchTo().frame($x("//div[contains(@class,'resp-tab-content-active')]/p/iframe"));
        $("input#datepicker").click();
        $("td.ui-datepicker-today").shouldBe(visible).click();
        sleep(10000);

        //Day in future
        String desiredYear = "2027";
        String desiredMonth = "January";
        String desiredDay = "13";

        $("input#datepicker").click();

        SelenideElement month = $("span.ui-datepicker-month");
        SelenideElement year = $("span.ui-datepicker-year");
        SelenideElement buttonNext = $("a.ui-datepicker-next");

        while(!year.getText().equalsIgnoreCase(desiredYear) || !month.getText().equalsIgnoreCase(desiredMonth)) {
            buttonNext.click();
        }

        ElementsCollection daysInMonth = $$("td[data-handler='selectDay']");


        for (SelenideElement dayInMonth : daysInMonth) {
            if (dayInMonth.getText().equalsIgnoreCase(desiredDay)) {
                dayInMonth.click();
                break;
            }
        }

        sleep(10000);







    }
}
