package com.kroneit.day_two;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;

import java.util.Set;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
public class TabsSwitching {

    public static void main(String[] args) {

        open("https://qaplayground.com/practice/tabs-windows");

        String defaultHandle = WebDriverRunner.getWebDriver().getWindowHandle();
        $("button#tw-tab-a").click();
        Set<String> windowHandles = WebDriverRunner.getWebDriver().getWindowHandles();
        sleep(5000);

        for (String windowHandle : windowHandles) {
            if (!windowHandle.equalsIgnoreCase(defaultHandle)) {
                switchTo().window(windowHandle);
                break;
            }
        }
        switchTo().window(defaultHandle);
        /*
        switchTo().window("QA Playground — Practice Selenium, Playwright & Cypress");
        sleep(5000);
        switchTo().window(0);
        sleep(10000); */

    }
}
