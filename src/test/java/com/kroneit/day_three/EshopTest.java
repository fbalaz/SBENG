package com.kroneit.day_three;

import com.codeborne.selenide.Configuration;
import com.kroneit.day_two.TestUtils;
import com.kroneit.pages.*;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.sleep;

public class EshopTest {

    private final PageManager pageManager = new PageManager();
    private final LoginPage loginPage = pageManager.getLoginPage();
    private final  EshopPage eshopPage = pageManager.getEshopPage();
    private final CheckoutPage checkoutPage = pageManager.getCheckoutPage();
    private final DeliveryPage deliveryPage = pageManager.getDeliveryPage();
    private static Properties properties;

    @BeforeAll
    public static void setUp() throws IOException {
        Configuration.timeout = 10000;
        properties = TestUtils.loadProperties();
    }

    @BeforeEach
    public void openLogonPage() {
        Configuration.timeout = 10000;
        loginPage.openPage(properties.getProperty("url"));
    }


    @Test
    public void endToEndProcess() {
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
       loginPage.logIn(username,password);
       String[] products = {"Blackberry", "Nokia Edge"};
        ArrayList<String> productsToAdd = eshopPage.createProductsList(products);
       eshopPage.chooseProducts(productsToAdd);
       //eshopPage.chooseProducts(eshopPage.createProductsList(new String[]{"Nokia Edge", "Blackberry"}));
       eshopPage.clickCheckoutButton();
       ArrayList<String> productsInCart = checkoutPage.createProductsInCartList();

        Collections.sort(productsToAdd);
        Collections.sort(productsInCart);

       Assertions.assertEquals(productsToAdd,productsInCart);
       checkoutPage.finishCheckout();
       deliveryPage.chooseDeliveryCountry("Slovakia");
       deliveryPage.finishPurchase();
        sleep(5000);
    }

    @Test
    public void negativeTest() {
        loginPage.logIn("rahulshettyacademy","Learning@830$3mK2");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Test finished");
    }

    @AfterAll
    public static void endOdfTests() {
        System.out.println("End of testing");
    }

}
