package com.kroneit.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class EshopPage {
    private final ElementsCollection productTitles = $$("h4.card-title");
    private final ElementsCollection buttonsAddToCart = $$("button.btn-info");
    private final SelenideElement buttonCheckout = $("a.btn-primary");

    public ElementsCollection getProductTitles() {
        return productTitles;
    }

    public ElementsCollection getButtonsAddToCart() {
        return buttonsAddToCart;
    }

    public SelenideElement getButtonCheckout() {
        return buttonCheckout;
    }

    public void chooseProducts(ArrayList<String> productsToAdd) {
        getButtonsAddToCart().get(0).shouldBe(visible);

        for (int i = 0; i < getProductTitles().size(); i++) {
           if (productsToAdd.contains(getProductTitles().get(i).getText())) {
               getButtonsAddToCart().get(i).click();
           }
        }
    }

    public ArrayList<String> createProductsList(String[] products) {
        ArrayList<String> productsList = new ArrayList<>();
        for (String product : products) {
            productsList.add(product);
        }
        return productsList;
    }

    public void clickCheckoutButton() {
        getButtonCheckout().click();
    }


}
