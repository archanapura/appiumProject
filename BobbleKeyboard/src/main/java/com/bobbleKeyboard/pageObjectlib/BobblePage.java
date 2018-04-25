package com.bobbleKeyboard.pageObjectlib;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import com.bobbleKeyboard.Generic.BaseLibrary;
import com.bobbleKeyboard.Generic.Constantlib;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.Connection;

public class BobblePage extends BaseLibrary
{
	public void importantDisclosure() 
	{
		if(ad.findElement(By.id(Constantlib.allowPage1)).isDisplayed())
		{
			ad.findElement(By.id(Constantlib.allowButton1)).click();
			logger.log(LogStatus.INFO, "Clicking on Allow button ");
		}
		else
		{
			System.out.println("Important Disclosure Not displayed");
		}
	}

	public void permitToAccessDevice() 
	{
		if(ad.findElement(By.id(Constantlib.allowPage2)).isDisplayed())
		{
			ad.findElement(By.id(Constantlib.allowButton2)).click();
			logger.log(LogStatus.INFO, "Allow application to access device");
		}
		else
		{
			System.out.println("Couldn't allow application to access device ");
		}
	}
	public void permitToAccessContacts() 
	{
		if(ad.findElement(By.id(Constantlib.allowPage2)).isDisplayed())
		{
			ad.findElement(By.id(Constantlib.allowButton2)).click();
			logger.log(LogStatus.INFO, "Allow application to access contacts");
		}
		else
		{
			System.out.println("Couldn't allow application to access contacts");
		}

	}

	public void permitToSendSMS()
	{
		if(ad.findElement(By.id(Constantlib.allowPage2)).isDisplayed())
		{
			ad.findElement(By.id(Constantlib.allowButton2)).click();
			logger.log(LogStatus.INFO, "Allow application to send sms ");
		}
		else
		{
			System.out.println("Couldn't allow application to send sms");
		}

	}	

	public void clickOnButton(double x_offset,double y_offset) 
	{
		Dimension dsize =ad.manage().window().getSize();
		int x =(int)(dsize.width*x_offset);
		int y=(int)(dsize.height*y_offset);
		ad.tap(1,x,y,30);
	}
	public void swiping(double x_offset,double y_offset,double x1_offset,double y1_offset) 
	{
		Dimension dsize =ad.manage().window().getSize();
		int x =(int)(dsize.width*x_offset);
		int y=(int)(dsize.height*y_offset);
		int x1 =(int)(dsize.width*x1_offset);
		int y1=(int)(dsize.height*y1_offset);
		ad.swipe(x,y, x1,y1, 3000);
	}

	public void loginPage() 
	{

		if(ad.findElement(By.id(Constantlib.socialKeyboard)).getText().contains("Social Keyboard"))
		{

			clickOnButton(.89,.09);
			//	ad.tap(1,430,77,300);
			logger.log(LogStatus.INFO, "Entered Login page ");
		}
		else
		{
			System.out.println("Login page is not there");
		}
	}
	public void selectBobbleKeyboard() 
	{
		if(ad.findElement(By.id(Constantlib.bobbleKeyboard)).getText().contains("Change keyboard"))
		{
			clickOnButton(.175,.46);
			//ad.tap(1,84,400,300);
			logger.log(LogStatus.INFO, "selected  Bobble keyboard ");
		}
		else
		{
			System.out.println("Couldn't select Bobble keyboard");
		}
	}

	public void welcomePage() 
	{
		if(ad.findElement(By.xpath(Constantlib.welcomePage)).getText().contains("Welcome!"))
		{
			ad.findElement(By.id(Constantlib.continueButton)).click();
			logger.log(LogStatus.INFO, "Continue to home Page ");
		}
		else
		{
			System.out.println("Welcome page not displayed");
		}
	}
	public void permitToAccessLocation() 
	{
		if(ad.findElement(By.xpath(Constantlib.access1)).getText().contains("location"))
		{
			ad.findElement(By.id(Constantlib.allowButton2)).click();
			logger.log(LogStatus.INFO, "allow application to access location ");
		}
		else
		{
			System.out.println("Couldn't allow application to access location ");
		}
	}

	public void selectTheme() 
	{
		//ad.swipe(351,164,162,162,3000);
		swiping(.73,.192,.33,.189);
		if(ad.findElement(By.xpath(Constantlib.themes)).isDisplayed())
		{
			ad.findElement(By.xpath(Constantlib.themes)).click();
			logger.log(LogStatus.INFO, "Selecting one of keyboard theme ");
		}
		else
		{
			System.out.println("Theme couldn't be selected");		}}

	public void selectKeyboard() 
	{
		if(ad.findElement(By.id(Constantlib.keyboard)).isDisplayed())
		{

			ad.findElement(By.xpath(Constantlib.keyboardimg)).click();

		}
		else
		{
			System.out.println("Couldn't add theme");
		}}

	public void testKeyboard() 
	{
		if(ad.findElement(By.id(Constantlib.textbox)).isDisplayed())
		{
			ad.findElement(By.id(Constantlib.toggle1)).click();
			ad.findElement(By.id(Constantlib.toggle2)).click();

			ad.findElement(By.id(Constantlib.textbox)).sendKeys("abc");
			logger.log(LogStatus.INFO, "Testing selected theme");
			ad.hideKeyboard();
		}
		else
		{
			System.out.println("Couldn't test keyboard");}}
	
	public void selectLanguageTab() 
	{
		if(ad.findElement(By.xpath(Constantlib.language)).isDisplayed())
		{
		ad.findElement(By.xpath(Constantlib.language)).click();
		}
		else
		{
			System.out.println("Language is not selected");
		}
	}
public void addLanguage1() {
	if(ad.findElement(By.id(Constantlib.languagePage)).isDisplayed())
	{
	ad.swipe(211,715,211,50,3000);
	ad.findElement(By.xpath(Constantlib.selectLanguage)).click();

	ad.swipe(211,200,211,715,3000);
	}
	else
	{
		System.out.println("Couldn't add language");
		}
}
	public void checkIfLangAdded() 
	{
		if(ad.findElement(By.xpath(Constantlib.selectLanguage)).getText().contains("Kannada"))
		{
		 System.out.println("Language is successfully added");	
		}
		
	}
	
	public void closeApp1() throws InterruptedException
	{
		Thread.sleep(3000);
		//ad.setConnection(Connection.NONE);
		ad.closeApp();
	}

}
