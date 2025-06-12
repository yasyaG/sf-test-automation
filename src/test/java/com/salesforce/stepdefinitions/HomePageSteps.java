package com.salesforce.stepdefinitions;

import com.salesforce.context.TestContext;
import com.salesforce.pageObjectModel.HomePage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class HomePageSteps {
    public TestContext testContext;
    public HomePage homePage;
    public HomePageSteps(TestContext testContext){
        this.testContext = testContext;
    }


    @Then("user should be logged in successfully")
    public void userShouldBeLoggedInSuccessfully() throws InterruptedException {
       // Thread.sleep(10000);
       // homePage = new HomePage(testContext.driver);
       homePage = testContext.pageObjectManager.getHomePage();
       homePage.assertLoginAvatar();
    }
}


