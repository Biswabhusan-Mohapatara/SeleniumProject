package com.selenium.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class PropertyTest {
	
        public static WebDriver driver;
        
	public static void main(String[] args) throws IOException {
		
		FileInputStream fi=new FileInputStream("C:\\Users\\Asus-User\\eclipse-workspace\\selenium project\\config.properties");
		Properties prop=new Properties();
		prop.load(fi);

		System.out.println((prop.getProperty("url")));
		System.out.println((prop.getProperty("username")));
		System.out.println((prop.getProperty("pasword")));
		System.out.println((prop.getProperty("browser")));
		
	}

}
