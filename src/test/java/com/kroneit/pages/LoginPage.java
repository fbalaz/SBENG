package com.kroneit.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private final SelenideElement username = $("#username");
    private final SelenideElement password = $("#password");
    private final SelenideElement buttonSignIn = $("#signInBtn");

    public SelenideElement getUsername() {
        return username;
    }

    public SelenideElement getPassword() {
        return password;
    }

    public SelenideElement getButtonSignIn() {
        return buttonSignIn;
    }

    public void logIn(String username, String password) {
        getUsername().val(username);
        getPassword().val(password);
        getButtonSignIn().click();
    }

    public void openPage(String url) {
        open(url);
    }
}
