package com.salesforce.stepdefinitions;

import com.salesforce.context.TestContext;
import com.salesforce.pageObjectModel.CommonPageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CommonPageSteps {

    public TestContext testContext;
    public CommonPageObjects commonPageObjects;
    public CommonPageSteps(TestContext testContext){
        this.testContext = testContext;}


    @Given("User clicks on {string} Tab")
    public void userClicksOnSFTab(String tabName) {
        commonPageObjects = testContext.pageObjectManager.getCommonPageObjects();
        commonPageObjects.clickAndOpenTabs(tabName);
    }

    @When("User clicks on New button in {string} tab")
    public void userClicksOnNewButton(String tabName) {
        commonPageObjects = testContext.pageObjectManager.getCommonPageObjects();
        commonPageObjects.clickNewButton();

    }

    @And("user clicks on Save button in {string} tab")
    public void userClicksOnSaveButtonInTab(String tabName) {
        commonPageObjects = testContext.pageObjectManager.getCommonPageObjects();
        commonPageObjects.clickSaveButton();
    }

    @And("User chooses {string} app from app launcher")
    public void userChoosesAppFromAppLauncher(String appName)throws InterruptedException {
        commonPageObjects = testContext.pageObjectManager.getCommonPageObjects();
        commonPageObjects.choseAppLauncher(appName);
    }
}
