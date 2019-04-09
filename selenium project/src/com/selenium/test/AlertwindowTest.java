package com.selenium.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertwindowTest {
	public static WebDriver driver;

	@Test
	public void loginTest() {

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.yahoo.com");
		
		driver.findElement(By.xpath("//span[text()='search']")).click();
		Alert alt=driver.switchTo().alert();
		alt.accept();
		String actual_msg=alt.getText();
		System.out.println("alert msg is "+actual_msg);
		
		String expect_msg="from fill is required";
	    Assert.assertEquals(actual_msg, expect_msg);
	    
	    driver.quit();

	}
}