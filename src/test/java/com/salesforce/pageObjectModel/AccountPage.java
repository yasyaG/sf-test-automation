package com.salesforce.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AccountPage {
    public WebDriver driver;
    public CommonPageObjects commonPageObjects;


    public AccountPage(WebDriver driver){

        this.driver = driver;
    }
    //By accountsTab = By.xpath("//a[@title='Accounts']");
    //By newButton = By.xpath("//a[@title='New']");
    By accountNameInputField = By.xpath("(//label[text()='Account Name']/following::input)[1]");
    By ratingPicklist = By.xpath("(//label[text()='Rating']/following::button)[1]");
   //By saveButton = By.xpath("//button[@name='SaveEdit']");


//    public void clickAccountsTab(){
//        driver.findElement(accountsTab).click();
//    }
//    public void clickAccountsNewButton(){
//        driver.findElement(newButton).click();
//    }
    public void enterAccountName(String accountName){
        commonPageObjects = new CommonPageObjects(driver);
        commonPageObjects.waitForElementToBePresent(accountNameInputField);
        commonPageObjects.waitForElementToBeVisible(driver.findElement(accountNameInputField));
        commonPageObjects.waitForElementToBeClickable(driver.findElement(accountNameInputField));
        driver.findElement(accountNameInputField).sendKeys(accountName);
    }
    public void choseRatingPicklist(String value){
        commonPageObjects = new CommonPageObjects(driver);

        commonPageObjects.waitForElementToBePresent(ratingPicklist);
        commonPageObjects.waitForElementToBeVisible(driver.findElement(ratingPicklist));
        commonPageObjects.waitForElementToBeClickable(driver.findElement(ratingPicklist));
        driver.findElement(ratingPicklist).click();


        commonPageObjects.waitForElementToBePresent(By.xpath("//lightning-base-combobox-item[@data-value='"+value+"']"));
        commonPageObjects.waitForElementToBeClickable(driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='"+value+"']")));

        WebElement element = driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='"+value+"']"));
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", element);
       // ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
       // ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", element);
        commonPageObjects.clickJSForce(driver,element);

    }
    public void assertAccountName(String accountName){
        commonPageObjects = new CommonPageObjects(driver);
        By locator = By.xpath("//lightning-formatted-text[text()='"+accountName+"']");
        commonPageObjects.waitForElementToBePresent(locator);
        WebElement element = driver.findElement(locator);
        Assert.assertTrue(element.isDisplayed());
//        // if want to test pass but got the error
//        if(element.isDisplayed()){
//            System.out.println("Account created");
//        }else{
//            System.out.println("Account creation failed");
//        }
//        //another assertion way
//        try{
//            element.isDisplayed();
//            System.out.println("Account Created");
//        }catch (Exception e){
//            throw new RuntimeException(e);
//        }
    }


}
