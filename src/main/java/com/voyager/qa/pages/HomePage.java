package com.voyager.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.voyager.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//a[text() ='Enrollment']")
	WebElement enrollmentlink;

	@FindBy(xpath = "//a[text() ='Members']")
	WebElement memberlink;

	// Initializing the page object
	public HomePage()

	{

		PageFactory.initElements(driver, this); // this means pointing to current class object (LoginPage.class)
	}

	public boolean ClickOnMemberLink() throws InterruptedException {
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		action.moveToElement(enrollmentlink).build().perform();
		memberlink.click();
		// return new SearchMembers();
		return true;

	}
}
