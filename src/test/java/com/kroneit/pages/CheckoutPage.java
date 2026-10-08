package com.kroneit.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CheckoutPage {
    private final ElementsCollection productsInCartTitles = $$("h4.media-heading");
    private final SelenideElement finalCheckoutButton = $("button.btn-success");


    public ElementsCollection getProductsInCartTitles() {
        return productsInCartTitles;
    }

    public SelenideElement getFinalCheckoutButton() {
        return finalCheckoutButton;
    }

    public ArrayList<String> createProductsInCartList() {
        ArrayList<String> productsInCart = new ArrayList<>();

        for (int i = 0; i < getProductsInCartTitles().size(); i++) {
            productsInCart.add(getProductsInCartTitles().get(i).getText());
            System.out.println("Item added: " + getProductsInCartTitles().get(i).getText());
        }
        return productsInCart;
    }

    public void    finishCheckout() {
        getFinalCheckoutButton().click();
    }
}
