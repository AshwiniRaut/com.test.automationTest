package com.test.Automation.com.test.automationTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class ListnerTest implements ITestListener {
	WebDriver driver;
	static int i=1;

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		String methodName=result.getName().toString().trim();
		try {
			takeScreenshot(methodName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void takeScreenshot(String methodName) throws IOException
	{
		driver=loginFunctionality.driver;
		TakesScreenshot sccrenShot = ((TakesScreenshot)driver);
		File newFile = sccrenShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("D://"+"_"+methodName+"+"+i+".png");
		i++;
		FileUtils.copyFile(newFile, destFile);
		
		
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

}
