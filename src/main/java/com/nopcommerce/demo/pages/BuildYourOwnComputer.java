package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.testng.Reporter;

public class BuildYourOwnComputer extends Utility {

    By buildYourOwnComputerText = By.xpath("//h1[contains(text(),'Build your own computer')]");
    By processor = By.xpath("//dd[@id='product_attribute_input_1']/select[@id='product_attribute_1']");
    By rAM = By.xpath("//dd[@id='product_attribute_input_2']/select[@id='product_attribute_2']");
    By radio400GB = By.xpath("//ul[@class='option-list']/li[@data-attr-value='7']/input[@id='product_attribute_3_7']");
    By radioVistaPremium = By.xpath("//li[@data-attr-value='9']/input[@id='product_attribute_4_9']");
    By totalCommander = By.xpath("//input[@id='product_attribute_5_12']");
    By totalPrice = By.xpath("//div[@class='product-price']/span[@id='price-value-1']");
    By addToCart = By.xpath("//div[@class='add-to-cart-panel']/button[@id='add-to-cart-button-1']");
    By TopGreenBarText = By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]");


    public String actualBuildYourOwnComputerText() {
        Reporter.log("Getting build computer text " + buildYourOwnComputerText.toString() + "<br>");
        return waitUntilVisibilityOfElementLocated(buildYourOwnComputerText, 80).getText();
    }

    public void selectIntelPentiumProcessor() {
        Reporter.log("Select processor option " + processor.toString() + "<br>");
        selectByValueFromDropDown(waitUntilVisibilityOfElementLocated(processor, 80), "1");
    }

    public void select8BGRAM() {
        Reporter.log("Select RAM option " + rAM.toString() + "<br>");
        selectByValueFromDropDown(waitUntilVisibilityOfElementLocated(rAM, 80), "5");
    }

    public void clickOn400GBRadioButton() {
        Reporter.log("Click on radio button " + radio400GB.toString() + "<br>");
        clickOnElement(waitUntilVisibilityOfElementLocated(radio400GB, 80));
    }

    public void clickOnVistaPremiumRadioButton() {
        Reporter.log("Click on radio button " + radioVistaPremium.toString() + "<br>");
        clickOnElement(waitUntilVisibilityOfElementLocated(radioVistaPremium, 80));
    }

    public void checkBoxTotalCommander() {
        Reporter.log("Click on check box " + totalCommander.toString() + "<br>");
        clickOnElement(waitUntilVisibilityOfElementLocated(totalCommander, 80));
    }

    public String actualTotalPrice() {
        Reporter.log("Getting total price from element " + totalPrice.toString() + "<br>");
        return waitUntilVisibilityOfElementLocated(totalPrice, 80).getText();
    }

    public void clickToAddBuildProductToCart() {
        Reporter.log("Click on add to cart button " + addToCart.toString() + "<br>");
        clickOnElement(waitUntilVisibilityOfElementLocated(addToCart, 80));
    }

    public String actualTopGreenBarText() {
        Reporter.log("Getting green bar message " + TopGreenBarText.toString() + "<br>");
        return waitUntilVisibilityOfElementLocated(TopGreenBarText, 80).getText();
    }


}
