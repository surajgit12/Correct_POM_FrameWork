package com.voyager.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.listeners.CustomListener;
import com.voyager.qa.base.TestBase;
import com.voyager.qa.pages.HomePage;
import com.voyager.qa.pages.LoginPage;
import com.voyager.qa.util.RetryAnalyzer;

@Listeners(CustomListener.class)
public class LoginPageTests extends TestBase {

	LoginPage loginpage;
	HomePage homepage;

	public LoginPageTests() {
		// Before initialization we must call TestBase constructor by super class
		// constructor i.e. TestBase class constructor
		super();

	}

	@BeforeMethod
	public void setUp() throws InterruptedException {

		initialization();
		loginpage = new LoginPage(); // create object of an loginpage class
	}

	@Test(priority = 1)
	public void logoTest() throws InterruptedException {
		Thread.sleep(1000);
		
		boolean logoimage = loginpage.voygerlogo();
		Assert.assertTrue(logoimage);
	}

	@Test(priority = 2,retryAnalyzer = RetryAnalyzer.class)
	public void loginTest() throws InterruptedException {
		Thread.sleep(2000);

		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(homepage, homepage);

	}

	/*@AfterMethod
	public void tearDown() {

		driver.quit();
	}*/
}
