package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.CYTC_004POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_004 {

	private WebDriver driver;
	private String baseUrl;
	private CYTC_004POM cytc_004POM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		cytc_004POM = new CYTC_004POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() {
		
		//Login as member and member home page is displayed
		cytc_004POM.sendLoginName("reguser2"); 
		cytc_004POM.sendPassword("reguser2");
		screenShot.captureScreenShot("Test4_1");
		cytc_004POM.clickSubmitBtn();
		screenShot.captureScreenShot("Test4_2");
		String expected = "Logged user: reguser2 - reguser2";
		String actual = cytc_004POM.user1();
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
		System.out.println("Member Home Page is displayed");
		 
		
		screenShot.captureScreenShot("First");
	}
}
