package com.nopcommerce.demo.homePage;

import com.nopcommerce.demo.customListeners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.retryAnalyzer.RetryAnalyzer;
import com.nopcommerce.demo.testBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(CustomListeners.class)
public class TestTopMenu extends TestBase {
    SoftAssert softAssert = new SoftAssert();
    HomePage homePage = new HomePage();



    @Test(groups = {"smoke","sanity","regression"},retryAnalyzer = RetryAnalyzer.class)

    public void selectMenuAndClick(){

        String expectedText = homePage.selectMenu("Computers");
        String actualText = homePage.getActualText();
        softAssert.assertEquals(expectedText,actualText);
    }


}
