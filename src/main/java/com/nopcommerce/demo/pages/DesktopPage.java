package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.List;

public class DesktopPage extends Utility {

    By sortByFilter = By.xpath("//select[@id='products-orderby']");
    By buildYourOwnComputer = By.xpath("(//button[@class='button-2 product-box-add-to-cart-button'])[1]");


    public void sortByZToA() {
        selectByValueFromDropDown(waitUntilVisibilityOfElementLocated(sortByFilter, 80), "6");
    }

    public List<String> verifyProductSortedByZToAFilter() throws InterruptedException {

        List<WebElement> productList = driver.findElements(By.xpath("//div[@class='product-grid']//h2"));
        List<String> productNameList = new ArrayList<>();

        for (WebElement name : productList) {
            Thread.sleep(3000);
            productNameList.add(name.getText());
        }
        return productNameList;
    }

    public void sortByAtoZ() {

        Reporter.log("Selecting filter "+sortByFilter.toString()+"<br>");
        selectByValueFromDropDown(waitUntilVisibilityOfElementLocated(sortByFilter, 80), "5");
    }

    public void addProductToCart() {

        Reporter.log("Click on add to cart button "+buildYourOwnComputer.toString()+"<br>");
        clickOnElement(waitUntilVisibilityOfElementLocated(buildYourOwnComputer, 80));
    }
}
