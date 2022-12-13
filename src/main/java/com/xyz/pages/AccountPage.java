package com.xyz.pages;

import com.xyz.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AccountPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Deposit')]")
    WebElement depositTab;

    @CacheLookup
    @FindBy(xpath = "//input[@ng-model='amount']")
    WebElement amount;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Deposit']")
    WebElement depositButton;

    @CacheLookup
    @FindBy(xpath = "//span[text()='Deposit Successful']")
    WebElement depositSuccessfulMessage;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Withdrawl')]")
    WebElement withdrawlButton;

    @CacheLookup
    @FindBy(xpath = "//input[@ng-model='amount']")
    WebElement enterAmount;

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement clickWithdrawl;

    public void clickOnDepositTab() {
        Reporter.log("Click on deposit tab" + depositTab.toString());
        clickOnElement(depositTab);
    }

    public void enterAmount() {
        Reporter.log("Enter amount" + amount.toString());
        sendTextToElement(amount, "100");
    }

    public void clickOnDepositButton() {
        Reporter.log("Click on deposit button" + depositButton.toString());
        clickOnElement(depositButton);
    }

    public String getDepositSuccessfulMessage() {
        Reporter.log("Get deposit successful message" + depositSuccessfulMessage.toString());
        return getTextFromElement(depositSuccessfulMessage);
    }

    public void clickOnWithdrawlTab() {
        Reporter.log("Click on Withdrawl tab" + withdrawlButton.toString());
        clickOnElement(withdrawlButton);
    }

    public void enterWithdrawlAmount() {
        Reporter.log("Enter Withdrawl amount" + enterAmount.toString());
        sendTextToElement(enterAmount, "50");
    }

    public void clickOnWithdrawlButton() {
        Reporter.log("Click on withdrawl button " + clickWithdrawl.toString());
        clickOnElement(clickWithdrawl);
    }
}
