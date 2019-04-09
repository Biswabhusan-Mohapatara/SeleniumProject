package com.selenium.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class BrowserpopoupTest {

	
		 public static WebDriver driver;
			@Test
			public void loginTest() {
			
		     
		     driver=new FirefoxDriver();
		     driver.manage().window().maximize();
		     driver.manage().deleteAllCookies();
		     driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		     driver.get("http://www.yahoo.com");
		     
		     driver.findElement(By.xpath("//span[text()='Next")).click();
		     String parentwindow=driver.getWindowHandle();
		     
		     Set<String> windows=driver.getWindowHandles();
		     for (String childwindow : windows) {
				if(!parentwindow.equalsIgnoreCase(childwindow)) {
					driver.switchTo().window(childwindow);
					driver.close();
				}
			}
		     driver.switchTo().window(parentwindow);
		     driver.quit();
		     
		     
		     /*iterator way */
		     Set<String> windows111=driver.getWindowHandles();
		     Iterator<String> it=windows111.iterator();
		     
		     String parentwin=it.next();
		     String childwin=it.next();
		     
		     driver.switchTo().window(childwin);
		     driver.findElement(By.xpath("//span[text()='jhaxhjxasj")).click();
		     driver.close();
		     driver.switchTo().window(parentwin);
		     driver.quit();
		     
		     /*to handle multiple windows */
		     Set<String> windows55555=driver.getWindowHandles();
		     ArrayList<String> tabs=new ArrayList<>(windows55555);
		     driver.switchTo().window(tabs.get(2));
		     driver.switchTo().window(tabs.get(0));
		     driver.quit();
		     
		     
		     
		     
		     
		     
		     
		     
		     
		     
		     
		     
		     
		     
		     
		     
		     
		     
	}

}
