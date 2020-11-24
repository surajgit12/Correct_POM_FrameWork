package com.voyager.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.qa.listeners.CustomListener;
import com.voyager.qa.base.TestBase;
import com.voyager.qa.pages.HomePage;
import com.voyager.qa.pages.LoginPage;
import com.voyager.qa.pages.SearchMember;
import com.voyager.qa.pages.ViewMemberDetailsPage;


@Listeners(CustomListener.class)
public class ViewMemberDetailsPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homePage;
	SearchMember searchmember;
	ViewMemberDetailsPage viewmemberdetailspage;

	public ViewMemberDetailsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {

		initialization(); // call initialization method
		loginpage = new LoginPage();// create object of an homepage class
	    homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password")); // login method return
																								// the homepage
		searchmember = new SearchMember();
		viewmemberdetailspage = new ViewMemberDetailsPage();

	}

}