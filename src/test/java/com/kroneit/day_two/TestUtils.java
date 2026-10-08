package com.kroneit.day_two;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestUtils {

    public void selectFromDropdown(ElementsCollection optionsList, String desiredOption) {
        for (SelenideElement selenideElement : optionsList) {
            if (selenideElement.getText().equalsIgnoreCase(desiredOption)) {
                selenideElement.click();
                break;
            }
        }
    }

    public static Properties loadProperties() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream;
        if (System.getProperty("env").equalsIgnoreCase("uat")) {
            fileInputStream = new FileInputStream("src/test/resources/uat.properties");
            properties.load(fileInputStream);
        } else if (System.getProperty("env").equalsIgnoreCase("int")) {
            fileInputStream = new FileInputStream("src/test/resources/int.properties");
            properties.load(fileInputStream);
        }

        return properties;


    }
}
