package com.selenium.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {

	public static void captureScreenshot(WebDriver driver, String screenshotName) {
	TakesScreenshot ts=(TakesScreenshot)driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(source, new File("./Screenshots/"+screenshotName+".png"));
	} catch (IOException e) {
		
		e.printStackTrace();
		System.out.println("exception while taking screenshot"+e.getMessage());
	}
	
	System.out.println("screenshot taken");
	}
}
