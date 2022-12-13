package com.xyz.pages;

import com.xyz.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class OpenAccountPage extends Utility {
    @CacheLookup
    @FindBy(id = "userSelect")
    WebElement customerName;

    @CacheLookup
    @FindBy(id = "currency")
    WebElement currency;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Process')]")
    WebElement processButton;

    public void searchCustomerName(String text) {
        Reporter.log("Search customer name" + customerName.toString());
        selectByVisibleTextFromDropDown(customerName, text);
    }

    public void selectCurrencyFromDropDown(String text) {
        Reporter.log("Select currency from dropdown" + currency.toString());
        selectByVisibleTextFromDropDown(currency, text);
    }

    public void clickOnProcessButton() {
        Reporter.log("Click on process button" + processButton.toString());
        clickOnElement(processButton);
    }

    public String getTheTextFromAlert() {
        Reporter.log("Get text from alert");
        String text = driver.switchTo().alert().getText();
        return text;
    }

    public void clickOk() {
        Reporter.log("CLick on ok in alert");
        acceptAlert();
    }

}
