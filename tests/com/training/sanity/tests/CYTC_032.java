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
import com.training.pom.CYTC_032POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_032 {

	private WebDriver driver;
	private String baseUrl;
	private CYTC_032POM cytc_032POM;
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
		cytc_032POM = new CYTC_032POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		
		//Login as admin and admin home page is displayed
		cytc_032POM.sendLoginName("admin"); 
		cytc_032POM.sendPassword("123456");
		cytc_032POM.clickSubmitBtn();
		screenShot.captureScreenShot("Test32_1");
		String expected = "Logged user: admin - admini";
		String actual = cytc_032POM.user();
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
		
		//registered member details are displayed
		cytc_032POM.sendMemberLogin("Chaitu");
		//cytc_003POM.sendMemberFullName("Chaitra");
		screenShot.captureScreenShot("Test32_2");
		String expected1="Profile of Chaitra";
		String actual1= cytc_032POM.memberProfile();
		Assert.assertEquals(actual1, expected1);
		System.out.println("Registered member details are displayed");
		screenShot.captureScreenShot("Test32_3");
		
		//Payment System to member click
		cytc_032POM.clickPaymentSystemToMem();
		String expected2= "Payment system to member";
		String actual2=cytc_032POM.paymentSystemToMempage();
		System.out.println(actual2);
		Assert.assertEquals(actual2, expected2);
		System.out.println("Payment system to member page should get displayed");
		screenShot.captureScreenShot("Test32_3");
		
		//payment details are entered
		cytc_032POM.sendamountText("10");
		cytc_032POM.sendtranactionTypeListBox("Debit to member");
		cytc_032POM.sendDescriptionBox("bonus");
		cytc_032POM.clickPayMemSubmitBtn();
		screenShot.captureScreenShot("Test32_4");
		String expected3="You are about to perform the following payment:";
		String actual3=cytc_032POM.payMemConfirmPage();
		Assert.assertEquals(actual3, expected3);
		System.out.println(actual3);
		System.out.println("Payment confirm Page is displayed");

		//confirm payment page
		cytc_032POM.clickPayMemConfirmPage();
		screenShot.captureScreenShot("Test32_5");
		String expected4="The payment has been performed";
		String actual4=cytc_032POM.paymentSuccessfulPage();
		Assert.assertEquals(actual4, expected4);
		System.out.println(actual3);
		System.out.println("The payment has been performed  message should get displayed");
		
		//Clicking on logout btn
				cytc_032POM.clickLogoutBtn();
				String logoutmsg = driver.switchTo().alert().getText();
				Assert.assertEquals("Please confirm to logout", logoutmsg);
				driver.switchTo().alert().accept();
				screenShot.captureScreenShot("Test032_6");
				
				//account added by admin should get displayed
				cytc_032POM.sendLoginName("Chaitu"); 
				cytc_032POM.sendPassword("Chaitu@123");
				cytc_032POM.clickSubmitBtn();
				screenShot.captureScreenShot("Test32_7");
				String expected6 = "Logged user: Chaitu - Chaitra";
				String actual6 = cytc_032POM.user1();
				Assert.assertEquals(actual6, expected6);
				System.out.println(actual6);
				System.out.println("member Page is displayed");
				
				
				cytc_032POM.clickAccountTab();
				cytc_032POM.clickAccountInfoLink();
				screenShot.captureScreenShot("Test32_8");
				String expected7 = "Search transactions on Member account";
				String actual7 = cytc_032POM.actAddByAdminPage();
				Assert.assertEquals(actual7, expected7);
				System.out.println(actual7);
				System.out.println("Account added by admin is displayed");
				
				
	}
}