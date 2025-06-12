package com.salesforce.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpportunityPage {
    public WebDriver driver;

    public OpportunityPage(WebDriver driver) {
        this.driver = driver;
    }

    //By opportunityTab = By.xpath("//a[@title='Opportunities']");
    //By newButton = By.xpath("//a[@title='New']");
    By opportunityNameInputField = By.xpath("//input[@name='Name']");
    By amountInputField = By.xpath("//input[@name='Amount']");
    By closeDateInoutField = By.xpath("//input[@name='CloseDate']");
    By stagePickListField = By.xpath("(//label[text()='Stage']/following::input)[1]");
    //By saveButton = By.xpath("//button[@name='SaveEdit']");


//    public void clickOpportunityTab(){
//        driver.findElement(opportunityTab).click();
//    }

//    public void clickNewButton(){
//        driver.findElement(newButton).click();
//    }
    public void enterOpportunityName(String name){
        driver.findElement(opportunityNameInputField).sendKeys(name);
    }
    public void enterAmount(int amount){
        driver.findElement(amountInputField).sendKeys(String.valueOf(amount)); //convert int to string

    }
    public void enterAmount(String amount){
        driver.findElement(amountInputField).sendKeys(amount); //use string for amount

    }
    public void enterCloseDate(String date){
        driver.findElement(closeDateInoutField).sendKeys(date);
    }

    public void choseStageInOpportunity(String stage){
        driver.findElement(stagePickListField).click();
        WebElement element = driver.findElement(By.xpath("//span[text()='"+stage+"']"));
        element.click();

    }
//    public void clickSaveButton(){
//        driver.findElement(saveButton).click();
//    }
}