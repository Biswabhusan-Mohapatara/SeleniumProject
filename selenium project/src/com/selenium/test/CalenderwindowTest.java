package com.selenium.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderwindowTest {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		String exp_month = "May 2019";
		String date = "28";

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.airasia.com/booking/home/en/gb");

		/* enable the calender window */
		driver.findElement(By.xpath("//span[text()='Depart date']")).click();
		Thread.sleep(3000);

		while (true) {
			String month = driver.findElement(By.xpath("//td[@class='month-label']")).getText();
			System.out.println(month);

			if (month.equalsIgnoreCase(exp_month)) {
				break;
			} else {
				driver.findElement(By.xpath("//div[3]//table[1]//thead[1]//tr[2]//td[3]//i[1]")).click();
			}
		}

//		driver.findElement(By.xpath("//div[@class='aa-calendar-body']//div[1]//table[1]//tbody[1]//tr[5]//td[2]//div[1]")).click();

		List<WebElement> dates=driver.findElements(By.xpath("//div[@class='aa-calendar-body']//div[1]//table[1]//tbody[1]//tr//td"));
				for (WebElement date_air : dates) {
					if (date_air.equals(date)) {
						date_air.click();
						break;
					}
				}
	}

}
