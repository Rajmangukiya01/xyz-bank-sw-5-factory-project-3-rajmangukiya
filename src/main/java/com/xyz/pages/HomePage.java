package com.xyz.pages;

import com.xyz.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class HomePage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//button[text()='Bank Manager Login']")
    WebElement bankManagerLogin;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Customer Login')]")
    WebElement customerLogin;

    public void clickOnBankManagerLoginLink() {
        Reporter.log("Click on bank manager login link" + bankManagerLogin.toString());
        clickOnElement(bankManagerLogin);
    }

    public void clickOnCustomerLogin() {
        Reporter.log("Click on customer login link" + customerLogin.toString());
        clickOnElement(customerLogin);
    }
}
