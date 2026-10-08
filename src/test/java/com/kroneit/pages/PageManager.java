package com.kroneit.pages;

import com.kroneit.day_two.DragDrop;

public class PageManager {
    private final DragDropPage dragDropPage;
    private final LoginPage loginPage;
    private final EshopPage eshopPage;
    private final CheckoutPage checkoutPage;
    private final DeliveryPage deliveryPage;

    public PageManager() {
        this.dragDropPage = new DragDropPage();
        this.loginPage = new LoginPage();
        this.eshopPage = new EshopPage();
        this.checkoutPage = new CheckoutPage();
        this.deliveryPage = new DeliveryPage();
    }

    public DragDropPage getDragDropPage() {
        return dragDropPage;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public EshopPage getEshopPage() {
        return eshopPage;
    }

    public DeliveryPage getDeliveryPage() {
        return deliveryPage;
    }

    public CheckoutPage getCheckoutPage() {
        return checkoutPage;
    }
}
