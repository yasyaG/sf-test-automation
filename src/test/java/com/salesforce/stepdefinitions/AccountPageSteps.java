package com.salesforce.stepdefinitions;

import com.salesforce.context.TestContext;
import com.salesforce.pageObjectModel.AccountPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Date;

public class AccountPageSteps {

    public TestContext testContext;
    public AccountPage accountPage;
    public static String accountName;

    public AccountPageSteps(TestContext testContext) {

        this.testContext = testContext;
    }


    @Then("^User completes mandatory fields (.+) and (.+)$")
    public void userCompletesMandatoryFields(String name, String rating) {
        accountPage = testContext.pageObjectManager.getAccountPage();
        Date date = new Date();
        accountName = name+"_"+date.getTime();
        accountPage.enterAccountName(accountName);
        accountPage.choseRatingPicklist(rating);
    }


    @Then("User verifies account is created")
    public void userVerifiesAccountIsCreated() {
        accountPage = testContext.pageObjectManager.getAccountPage();
        accountPage.assertAccountName(accountName);
    }
}