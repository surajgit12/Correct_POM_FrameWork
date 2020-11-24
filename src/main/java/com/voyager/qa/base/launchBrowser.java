package com.voyager.qa.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class launchBrowser {
	
	public static WebDriver driver;
	
	
	@Parameters({"browser", "url", "username", "password"})
    @BeforeMethod
	public void ParrallelaunchBrowser(String browser, String url, String username, String password) {

	
		if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"E:\\WorkSpaceAutomations\\POM_Selenium_Project\\src\\main\\java\\com\\browsers\\geckodriver.exe");
			driver = new FirefoxDriver();
	
		}

		else if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"E:\\WorkSpaceAutomations\\POM_Selenium_Project\\src\\main\\java\\com\\browsers\\chromedriver.exe");
			driver = new ChromeDriver();
	
			
			driver.get(url);
			driver.findElement(By.name("username")).sendKeys(username);
			driver.findElement(By.name("password")).sendKeys(password);
		}

	}

}
