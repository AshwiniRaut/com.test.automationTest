package com.test.Automation.com.test.automationTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListnerTest.class)
public class loginFunctionality {
	static WebDriver driver=SingletonClass.getSingletonInstance();
	
	//SingletonClass obj=SingletonClass.getSingletonInstance();
	public static void launchUrl()
	{
		driver.get("https://www.linkedin.com/");
		driver.manage().window().maximize();
		
	}
	@Test(dataProvider="authentication")
	public void checkLoginFunctionality(String userName, String PassWord)
	{
		launchUrl();
		Assert.assertEquals(driver.getTitle(), "LinkedIn: Log In or Sign Up");
		driver.findElement(By.id("login-email")).sendKeys(userName);
		driver.findElement(By.id("login-password")).sendKeys(PassWord);
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.findElement(By.id("login-submit")).click();
		WebDriverWait wait= new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.titleContains("LinkedIn"));
		Assert.assertEquals(driver.getTitle(), "LinkedIn", "login is successfull");
		
	}
	@DataProvider(name="authentication")
	public Object[][] provideData() throws IOException
	{
		
		Object[][] arrayObject=ReadExcelFile.readData();
		return arrayObject;
		
	}
	@Test
	public void closeDriver()
	{
		driver.close();
	}

}
