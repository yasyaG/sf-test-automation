package com.salesforce.context;

import com.salesforce.pageObjectModel.PageObjectManager;
import org.openqa.selenium.WebDriver;

public class TestContext {
    public WebDriver driver;
    public PageObjectManager pageObjectManager;
    public BrowserFactory browserFactory;
    public TestContext(){
        browserFactory = new BrowserFactory();
        pageObjectManager = new PageObjectManager(browserFactory.getDriver());

    }
}
