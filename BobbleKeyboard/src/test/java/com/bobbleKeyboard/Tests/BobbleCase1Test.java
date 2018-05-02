package com.bobbleKeyboard.Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.bobbleKeyboard.Generic.BaseLibrary;
import com.bobbleKeyboard.Generic.Constantlib;
import com.bobbleKeyboard.pageObjectlib.BobblePage;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.Connection;

public class BobbleCase1Test extends BaseLibrary 
{
	@Test
	public void languageTabTest() throws InterruptedException 
	{
		BobblePage page = new BobblePage();
		logger=extent.startTest("languageTabTest");
		logger.log(LogStatus.INFO, "Application started");
		ad.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		
		
		logger.log(LogStatus.INFO, "languageTabTestCase started");
		
		page.importantDisclosure();
		page.permitToAccessDevice();
		page.permitToAccessContacts();

		page.permitToSendSMS();
		page.loginPage();
		page.selectBobbleKeyboard();
		page.welcomePage();

		page.permitToAccessLocation();
		
		
		
		page.selectLanguageTab();
		page.addLanguage1();
		page.checkIfLangAdded();
		page.closeApp1();
		
		logger.log(LogStatus.INFO, "languageTabTestCase closed");
		logger.log(LogStatus.INFO, "Application closed");
	}


}