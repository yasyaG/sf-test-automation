package com.salesforce.context;

import com.salesforce.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {
    WebDriver driver;
    String browserFromProperties = ConfigReader.getProperty("Browser");
    String browserFromMaven = System.getProperty("Browser");
    String browser = browserFromMaven != null?browserFromMaven:browserFromProperties;



    public WebDriver getDriver() {
        if (driver == null) {
            if (browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            } else if (browser.equalsIgnoreCase("safari")) {
                driver = new SafariDriver();
                driver.manage().window().maximize();
            }else if(browser.equalsIgnoreCase("chrome_headless")){
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless","--disable-gpu"); // also could be added resolution after , "--window-size=1920,1880"
                driver = new ChromeDriver(options);
            }else if(browser.equalsIgnoreCase("chrome_incognito")){
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito", "--maximized");
                driver = new ChromeDriver(options);
            }

        }
        return driver;

    }
    public void launchURL(String url){
        driver.get(url);
    }

}
