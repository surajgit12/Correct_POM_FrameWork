package com.voyager.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.voyager.qa.base.TestBase;
import com.voyager.qa.base.launchBrowser;

public class LoginPage extends TestBase {

	// We have to define PageFactory OR we can say that Object Repository

	@FindBy(name = "username")
	private WebElement username;
	
	public WebElement getUseranme() {
		return this.username;
	}

	@FindBy(name = "password")
	WebElement password;

	public WebElement getPassword() {
		return this.password;
	}
	@FindBy(id = "u2")
	WebElement Btn;

	public WebElement getBtn() {
		return this.Btn;
	}
	@FindBy(xpath = "//div[@class='logo-login']//img")
	WebElement logo;
	
	public WebElement getlogo() {
		return this.logo;
	}

	
	// Initializing the page object // this means pointing to current class object
	// (LoginPage.class)

	public LoginPage() throws InterruptedException {

		Thread.sleep(2000);

		PageFactory.initElements(driver, this); // how will you initialize page factory by using PageFactory method

	}

	public boolean voygerlogo() {
		
		flash(logo, driver);
		drawborder(logo, driver);
		
		return logo.isDisplayed();
	}

	public HomePage login(String un, String pwd) throws InterruptedException {

		username.sendKeys(un);
		password.sendKeys(pwd);
		Thread.sleep(3000);
		Btn.click();
		return new HomePage();

	}
	

}
