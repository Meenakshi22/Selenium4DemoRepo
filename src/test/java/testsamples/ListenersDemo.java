package testsamples;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenersDemo implements ITestListener {
	WebDriver driver;
	public void onFinish(ITestContext contextFinish) {
		System.out.println("onFinish method finished");

	}

	public void onStart(ITestContext contextStart) {
		System.out.println("onStart method started");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Method failed with certain success percentage"+ result.getName());

	}


	public void onTestFailure(ITestResult result) {
		System.out.println("Method failed"+ result.getName());
		String methodName=result.getName().toString().trim();
        takeScreenShot(methodName);
     

	}
	public void takeScreenShot(String methodName) {
        //get the driver
        this.driver=LaunchBrowser.driver;
         File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         //The below method will save the screen shot in d drive with test method name 
            try {
            	File destFile = new File("C:\\Users\\meena\\Workspace\\demo-projects\\screenshots\\"+methodName+".png");
                FileUtils.copyFile(scrFile, destFile);
                Reporter.log("<a href='"+ destFile.getAbsolutePath() + "'> <img src='"+ destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

	public void onTestSkipped(ITestResult result) {
		System.out.println("Method skipped"+ result.getName());

	}
	public void onTestStart(ITestResult result) {
		System.out.println("Method started"+ result.getName());

	}
	public void onTestSuccess(ITestResult result) {
		System.out.println("Method passed"+ result.getName());

		}

}
