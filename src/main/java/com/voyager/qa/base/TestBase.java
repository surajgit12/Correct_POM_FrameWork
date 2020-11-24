   package com.voyager.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.qa.listeners.WebEventListeners;
import com.voyager.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListeners eventListener;

	public TestBase() {

		try {
           	prop = new Properties(); // initailized the property
			FileInputStream input = new FileInputStream(
					"E:\\WorkSpaceAutomations\\POM_Selenium_Project\\src\\main\\java\\com\\voyager\\qa\\configuration\\config.properties");
			prop.load(input);
		} catch (FileNotFoundException e) {

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static void initialization() {

		String browserName = prop.getProperty("browser");
		
		if (browserName.equals("FireFox")) {
			System.setProperty("webdriver.gecko.driver",
					"E:\\WorkSpaceAutomations\\POM_Selenium_Project\\src\\main\\java\\com\\browsers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"E:\\WorkSpaceAutomations\\POM_Selenium_Project\\src\\main\\java\\com\\browsers\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		e_driver = new EventFiringWebDriver(driver);
		// now create object of an EventListener to register it with
		// EventFiringWebDriver
		eventListener = new WebEventListeners();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));

	}

	public void failed(String testMethodName) {

		// ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); // return file object
		// takescreenshot for we have to used class i.e. Fileutils

		// FileUtils.copyFile(srcFile, new File(file path));

		try {
			FileUtils.copyFile(srcfile, new File(
					"E:\\WorkSpaceAutomations\\POM_Selenium_Project\\src\\main\\java\\FailedTestCasesScreenshot\\"
							+ testMethodName + "_" + ".jpg"));
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void flash(WebElement element, WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		String backgrdcolor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 100; i++) {

			changeColor("rgb(0,200,0)", element, driver);
			changeColor(backgrdcolor, element, driver);

		}

	}

	public static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);

	}

	public static void drawborder(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border = '3px solid red'", element);
	}

}
