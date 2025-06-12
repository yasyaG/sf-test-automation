package com.salesforce.stepdefinitions;

import com.salesforce.context.TestContext;
import com.salesforce.pageObjectModel.LoginPage;
import com.salesforce.pageObjectModel.PageObjectManager;
import com.salesforce.utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class LoginPageSteps {
    public TestContext testContext;
    public LoginPage loginPage;
    public PageObjectManager pageObjectManager;

    public LoginPageSteps(TestContext testContext) {

        this.testContext = testContext;
    }

    @Given("user opens salesforce login url")
    public void userOpensSalesforceLoginUrl() {
        String urlFromPropertyFile = ConfigReader.getProperty("url");
        String urlFromMaven = System.getProperty("url");
        String url = urlFromMaven != null ? urlFromMaven : urlFromPropertyFile;
        //System.setProperty("webdriver.chrome.driver", "/Users/admin/Documents/QA/CucumberReference/chromedriver-mac-x64/chromedriver");
//        testContext.driver = new ChromeDriver();// driver is active
//        testContext.driver.get("https://login.salesforce.com");

        testContext.browserFactory.getDriver();
        testContext.browserFactory.launchURL(url);
    }

    @When("user enters valid credentials")
    public void userEntersValidCredentials() {

        loginPage = testContext.pageObjectManager.getLoginPage();
        loginPage.enterUserName(System.getenv("LOGIN_USER"));
        loginPage.enterPassword(System.getenv("LOGIN_PASSWORD"));
    }


    @When("user enters invalid credentials")
    public void userEntersInvalidCredentials() {
        loginPage = testContext.pageObjectManager.getLoginPage();
        loginPage.enterUserName(System.getenv("LOGIN_USER"));
        loginPage.enterPassword("test1234");



        //WebElement element = testContext.driver.findElement(By.xpath("//input[contains(@class,'username')]"));
        //element.sendKeys(System.getenv("LOGIN_USER"));
        //testContext.driver.findElement(By.xpath("//input[contains(@class,'password')]")).sendKeys("test123");
    }

    @Then("user should see an error message")
    public void userShouldSeeAnErrorMessage() {
        loginPage = testContext.pageObjectManager.getLoginPage();
        loginPage.assertLoginError("Please check your username and password. If you still can't log in, contact your Salesforce administrator.");



        //WebElement element = testContext.driver.findElement(By.xpath("//div[@id='error' and @class='loginError']"));
        //Assert.assertEquals(element.getText(),"Please check your username and password. If you still can't log in, contact your Salesforce administrator.");
    }

    @Then("user click on login button")
    public void userClickOnLoginButton() {
        loginPage = testContext.pageObjectManager.getLoginPage();
        loginPage.clickLoginButton();

        //testContext.driver.findElement(By.xpath("//input[@id='Login']")).click();
    }
}
