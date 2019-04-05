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
import com.training.pom.CYTC_005POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_005 {

	private WebDriver driver;
	private String baseUrl;
	private CYTC_005POM cytc_005POM;
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
		cytc_005POM = new CYTC_005POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		
		//Login as member and member home pageis displayed
		cytc_005POM.sendLoginName("reguser2"); 
		cytc_005POM.sendPassword("reguser2");
		cytc_005POM.clickSubmitBtn();
		screenShot.captureScreenShot("Test5_1");
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() {
		
		
		cytc_005POM.clickMYProfileIcon();
		screenShot.captureScreenShot("Test5_2");
		String expected="My profile";
		String actual = cytc_005POM.myProfile();
		System.out.println(actual);
		Assert.assertEquals(expected, actual);
		System.out.println("Member profile with existing profile details is displayed");
		
		//Member detais are changed
		cytc_005POM.clickChangeBtn1();
		screenShot.captureScreenShot("Test5_3");
		System.out.println("All fields becomes editable");
		cytc_005POM.sendAddressChange("krishna");
		screenShot.captureScreenShot("Test5_4");
		System.out.println("Address field is changed");
		cytc_005POM.clickSubmitBtn2();
		screenShot.captureScreenShot("Test5_5");
		/*String expected2="Profile modified";
		String actual2= driver.switchTo().alert().getText();
		//screenShot.captureScreenShot("Test5_6");
		driver.switchTo().alert().accept();
		System.out.println(actual2);
		assertEquals(expected2,actual2);*/
		String profilemodifiedmsg = driver.switchTo().alert().getText();
		screenShot.captureScreenShot("Test5_6");
		Assert.assertEquals("Profile modified", profilemodifiedmsg);
		System.out.println(profilemodifiedmsg);
		driver.switchTo().alert().accept();
		System.out.println("My profile page with modified changes is displyed");
		
		screenShot.captureScreenShot("Test5_7");
	}
}
