package com.selenium.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FramewindowTest {

	 public static WebDriver driver;
		@Test
		public void loginTest() {
		
	     
	     driver=new FirefoxDriver();
	     driver.manage().window().maximize();
	     driver.manage().deleteAllCookies();
	     driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	     driver.get("http://www.yahoo.com");
	     
	     int total_frames=driver.findElements(By.tagName("iframe")).size();
	     System.out.println("total no of frames "+total_frames);
	     
	     driver.switchTo().frame("frm1");
	     driver.findElement(By.xpath("//span[text()='jhaxhjxas']")).click();
	     driver.switchTo().defaultContent();
	     
	     driver.quit();
		
		}
	

}
