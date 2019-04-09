package com.selenium.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest {

	WebDriver driver;

	@Parameters({ "url", "username", "password", "browser" })
	@Test
	public void firstTest(String url, String username, String password, String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("WebDriver.chrome.driver", "C:\\chromedriver\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("WebDriver.gecko.driver", "C:\\chromedriver\\chromedriver_win32\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("WebDriver.ie.driver", "C:\\chromedriver\\chromedriver_win32\\iedriverserver.exe");
			driver = new InternetExplorerDriver();
		}

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.findElement(By.xpath("//input[@id='identifierIdl']")).sendKeys(username);
		driver.findElement(By.xpath("//span[text()='Next']")).click();

		driver.quit();
	}
}
