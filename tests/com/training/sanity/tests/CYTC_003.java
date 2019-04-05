package com.training.sanity.tests;

import static org.testng.AssertJUnit.assertEquals;

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
import com.training.pom.CYTC_003POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_003 {

	private WebDriver driver;
	private String baseUrl;
	private CYTC_003POM cytc_003POM;
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
		cytc_003POM = new CYTC_003POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		
		//Login as admin and admin page is displayed
		cytc_003POM.sendLoginName("admin"); 
		cytc_003POM.sendPassword("123456");
		cytc_003POM.clickSubmitBtn();
		screenShot.captureScreenShot("Test3_1");
		String expected = "Logged user: admin - admini";
		String actual = cytc_003POM.user();
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
		System.out.println("Admin Page is displayed");
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() {
		
		//specific member page is displayed
		cytc_003POM.sendMemberLogin("reguser2");
		//cytc_003POM.sendMemberFullName("Chaitra");
		screenShot.captureScreenShot("Test3_2");
		String expected1="Profile of reguser2";
		String actual1= cytc_003POM.memberProfile();
		Assert.assertEquals(actual1, expected1);
		System.out.println("Registered member details are displayed");
		screenShot.captureScreenShot("Test3_6");
		
		// change group for member reguser2
		cytc_003POM.clickSubmitBtn1();
		screenShot.captureScreenShot("Test3_3");
		String expected2="Change group for member reguser2";
		String actual2= cytc_003POM.changeGroupPage();
		Assert.assertEquals(actual2, expected2);
		System.out.println("Change group for memeber page is displayed");
		
		cytc_003POM.sendNewGroupListBox("Full members");
		cytc_003POM.sendComments("Full access to the member");
		screenShot.captureScreenShot("Test3_4");
		cytc_003POM.clickSubmitBtn2();
		
		String expected3="The member's group was changed";
		String actual3= driver.switchTo().alert().getText().trim();
		driver.switchTo().alert().accept();
		System.out.println(actual3);
		assertEquals(expected3,actual3);
		
		System.out.println("Changed group for member is displayed");		
		
		screenShot.captureScreenShot("Test3_5");
	}
}
