package com.nopcommerce.demo.computers;

import com.nopcommerce.demo.customListeners.CustomListeners;
import com.nopcommerce.demo.pages.BuildYourOwnComputer;
import com.nopcommerce.demo.pages.ComputersPage;
import com.nopcommerce.demo.pages.DesktopPage;
import com.nopcommerce.demo.retryAnalyzer.RetryAnalyzer;
import com.nopcommerce.demo.testBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Listeners(CustomListeners.class)
public class TestSuite extends TestBase {
    SoftAssert softAssert = new SoftAssert();
    ComputersPage computersPage = new ComputersPage();
    DesktopPage desktopPage = new DesktopPage();
    BuildYourOwnComputer buildYourOwnComputer = new BuildYourOwnComputer();



    @Test(groups = {"smoke","sanity","regression"},retryAnalyzer = RetryAnalyzer.class)
    public void verifyProductArrangeInAlphabeticalOrder() throws InterruptedException {

        computersPage.clickOnComputer();
        Thread.sleep(3000);
        computersPage.clickOnDesktop();
        desktopPage.sortByZToA();

        Thread.sleep(3000);
        List<String> actualProductNameList = desktopPage.verifyProductSortedByZToAFilter();
        List<String> sortedProductNameList = new ArrayList<>(actualProductNameList);
        Collections.sort(sortedProductNameList,Collections.<String>reverseOrder());
        Assert.assertEquals(actualProductNameList,sortedProductNameList);
    }

    @Test(groups = {"sanity","regression"},retryAnalyzer = RetryAnalyzer.class)
    public void  verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

        computersPage.clickOnComputer();
        Thread.sleep(3000);
        computersPage.clickOnDesktop();

        desktopPage.sortByAtoZ();
        Thread.sleep(3000);
        desktopPage.addProductToCart();

        Thread.sleep(3000);
        String expectedBuildYourOwnComputerText = "Build your own computer";
        softAssert.assertEquals(buildYourOwnComputer.actualBuildYourOwnComputerText(),expectedBuildYourOwnComputerText);
        Thread.sleep(3000);
        buildYourOwnComputer.selectIntelPentiumProcessor();
        buildYourOwnComputer.select8BGRAM();
        Thread.sleep(3000);
        buildYourOwnComputer.clickOn400GBRadioButton();
        buildYourOwnComputer.clickOnVistaPremiumRadioButton();
        Thread.sleep(3000);
        buildYourOwnComputer.checkBoxTotalCommander();
        Thread.sleep(3000);
        String expectedTotalPrice = "$1,475.00";
        softAssert.assertEquals(buildYourOwnComputer.actualTotalPrice(),expectedTotalPrice);
        Thread.sleep(3000);
        buildYourOwnComputer.clickToAddBuildProductToCart();
        Thread.sleep(3000);
        String expectedTopGreenBarText = "The product has been added to your shopping cart";
        softAssert.assertEquals(buildYourOwnComputer.actualTopGreenBarText(),expectedTopGreenBarText);

    }

}
