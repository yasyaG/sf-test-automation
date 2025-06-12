package com.salesforce.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "@target/failedTest.txt", glue = "com/salesforce/stepdefinitions",
        monochrome = true,
        plugin = {"pretty","html:target/cucumber-reports.html", "json:target/cucumber-reports.json"})


public class FailedTestRunner extends AbstractTestNGCucumberTests {

}
