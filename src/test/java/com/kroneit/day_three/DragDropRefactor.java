package com.kroneit.day_three;

import com.kroneit.pages.DragDropPage;
import com.kroneit.pages.PageManager;

public class DragDropRefactor {
    public static void main(String[] args) {
        PageManager pageManager = new PageManager();
        DragDropPage dragDropPage = pageManager.getDragDropPage();

        dragDropPage.openPage();
        dragDropPage.performDragDrop();
    }
}
