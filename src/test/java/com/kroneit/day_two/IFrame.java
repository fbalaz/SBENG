package com.kroneit.day_two;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
public class IFrame {
    public static void main(String[] args) {
        open("https://rahulshettyacademy.com/AutomationPractice/");
        $("iframe#courses-iframe").scrollIntoCenter();
        switchTo().frame("courses-iframe");
        $("a.register-btn").click();
        switchTo().defaultContent();
        $("#dropdown-class-example").scrollIntoCenter();
        sleep(10000);
    }
}
