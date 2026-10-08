package com.kroneit.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;

public class DragDropPage {
    private final SelenideElement draggable = $("div#draggable1");
    private final SelenideElement droppable = $("div#droppable1");

    public SelenideElement getDraggable() {
        return draggable;
    }

    public SelenideElement getDroppable() {
        return droppable;
    }

    public void openPage() {
        open("https://testpages.eviltester.com/pages/interaction/drag-drop/");
    }

    public void performDragDrop() {
        actions().dragAndDrop(draggable,droppable).perform();
        droppable.shouldHave(text("Dropped!"));
        sleep(10000);
    }
}
