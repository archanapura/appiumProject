package com.bobbleKeyboard.Generic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility
{
	 public static String captureScreenShot(WebDriver ldriver) throws IOException{
		 
		  // Take screenshot and store as a file format
		  File src= ((TakesScreenshot)ldriver).getScreenshotAs(OutputType.FILE);
		  String path =Constantlib.imgpath+System.currentTimeMillis()+".png";
		
		 
		 FileUtils.copyFile(src, new File(Constantlib.imgpath+System.currentTimeMillis()+".png"));
		 return path;
		
	
		 
		}
}
