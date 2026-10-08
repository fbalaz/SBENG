package com.kroneit.day_one;
import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class FirstTest {
    public static void main(String[] args) {

        open("https://rahulshettyacademy.com/loginpagePractise/");
        $("input#username").val("rahulshettyacademy");
        $("input#password").val("Learning@830$3mK2");
        $(by("value","user")).click();
        sleep(2000);
        $("button#okayBtn").shouldBe(visible).click();
        $("input#terms").click();
        $("input#signInBtn").click();
        $("a.btn-primary").shouldBe(visible);

    }
}