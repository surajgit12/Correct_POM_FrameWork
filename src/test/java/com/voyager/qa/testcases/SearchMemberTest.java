package com.voyager.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.listeners.CustomListener;
import com.voyager.qa.base.TestBase;
import com.voyager.qa.pages.HomePage;
import com.voyager.qa.pages.LoginPage;
import com.voyager.qa.pages.SearchMember;
import com.voyager.qa.util.TestUtil;


@Listeners(CustomListener.class)
public class SearchMemberTest extends TestBase {

	LoginPage loginpage;
	HomePage homePage;
	SearchMember searchmember;

	String sheetName = "searchmember";
	String sheetName1 = "searchcount";

	public SearchMemberTest() {
		super();
	}

	
	
	@BeforeMethod
	public void setUp() throws InterruptedException {

		initialization(); // call initialization method
		loginpage = new LoginPage();// create object of an homepage class
		homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		searchmember = new SearchMember();
	}

	@DataProvider
	public Object[][] getSearchMembersData() throws EncryptedDocumentException, InvalidFormatException {

		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}

	
	
	@Test(priority = 1, dataProvider = "getSearchMembersData")
	public void validateSearchMemberTest(String searchtype, String planid, String pbp, String segmentnumber,
			String birthdate, String status, String membereffectivedate, String gender) throws InterruptedException {

		homePage.ClickOnMemberLink();
	    searchmember.searchNewMember(searchtype, planid, pbp, segmentnumber, birthdate, status, membereffectivedate,
				gender);

	}

	@DataProvider
	public Object[][] getSearchMembersSingleData() throws EncryptedDocumentException, InvalidFormatException {
		Object[][] data = TestUtil.getTestData(sheetName1);
		return data;

	}

	@Test(priority = 2, dataProvider = "getSearchMembersSingleData")
	public void searchSingleMemberCountTest(String searchtype, String memberid, String medicareid, String firstname,
			String lastname) throws InterruptedException {

		homePage.ClickOnMemberLink();
		searchmember.searchSingleMemberCount(searchtype, memberid, medicareid, firstname, lastname);

		Assert.assertTrue(searchmember.verifyMemberSearchCountPage());

	}

	/*@AfterMethod
	public void TearDown() {
		driver.quit();
	}
*/
}
