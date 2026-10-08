package com.kroneit.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.kroneit.day_two.TestUtils;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DeliveryPage {

    TestUtils testUtils = new TestUtils();

    private final SelenideElement countryDropdown = $("input#country");
    private final SelenideElement optionsList = $("div.suggestions");
    private final ElementsCollection countriesOptions = $$("div.suggestions ul li");
    private final SelenideElement purchaseButton = $("input.btn-success");
    private final SelenideElement alertSuccess = $("div.alert-success");

    public SelenideElement getCountryDropdown() {
        return countryDropdown;
    }

    public SelenideElement getOptionsList() {
        return optionsList;
    }

    public ElementsCollection getCountriesOptions() {
        return countriesOptions;
    }

    public SelenideElement getPurchaseButton() {
        return purchaseButton;
    }

    public SelenideElement getAlertSuccess() {
        return alertSuccess;
    }

    public void chooseDeliveryCountry(String country) {
        getCountryDropdown().val(country);
        getOptionsList().shouldBe(visible);
        testUtils.selectFromDropdown(getCountriesOptions(),country);
    }

    public void finishPurchase() {
        getPurchaseButton().click();
        getAlertSuccess().shouldHave(text("Success!"));
    }
}
