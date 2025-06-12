package com.salesforce.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CasePage {
    public WebDriver driver;
    public CasePage(WebDriver driver){
        this.driver = driver;
    }

    //By casesTab = By.xpath("//a[@title='Cases']");
    //By newButton = By.xpath("//a[@title='New']");
    By statusPickList = By.xpath("(//label[text()='Status']/following::button)[1]");
    By caseOriginPickList = By.xpath("(//label[text()='Case Origin']/following::button)[1]");
   // By saveButton = By.xpath("//button[@name='SaveEdit']");
    By descriptionTextAreaField = By.xpath("(//label[text()='Description' ]/following::textarea)[1]");



//    public void clickCasesTab(){
//        driver.findElement(casesTab).click();
//    }

//    public void clickNewButton(){
//        driver.findElement(newButton).click();
//    }

    public void choseCaseStatus(String status){
        driver.findElement(statusPickList).click();
        WebElement element = driver.findElement(By.xpath("//span[text()='"+status+"']"));
        element.click();
    }
    public void choseCaseOrigen(String caseOrigin){
        driver.findElement(caseOriginPickList).click();
        WebElement element = driver.findElement(By.xpath("//span[text()='"+caseOrigin+"']"));
        element.click();
    }
//    public void clickSaveButton(){
//        driver.findElement(saveButton).click();
//    }
    public void enterDescription(String description){
      driver.findElement(descriptionTextAreaField).sendKeys(description);
    }

}
