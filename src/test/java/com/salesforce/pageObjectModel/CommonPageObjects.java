package com.salesforce.pageObjectModel;

import io.cucumber.java.ht.E;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonPageObjects {
    public WebDriver driver;
    public static WebDriverWait wait;


    public CommonPageObjects(WebDriver driver){                     //constructor to pass driver
        this.driver = driver;
    }
    By newButton = By.xpath("//a[@title='New']");
    By saveButton = By.xpath("//button[@name='SaveEdit']");
    By appLauncher = By.xpath("//button[@title='App Launcher']");
    By searchAppInputField = By.xpath("//input[@placeholder='Search apps and items...']");

    public void clickNewButton(){
        waitForElementToBePresent(newButton);
        waitForElementToBeVisible(driver.findElement(newButton));
        waitForElementToBeClickable(driver.findElement(newButton));
        driver.findElement(newButton).click();
    }

    public void clickSaveButton(){
        waitForElementToBePresent(saveButton);
        waitForElementToBeVisible(driver.findElement(saveButton));
        waitForElementToBeClickable(driver.findElement(saveButton));
        driver.findElement(saveButton).click();
    }
//    public void clickAndOpenTabs(String tabName){
//        waitForPage();
//        waitForElementToBePresent(By.xpath("//a[@title='"+tabName+"']"));
//        waitForElementToBeVisible(driver.findElement(By.xpath("//a[@title='"+tabName+"']")));
//        waitForElementToBeClickable(driver.findElement(By.xpath("//a[@title='"+tabName+"']")));
//        WebElement element=driver.findElement(By.xpath("//a[@title='"+tabName+"']"));
//        element.click();
//    }
public void clickAndOpenTabs(String tabName){
    waitForPage();
    By tabNameLocator = By.xpath("//a[@title='"+tabName+"']");
    try{
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(tabNameLocator));
        element.click();
    }catch(Exception e){
        System.out.println("Click failed, now attempting to force click");
        WebElement element = driver.findElement(tabNameLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

    }


}

    public void choseAppLauncher(String appName)throws InterruptedException{
        waitForElementToBePresent(appLauncher);
        waitForElementToBeVisible(driver.findElement(appLauncher));
        waitForElementToBeClickable(driver.findElement(appLauncher));
        clickJSForce(driver, driver.findElement(appLauncher));
        waitForElementToBePresent(searchAppInputField);
        waitForElementToBeVisible(driver.findElement(searchAppInputField));
        waitForElementToBeClickable(driver.findElement(searchAppInputField));
        driver.findElement(searchAppInputField).sendKeys(appName);

        waitForElementToBePresent(By.xpath("//a[contains(@data-label, '" + appName + "')]"));

        waitForElementToBeVisible(driver.findElement(By.xpath("//a[contains(@data-label, '"+appName+"')]")));

        waitForElementToBeClickable(driver.findElement(By.xpath("//a[contains(@data-label, '"+appName+"')]")));


        WebElement element = driver.findElement(By.xpath("//a[contains(@data-label, '"+appName+"')]"));

        waitForClickableByLocator(By.xpath("//a[contains(@data-label, '"+appName+"')]"));
       // element.click();
        clickJSForce(driver, element);


    }
    public void clickJSForce(WebDriver driver, WebElement element){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click();", element);

    }
    public void waitForElementToBeVisible(WebElement element){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));

    }
    public void waitForElementToBeClickable(WebElement element){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }
    public void waitForClickableByLocator(By locator){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void waitForElementToBePresent(By locator){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));

    }
    public void waitForPage(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
}
