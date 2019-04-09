package com.selenium.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenFrameworkTest {

	public static WebDriver driver;
	FileUtils fiu=new FileUtils();

	@BeforeClass
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test(dataProvider = "getcredential")
	public void FacebookCredentialTest(String username, String password) throws InterruptedException {
		driver.get("www.facebook.login");
		driver.findElement(By.xpath("//input[@id='email']")).clear();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(username);
		driver.findElement(By.xpath(" //input[@id='pass']")).clear();
		driver.findElement(By.xpath(" //input[@id='pass']")).sendKeys(password);
		driver.findElement(By.xpath(" //button[@id='loginbutton']")).click();
		Thread.sleep(3000); 
        Assert.assertTrue(driver.getTitle().equalsIgnoreCase("facebook"),"user is not able to login with invalid credentials");
        System.out.println("user is able to login with valid credentials");
	}

//	@DataProvider
//	public Object[][] getcredential() throws InvalidFormatException, IOException, Exception {
//		Object[][] objarr = new Object[3][2];
//		objarr[0][0] = fiu.getExceldata("Sheet1", 0, 0);
//		objarr[0][1] = fiu.getExceldata("Sheet1", 0, 1);
//		objarr[1][0] = fiu.getExceldata("Sheet1", 1, 0);
//		objarr[1][1] = fiu.getExceldata("Sheet1", 1, 1);
//		objarr[2][1] = fiu.getExceldata("Sheet1", 2, 1);
//
//		return objarr;
//	}

	/*using for loop for get multiple datas */
	@DataProvider
	public Object[][] getcredential() throws InvalidFormatException, IOException, Exception {
		
		int rowcount=fiu.getrowCount("Sheet1");
		Object[][] objarr = new Object[rowcount][2];
		for(int i=0; i<rowcount; i++) {
			objarr[i][0]=fiu.getExceldata("Sheet1", i, 0);
			objarr[i][1]=fiu.getExceldata("Sheet1", i, 1);
		}
		return objarr;
	}      
	
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
