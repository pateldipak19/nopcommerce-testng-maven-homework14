package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.testng.Reporter;

public class ComputersPage extends Utility {

    By computersLink = By.xpath("//ul[@class='top-menu notmobile']//a[text()='Computers ']");
    HomePage homePage = new HomePage();
    By desktopLink = By.xpath("//h2[@class='title']/a[@href='/desktops']");

    public void clickOnComputer() {
        Reporter.log("Click on computer tab "+computersLink.toString()+"<br>");
        clickOnElement(waitUntilVisibilityOfElementLocated(computersLink, 80));
    }

    public void clickOnDesktop() {
        Reporter.log("Click on desktop option "+desktopLink.toString()+"<br>");
        clickOnElement(waitUntilVisibilityOfElementLocated(desktopLink, 80));
    }


}
