package com.voyager.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.voyager.qa.base.TestBase;

public class SearchMember extends TestBase {

	@FindBy(name = "memberIdSearchTypeBasic")
	WebElement selectsearchtype;

	@FindBy(name = "planIdBasic")
	WebElement selectplanid;

	@FindBy(name = "pbpBasic")
	WebElement selectpbp;

	@FindBy(name = "segmentNumBasic")
	WebElement selectsegmentnumber;

	@FindBy(name = "birthDateBasic")
	WebElement selectbirthDate;

	@FindBy(name = "statusBasic")
	WebElement selectstatus;

	@FindBy(name = "memEffectiveDateBasic")
	WebElement selectmemEffectiveDate;

	@FindBy(name = "genderCodeBasic")
	WebElement selectgenderCode;

	@FindBy(xpath = "//button[@class ='btn primary save-dialog' and @type = 'button']")
	WebElement searchmemberbtn;

	@FindBy(xpath = "//font[text()= 'Total 5 Records.']")
	WebElement recordscounts;

	@FindBy(xpath = " //a[text() ='15408']")
	WebElement memberidlink;

	// 2nd webelement for dataprovider

	@FindBy(name = "memberIDTextBasic")
	WebElement memberid;

	@FindBy(name = "medicareIdBasic")
	WebElement medicareid;

	@FindBy(name = "nameFirstBasic")
	WebElement firstname;

	@FindBy(name = "nameLastBasic")
	WebElement lastname;

	@FindBy(xpath = "//font[text()= 'Total 1 Records.']")
	WebElement membersearchcount;

	@FindBy(xpath = "//span[contains(text(),'VIEW MEMBER DETAIL - BHNAME, HTNAME')]")
	WebElement ViewMemberFirstNameLastNametext;

	// Initializing the page object
	public SearchMember() {
		PageFactory.initElements(driver, this); // this means pointing to current class object (LoginPage.class)

	}

	public void searchmemberid() {

		// driver.findElement(By.xpath("//a[text() ='Members']")).click();
		Select select = new Select(driver.findElement(By.name("memberIdSearchTypeBasic")));
		select.selectByIndex(1);
		driver.findElement(By.id("memberIDTextBasic")).sendKeys("15408");
		driver.findElement(By.xpath("//button[@class='btn primary save-dialog' and @type ='button']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'15408')]")).click();

	}

	public void searchNewMember(String stype, String planidd, String pbpp, String seg, String dob, String statuss,
			String meffedate, String gcode) throws InterruptedException {

		Select select = new Select(driver.findElement(By.name("memberIdSearchTypeBasic")));
		select.selectByVisibleText(stype);

		Select select1 = new Select(driver.findElement(By.name("planIdBasic")));
		select1.selectByVisibleText(planidd);

		Select select2 = new Select(driver.findElement(By.name("pbpBasic")));
		select2.selectByVisibleText(pbpp);

		Select select3 = new Select(driver.findElement(By.name("segmentNumBasic")));
		select3.selectByVisibleText(seg);

		selectbirthDate.sendKeys(dob);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.getElementById('memberIDTextBasic').focus();");
		Thread.sleep(5000);

		Select select5 = new Select(driver.findElement(By.name("statusBasic")));
		select5.selectByVisibleText(statuss);

		selectmemEffectiveDate.sendKeys(meffedate);
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("document.getElementById('memberIDTextBasic').focus();");
		Thread.sleep(5000);

		Select select7 = new Select(driver.findElement(By.name("genderCodeBasic")));
		select7.selectByVisibleText(gcode);

		searchmemberbtn.click();
		memberidlink.click();

	}
	
	
	public void searchSingleMemberCount(String searchtypes, String memberids,String medicareids,String firstnames,String lastnames) 
	
	{
		
		Select select = new Select(driver.findElement(By.name("memberIdSearchTypeBasic")));
		select.selectByVisibleText(searchtypes);
		
		driver.findElement(By.name("memberIDTextBasic")).sendKeys(memberids);
		driver.findElement(By.name("medicareIdBasic")).sendKeys(medicareids);
		driver.findElement(By.name("nameFirstBasic")).sendKeys(firstnames);
		driver.findElement(By.name("nameLastBasic")).sendKeys(lastnames);
		searchmemberbtn.click();

}

	public ViewMemberDetailsPage VefifyviweMemberDetailspage() {
		return new ViewMemberDetailsPage();
	}

	public boolean verifyMemberSearchCountPage() throws InterruptedException {
		Thread.sleep(2000);
		return membersearchcount.isDisplayed();

	}

}
