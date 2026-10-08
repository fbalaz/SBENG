package com.kroneit.day_two;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
public class DragDrop {
    public static void main(String[] args) {
        open("https://testpages.eviltester.com/pages/interaction/drag-drop/");
        SelenideElement draggable = $("div#draggable1");
        SelenideElement droppable = $("div#droppable1");

        actions().dragAndDrop(draggable,droppable).perform();

        droppable.shouldHave(text("Dropped!"));
        sleep(10000);
    }
}
