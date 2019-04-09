package com.selenium.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtils {

	/* wait for page to load */
	public void waitforPagetoload(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
		
	/* wait for element to load */
	public void waitforelementtoload(WebDriver driver,WebElement wb) {
		WebDriverWait wait=new WebDriverWait(driver, 40);
		     wait.until(ExpectedConditions.visibilityOf(wb));
	}
	
	/* wait for complete element to load */
	public void waitforcompleteelementtoload(WebElement element) throws Exception {
		int count=0;
		while(count<40) {
			try {
				element.isDisplayed();
				break;
			}
			catch (Exception e) {
				Thread.sleep(2000);
				count++;
			}
		}
	}
}
