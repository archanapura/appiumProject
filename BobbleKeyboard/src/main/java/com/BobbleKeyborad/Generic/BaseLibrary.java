package com.BobbleKeyborad.Generic;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseLibrary {
	public  DesiredCapabilities cap=null;
	public static AndroidDriver<MobileElement> driver; 
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static AndroidDriver ad;	
	@BeforeClass
	public void reportGrenerator(){

		 /*extent=new ExtentReports("./test-output/advance.html");
	   	logger=extent.startTest("ByjusTest");*/
		 extent=new ExtentReports("./test-output/advance1.html",false);
		// extent.loadConfig(new File("./test-output/extent-config.xml"));	
		
	}
		
	@BeforeMethod
	public void launchApp() throws Exception{

DesiredCapabilities des=new DesiredCapabilities();
		
		des.setCapability("automationName", "Appium");
des.setCapability("platformName","Android");
des.setCapability( "platformVersion", "6.0");
des.setCapability( "deviceName","Lava A97");
des.setCapability("appActivity", "com.touchtalent.bobbleapp.activities.SplashActivity");
des.setCapability("appPackage", "com.touchtalent.bobbleapp");

	System.out.println("Execution started");
ad=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),des);
Thread.sleep(4000);
//logger.log(LogStatus.INFO, "Application started ");
	}
	
	
	@AfterMethod
	
	public void cleanConfig(ITestResult result) throws IOException{
		System.out.println("i am closing app");
		
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
		 
		String screenshot_path=Utility.captureScreenShot(ad);
		String image= logger.addScreenCapture(screenshot_path);
		logger.log(LogStatus.FAIL, "Title verification", image);
		 
		 
		}
	}
	
	@AfterClass
	
	public void closeReport() throws InterruptedException{
		 extent.endTest(logger);
		 extent.flush();

		extent.close();
	}
	
}
