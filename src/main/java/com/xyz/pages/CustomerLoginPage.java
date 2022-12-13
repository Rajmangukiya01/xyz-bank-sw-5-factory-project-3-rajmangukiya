package com.xyz.pages;

import com.xyz.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CustomerLoginPage extends Utility {
    @CacheLookup
    @FindBy(id = "userSelect")
    WebElement yourName;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Login']")
    WebElement login;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Logout']")
    WebElement logout;

    By logoutTab = By.xpath("//button[text()='Logout']");

    @CacheLookup
    @FindBy(xpath = "//label[text()='Your Name :']")
    WebElement yourNameText;

    public void selectYourName(String text) {
        Reporter.log("Select your name" + yourName.toString());
        selectByVisibleTextFromDropDown(yourName, text);
    }

    public void clickOnLoginButton() {
        Reporter.log("Click on login button" + login.toString());
        clickOnElement(login);
    }

    public void getLogoutTab() {
        Reporter.log("Verify logout tab" + logoutTab.toString());
        Boolean logOutButton = driver.findElement(logoutTab).isDisplayed();
    }

    public void clickOnLogoutButton() {
        Reporter.log("CLick on Logout button" + logout.toString());
        clickOnElement(logout);
    }

    public String verifyYourNameText() {
        Reporter.log("Verify your name text" + yourNameText.toString());
        return getTextFromElement(yourNameText);
    }
}
