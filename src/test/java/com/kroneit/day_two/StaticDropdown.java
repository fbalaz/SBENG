package com.kroneit.day_two;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


public class StaticDropdown {
    public static void main(String[] args) {
        open("https://rahulshettyacademy.com/AutomationPractice/");
        SelenideElement dropdown = $("select#dropdown-class-example");
        dropdown.selectOption("Option1");
        dropdown.getSelectedOption().shouldHave(exactText("Option1"));
        System.out.println("Passed");

    }
}
