package com.salesforce.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/java/com/salesforce/features", glue = "com/salesforce/stepdefinitions",
        monochrome = true, tags = "@test",
        plugin = {"pretty","html:target/cucumber-reports.html", "json:target/cucumber-reports.json", "rerun:target/failedTest.txt"})

public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object [] [] scenarios(){
        return super.scenarios();
    }
}
