package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends Utility {

    By titleText = By.xpath("//div[@class='page-title']");


    public String selectMenu(String menu) {

        List<WebElement> menuList = driver.findElements(By.xpath("//div[@class='header-menu']/ul[1]/li/a"));
        String expectedText = null;

        for (WebElement element : menuList) {
            if (element.getText().equalsIgnoreCase(menu)) {
                expectedText = element.getText();
                element.click();
                break;
            }
        }
        return expectedText;
    }

    public String getActualText() {
        Reporter.log("Getting text from element "+titleText.toString()+"<br>");
        return waitUntilVisibilityOfElementLocated(titleText, 80).getText();
    }
}