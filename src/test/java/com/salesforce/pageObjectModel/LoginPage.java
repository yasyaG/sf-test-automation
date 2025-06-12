package com.salesforce.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By userName = By.xpath("//input[contains(@class,'username')]");
    By passWord = By.xpath("//input[contains(@class,'password')]");
    By loginButton = By.xpath("//input[@id='Login']");
    By loginError = By.xpath("//div[@id='error' and @class='loginError']");

    public void enterUserName(String username) {
        driver.findElement(userName).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passWord).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void assertLoginError(String errorMessage) {
        WebElement element = driver.findElement(loginError);
        Assert.assertEquals(element.getText(), errorMessage);
    }
}
