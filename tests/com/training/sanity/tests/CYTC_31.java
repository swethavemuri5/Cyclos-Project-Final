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
import com.training.pom.CYTC_31POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_31 {

	private WebDriver driver;
	private String baseUrl;
	private CYTC_31POM cytc_31POM;
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
		cytc_31POM = new CYTC_31POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		
		//Login as admin and admin home page is displyed
		cytc_31POM.sendLoginName("admin"); 
		cytc_31POM.sendPassword("123456");
		cytc_31POM.clickSubmitBtn();
		screenShot.captureScreenShot("Test31_1");
		String expected = "Logged user: admin - admini";
		String actual = cytc_31POM.user();
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
		
		
		cytc_31POM.sendMemberLogin("Chaitu");
		//cytc_003POM.sendMemberFullName("Chaitra");
		screenShot.captureScreenShot("Test31_2");
		String expected1="Profile of Chaitra";
		String actual1= cytc_31POM.memberProfile();
		Assert.assertEquals(actual1, expected1);
		System.out.println("Registered member details are displayed");
		screenShot.captureScreenShot("Test31_3");
		
		
		//clicking advertisement btn in manage avertisements
		cytc_31POM.clickAdvertisementBtn();
		screenShot.captureScreenShot("Test3_4");
		String expected2="Advertisements of Chaitra";
		String actual2= cytc_31POM.memAdvertise();
		Assert.assertEquals(actual2, expected2);
		System.out.println(actual2);
		System.out.println("Advertisements of selected member with existing advertisement details page is displayed");
		
		//Insertion of new advertisement for the member
		cytc_31POM.clickInsertAdvBtn();
		screenShot.captureScreenShot("Test31_5");
		String expected3 ="New advertisement";
		String actual3 = cytc_31POM.memAdv();
		Assert.assertEquals(expected3,actual3);
		System.out.println(actual3);
		System.out.println("New advertisement page is displayed");		
		
		
		//Entering the required details in new advertisement page
		cytc_31POM.sendTitle("new offer");
		cytc_31POM.sendAdvCategoryListBox("Example ad category");
		cytc_31POM.sendPrice("50");
		cytc_31POM.notExpirable();
		cytc_31POM.description("New offer for member");
		screenShot.captureScreenShot("Test31_6");
		cytc_31POM.clickSubmitAdvBtn2();
		String advInsetedMsg = driver.switchTo().alert().getText();
		//screenShot.captureScreenShot("Test31_7");
		Assert.assertEquals("Advertisement inserted", advInsetedMsg);
		System.out.println(advInsetedMsg);
		driver.switchTo().alert().accept();
		String expected4 = "Modify advertisement";
		String actual4 = cytc_31POM.modifyAdv();
		Assert.assertEquals(actual4, expected4);
		System.out.println(actual4);
		System.out.println("Modify advertisement with non editable field should be dispalyed");
		
		//Clicking on logout btn
		cytc_31POM.clickLogoutBtn();
		String logoutmsg = driver.switchTo().alert().getText();
		Assert.assertEquals("Please confirm to logout", logoutmsg);
		driver.switchTo().alert().accept();
		screenShot.captureScreenShot("Test31_8");
		
		//login as member to check whether advertidsements added by admin are added to member
		cytc_31POM.sendLoginName("Chaitu"); 
		cytc_31POM.sendPassword("Chaitu@123");
		cytc_31POM.clickSubmitBtn();
		screenShot.captureScreenShot("Test31_9");
		String expected6 = "Logged user: Chaitu - Chaitra";
		String actual6 = cytc_31POM.user1();
		Assert.assertEquals(actual6, expected6);
		System.out.println(actual6);
		System.out.println("member Page is displayed");
		
		cytc_31POM.clickpersonalTabLink();
		screenShot.captureScreenShot("Test31_1");
		cytc_31POM.clickadvertisementLink();
		String expected5 = "My advertisements";
		String actual5= cytc_31POM.myAdv();
		Assert.assertEquals(actual5, expected5);
		System.out.println(actual5);
		System.out.println("member Page with the admin added adv page is  displayed");
		
		
	}
}
