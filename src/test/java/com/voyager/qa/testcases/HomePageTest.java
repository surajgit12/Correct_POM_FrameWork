package com.voyager.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.listeners.CustomListener;
import com.voyager.qa.base.TestBase;
import com.voyager.qa.pages.HomePage;
import com.voyager.qa.pages.LoginPage;



@Listeners(CustomListener.class) // how class will get to know that it has to listen we have to use Listener annotation and from custom listenr class
public class HomePageTest extends TestBase{
	

	LoginPage loginpage;
	HomePage homePage;

	public HomePageTest()
	{
		super();
	}

	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
	
		
		initialization(); // call initialization method
         loginpage = new LoginPage();// create object of an homepage class
	     homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password")); //login method return the homepage
		}
	
	
	@Test(priority =1)
	public void clickonMemberlinkTest() throws InterruptedException {
		
		//homePage.ClickOnMemberLink();
		 
		 Assert.assertTrue(homePage.ClickOnMemberLink());
	}
	
	
	
	/*@AfterMethod
	public void tearDown() {

		driver.quit();
	}*/

}


