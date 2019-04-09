package com.selenium.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.selenium.genericlib.BaseClass;

@Listeners(com.selenium.genericlib.TestNgListner.class)
public class MyScreenshotTest extends BaseClass {

	
	@Test
	public void titleTest() {
		String expTitie="Google";
		String actTitle=driver.getTitle();
		Assert.assertEquals(actTitle, expTitie);
		System.out.println("Title matched");
	}
	
	@Test
	public void createTest() {
		Assert.assertTrue(false);
	}
}
