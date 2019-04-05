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
import com.training.pom.CYTC_035POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_035 {

	private WebDriver driver;
	private String baseUrl;
	private CYTC_035POM cytc_035POM;
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
		cytc_035POM = new CYTC_035POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		cytc_035POM.sendLoginName("Chaitu"); 
		cytc_035POM.sendPassword("Chaitu@123");
		cytc_035POM.clickSubmitBtn();
		screenShot.captureScreenShot("Test35_1");
		String expected = "Logged user: Chaitu - Chaitra";
		String actual = cytc_035POM.user();
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
		System.out.println("Member Home Page is displayed");
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() {
		
		
		cytc_035POM.clickaccountTab();
		cytc_035POM.clickSystemPaymentLink();
		String expected1="Payment to system";
		String actual1 = cytc_035POM.paymentSystempage();
		
		Assert.assertEquals(expected1, actual1);
		System.out.println(actual1);
		System.out.println("Payment system window is displayed");
		cytc_035POM.amountTextBox("2");
		cytc_035POM.transactionTypeListBox("Member to community");
		cytc_035POM.paymentDescriptions("Charity");
		screenShot.captureScreenShot("Test35_2");
		cytc_035POM.clickPaymentSubmitBtn();
		String expected2= "You are about to perform the following payment:";
		String actual2=cytc_035POM.transactionConfrimPagelabel();
		cytc_035POM.clickconfirmTransactionsubmitBtn();
		String expected3 = "The payment has been performed";
		String actual3= cytc_035POM.successfulPaymentPage();
		System.out.println(actual3);
		Assert.assertEquals(expected3,actual3);
		
		System.out.println("Payment successful page is displayed");
		screenShot.captureScreenShot("Test35_3");
		cytc_035POM.clickAccountInfolink();
		String expected4="Search transactions on Member account";
		String actual4=cytc_035POM.viewTranscationDetailsPage();
		System.out.println(actual4);
		Assert.assertEquals(actual4, expected4);
		System.out.println("transaction details made by member should get displayed");
		screenShot.captureScreenShot("Test35_4");
	}
}