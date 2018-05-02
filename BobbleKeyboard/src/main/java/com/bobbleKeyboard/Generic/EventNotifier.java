package com.bobbleKeyboard.Generic;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class EventNotifier implements ITestListener{
 public  WebDriver driver;
 public static ExtentTest logger;
	@Override
	public void onFinish(ITestContext result) {
		// TODO Auto-generated method stub
		
		
		
	}

	@Override
	public void onStart(ITestContext result) {
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		/* String FailedTestName=result.getMethod().getMethodName();
	        EventFiringWebDriver edri=new EventFiringWebDriver(BaseLibrary.ad);
	        File srcfile=edri.getScreenshotAs(OutputType.FILE);
	        File dstfile=new File("./screenshot/"+FailedTestName+".png");
	        try{
	            FileUtils.copyFile(srcfile, dstfile);
	            }
	            catch(IOException e){
	            };
		*/
		String screenshot_path;
		try {
			screenshot_path = Utility.captureScreenShot(driver);
			String image= logger.addScreenCapture(screenshot_path);
			logger.log(LogStatus.FAIL, "Title verification", image);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		
	}

}
