package com.salesforce.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ContactsPage {
    public WebDriver driver;
    public CommonPageObjects commonPageObjects;

    public ContactsPage(WebDriver driver) {
        this.driver = driver;
    }

    //By contactsTab = By.xpath("//a[@title='Contacts']");
    //By newButton = By.xpath("//a[@title='New']");
    By salutationPickList = By.xpath("(//label[text()='Salutation']/following::button)[1]");
    By firstNameInputField = By.xpath("//input[@name='firstName']");
    By lastNameInputField = By.xpath("//input[@name='lastName']");
    By accountLookUpField = By.xpath("(//label[text()='Account Name']/following::input)[1]");
    //By saveButton = By.xpath("//button[@name='SaveEdit']");



//    public void clickContactsTab() {
//        driver.findElement(contactsTab).click();
//    }

    /*public void clickContactsNewButton() {
        driver.findElement(newButton).click();
    }*/
    public void choseSalutationPickList(String value){
        commonPageObjects = new CommonPageObjects(driver);
        commonPageObjects.waitForElementToBePresent(salutationPickList);
        driver.findElement(salutationPickList).click();
        commonPageObjects.waitForElementToBePresent(By.xpath("//span[text()='"+value+"']"));
        commonPageObjects.waitForElementToBeClickable(driver.findElement(By.xpath("//span[text()='"+value+"']")));
        WebElement element = driver.findElement(By.xpath("//span[text()='"+value+"']"));
        commonPageObjects.clickJSForce(driver, element);
    }

    public void enterFirstName(String firstName){
        commonPageObjects = new CommonPageObjects(driver);
        commonPageObjects.waitForElementToBePresent(firstNameInputField);
        driver.findElement(firstNameInputField).sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        commonPageObjects = new CommonPageObjects(driver);
        commonPageObjects.waitForElementToBePresent(lastNameInputField);
        driver.findElement(lastNameInputField).sendKeys(lastName);
    }
    public void choseAccount(String value){
        commonPageObjects = new CommonPageObjects(driver);
        commonPageObjects.waitForElementToBePresent(accountLookUpField);
        driver.findElement(accountLookUpField).sendKeys(value);
        commonPageObjects.waitForElementToBePresent(By.xpath("//strong[text()='"+value+"']"));
        WebElement element = driver.findElement(By.xpath("//strong[text()='"+value+"']"));
        element.click();

    }


   /* public void clickSaveButton(){
        driver.findElement(saveButton).click();
    }*/
}
