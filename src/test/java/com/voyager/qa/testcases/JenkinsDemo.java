package com.voyager.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JenkinsDemo {
	public static WebDriver driver;

	public void launchBrowser() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\GlobalLogic\\eclipse-workspace\\Jenkins_Suite_Demo\\src\\main\\java\\Browsers\\chromedriver.exe");
//		driver = new ChromeDriver();
	}


	 @Test
	 public void OpenUrl() {
		 driver = new ChromeDriver();
		 driver.get("https://www.google.com/");
		 Assert.assertEquals(true, true);
	 }
	 
	 @Test
	 public void GetUrl() {
		 driver = new ChromeDriver();
		 driver.get("https://www.yahoo.com/");
	 }
	}
