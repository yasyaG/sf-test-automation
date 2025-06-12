package com.salesforce.stepdefinitions;


import com.salesforce.context.TestContext;
import io.cucumber.java.After;


public class Hooks {
   public TestContext testContext;
   public Hooks(TestContext testContext){
       this.testContext = testContext;
   }



   @After
    public void cleanup(){
       testContext.browserFactory.getDriver().quit();

   }

//   @AfterStep
//   public void afterStep(String scenario){
//       try {
//
//           String screenshotPath = captureScreenShot(scenario.getName());
//           TestContext.extentTest.addScreenCaptureFromPath(screenshotPath,"Step Screenshot");
//       }catch(IOException e){
//           TestContext.extentTest.log(Status.WARNING, "Failed to capture screenshot:"+e.getMessage());
//       }

//   public String captureScreenShot(String stepName)throws IOException{
//       WebDriver driver = testContext.browserFactory.getDriver();
//       File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//       String screenshotPath = "target/screenshots/"+stepName.replaceAll("","")+"_"+System.currentTimeMillis()+".png";
//       File screenshotFile = new File(screenshotPath);
//       FileUtils.copyFile(screenshot, screenshotFile);
//       return screenshot.getAbsolutePath();
//
//   }


}
