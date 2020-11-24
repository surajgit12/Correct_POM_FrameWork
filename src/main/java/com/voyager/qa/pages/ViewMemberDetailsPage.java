package com.voyager.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.voyager.qa.base.TestBase;

public class ViewMemberDetailsPage extends TestBase {

	@FindBy(xpath = "//span[contains(text(),'VIEW MEMBER DETAIL - BHNAME, HTNAME')]")
	WebElement ViewMemberFirstNameLastNametext;

	// Initializing the page object
	public ViewMemberDetailsPage() {
				PageFactory.initElements(driver, this); // this means pointing to current class object (LoginPage.class)
					
				}

	public boolean VerifyCorrectfirstLastnametext() {
		return ViewMemberFirstNameLastNametext.isDisplayed();
	}

}
