package appiumDemoPro;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.BobbleKeyborad.Generic.BaseLibrary;
import com.BobbleKeyborad.Generic.Constantlib;
import com.bobbleKeyboard.pageObjectlib.BobblePage;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.Connection;

public class BobbleTest extends BaseLibrary
{
	@Test
	public void themeTabTestCase() throws InterruptedException 
	{
		BobblePage page = new BobblePage();
		logger=extent.startTest("themeTabTestCase");
		logger.log(LogStatus.INFO, "Application started");
		ad.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		ad.setConnection(Connection.NONE);
		Thread.sleep(5000);
		logger.log(LogStatus.INFO, "themeTabTestCase started");
		
		page.importantDisclosure();
		page.permitToAccessDevice();
		page.permitToAccessContacts();

		page.permitToSendSMS();
		page.loginPage();
		page.selectBobbleKeyboard();
		page.welcomePage();

		page.permitToAccessLocation();
		
		
		ad.setConnection(Connection.WIFI);
		Thread.sleep(5000);
		page.selectTheme();

		page.selectKeyboard();
		page.testKeyboard();
		page.closeApp1();
		
		logger.log(LogStatus.INFO, "themeTabTestCase ended");
		logger.log(LogStatus.INFO, "Application closed");
	}

}
