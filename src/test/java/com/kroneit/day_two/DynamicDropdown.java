package com.kroneit.day_two;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class DynamicDropdown {
    public static void main(String[] args) {
        open("https://rahulshettyacademy.com/AutomationPractice/");
        SelenideElement dropdown = $("input#autocomplete");
        dropdown.val("Slo");
        $("ul#ui-id-1").shouldBe(visible);
    //  ElementsCollection optionsList = $$("li.ui-menu-item");
        ElementsCollection optionsListAlternative = $("ul#ui-id-1").findAll("li");
        TestUtils testUtils = new TestUtils();
        testUtils.selectFromDropdown(optionsListAlternative,"Slovenia");
        dropdown.shouldHave(value("Slovenia"));


    }
}
