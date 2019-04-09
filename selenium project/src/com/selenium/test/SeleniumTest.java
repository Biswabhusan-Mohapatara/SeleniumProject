package com.selenium.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


/* 
 * 
 * @author Biswa
 * 
 */
public class SeleniumTest {

   public static WebDriver driver;
	@Test
	public void loginTest() {
	
     
     driver=new FirefoxDriver();
     driver.manage().window().maximize();
     driver.manage().deleteAllCookies();
     driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
     driver.get("http://www.yahoo.com");
     driver.quit();
     System.out.println("guddu");
	}
    
}
