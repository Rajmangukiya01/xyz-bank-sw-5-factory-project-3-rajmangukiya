package com.xyz.testsuite;

import com.xyz.pages.*;
import com.xyz.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BankTest extends BaseTest {
    AccountPage accountPage;
    AddCustomerPage addCustomerPage;
    BankManagerLoginPage bankManagerLoginPage;
    CustomerLoginPage customerLoginPage;
    HomePage homePage;
    OpenAccountPage openAccountPage;

    @BeforeMethod(alwaysRun = true)
    public void init() {
        accountPage = new AccountPage();
        addCustomerPage = new AddCustomerPage();
        bankManagerLoginPage = new BankManagerLoginPage();
        customerLoginPage = new CustomerLoginPage();
        homePage = new HomePage();
        openAccountPage = new OpenAccountPage();
    }

    @Test(groups = {"sanity","regression"})
    public void bankManagerShouldAddCustomerSuccessfully() {
        homePage.clickOnBankManagerLoginLink();
        bankManagerLoginPage.clickOnAddCustomerTab();
        addCustomerPage.enterFirstName("Raj");
        addCustomerPage.enterLastName("Mangukiya");
        addCustomerPage.enterPostCode("N1 6PJ");
        addCustomerPage.clickOnAddToCustomerButton();
        Assert.assertTrue(addCustomerPage.getTheTextFromAlert().contains("Customer added successfully"), "Customer added successfully is not displayed in popup");
        addCustomerPage.clickOk();
    }

    @Test(groups = {"smoke","regression"})
    public void bankManagerShouldOpenAccountSuccessfully() {
        //homePage.clickOnBankManagerLoginLink();
        bankManagerShouldAddCustomerSuccessfully();
        bankManagerLoginPage.clickOnOpenAccountTab();
        openAccountPage.searchCustomerName("Raj Mangukiya");
        openAccountPage.selectCurrencyFromDropDown("Pound");
        openAccountPage.clickOnProcessButton();
        Assert.assertTrue(openAccountPage.getTheTextFromAlert().contains("Account created successfully"));
        openAccountPage.clickOk();
    }

    @Test(groups = "regression")
    public void customerShouldLoginAndLogoutSuccessfully() {
        bankManagerShouldAddCustomerSuccessfully();
        addCustomerPage.clickOnHomeButton();
        homePage.clickOnCustomerLogin();
        customerLoginPage.selectYourName("Raj Mangukiya");
        customerLoginPage.clickOnLoginButton();
        customerLoginPage.getLogoutTab();
        customerLoginPage.clickOnLogoutButton();
        Assert.assertEquals(customerLoginPage.verifyYourNameText(), "Your Name :");
    }

    @Test(groups = "regression")
    public void customerShouldDepositMoneySuccessfully() {
        bankManagerShouldOpenAccountSuccessfully();
        addCustomerPage.clickOnHomeButton();
        homePage.clickOnCustomerLogin();
        customerLoginPage.selectYourName("Raj Mangukiya");
        customerLoginPage.clickOnLoginButton();
        accountPage.clickOnDepositTab();
        accountPage.enterAmount();
        accountPage.clickOnDepositButton();
        Assert.assertEquals(accountPage.getDepositSuccessfulMessage(), "Deposit Successful");
    }

    @Test(groups = "regression")
    public void customerShouldWithdrawMoneySuccessfully() {
        customerShouldDepositMoneySuccessfully();
        addCustomerPage.clickOnHomeButton();
        homePage.clickOnCustomerLogin();
        customerLoginPage.selectYourName("Raj Mangukiya");
        customerLoginPage.clickOnLoginButton();
        accountPage.clickOnWithdrawlTab();
        accountPage.enterWithdrawlAmount();
        accountPage.clickOnWithdrawlButton();

    }
}
