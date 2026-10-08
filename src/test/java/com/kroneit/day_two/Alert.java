package com.kroneit.day_two;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


public class Alert {

    public static void main(String[] args) {
        open("https://rahulshettyacademy.com/AutomationPractice/");
        $("input#name").val("Filip");
        $("input#alertbtn").click();
        sleep(5000);
        switchTo().alert().accept();
        sleep(10000);
    }
}
