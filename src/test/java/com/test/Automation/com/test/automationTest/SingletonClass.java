package com.test.Automation.com.test.automationTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingletonClass {
	private static WebDriver driver;
	public static WebDriver getSingletonInstance()
	{
		if(driver== null)
		{
			System.out.println("in webdriver");
			System.setProperty("webdriver.chrome.driver", "D:/Ashwini/chromedriver.exe");
			driver = new ChromeDriver();
		}
		return driver;
	}
	private SingletonClass()
	{
		
	}
	

}
