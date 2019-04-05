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
import com.training.pom.CYTC_034POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_034 {

	private WebDriver driver;
	private String baseUrl;
	private CYTC_034POM cytc_034POM;
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
		cytc_034POM = new CYTC_034POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		
		//ogin as member and member home page is displayed
		cytc_034POM.sendLoginName("Chaitu"); 
		cytc_034POM.sendPassword("Chaitu@123");
		cytc_034POM.clickSubmitBtn();
		screenShot.captureScreenShot("Test34_1");
		String expected = "Logged user: Chaitu - Chaitra";
		String actual = cytc_034POM.user();
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
		
		
		cytc_034POM.clickAccountTabLink();
		cytc_034POM.clickLoansLink();
		screenShot.captureScreenShot("Test34_2");
		String expected1="My loans";
		String actual1 = cytc_034POM.myLoans();
		
		Assert.assertEquals(expected1, actual1);
		System.out.println(actual1);
		System.out.println("Loans granted by admin should get displayed");
		
		cytc_034POM.clickViewIcon();
		screenShot.captureScreenShot("Test34_3");
		String expected2= "Loan details";
		String actual2=cytc_034POM.viewLoanDetails();
		Assert.assertEquals(expected2, actual2);
		System.out.println(actual2);
		System.out.println("Loan details with Loan repayment option should get displayed");
		
		cytc_034POM.sendAmountText("10");
		screenShot.captureScreenShot("Test34_4");
		cytc_034POM.clickLoanRepayBtn();
		String expected3= "Are you sure to repay 0,10 units?\n\nPlease, click OK to proceed";
		String actual3=driver.switchTo().alert().getText();
		Assert.assertEquals(expected3, actual3);
		System.out.println(actual3);
		driver.switchTo().alert().accept();
		System.out.println("Pop up window should be displayed");
		
		String expected4= "The repayment was succesfully processed";
		String actual4=driver.switchTo().alert().getText();
		Assert.assertEquals(expected4, actual4);
		System.out.println(actual4);
		driver.switchTo().alert().accept();
		System.out.println("Pop up window should be displayed");
		String expected5= "Loan details";
		String actual5=cytc_034POM.repayLoanDetailsPage();
		Assert.assertEquals(expected5, actual5);
		System.out.println(actual5);
		System.out.println("paid amount should get substracted from loan amount");
		screenShot.captureScreenShot("Test34_5");
		
		cytc_034POM.clickLogoutBtn();
		String logoutmsg = driver.switchTo().alert().getText();
		Assert.assertEquals("Please confirm to logout", logoutmsg);
		driver.switchTo().alert().accept();
		screenShot.captureScreenShot("Test34_8");
		
		cytc_034POM.sendLoginName("admin"); 
		cytc_034POM.sendPassword("123456");
		cytc_034POM.clickSubmitBtn();
		screenShot.captureScreenShot("Test34_9");
		String expected6 = "Logged user: admin - admini";
		String actual6 = cytc_034POM.sendUser2();
		Assert.assertEquals(actual6, expected6);
		System.out.println(actual6);
		System.out.println("Admin Home Page is displayed");
		screenShot.captureScreenShot("Test34_6");
		
		cytc_034POM.sendMemberLogin("Chaitu");
		//cytc_034POM.sendMemberFullName("Chaitra");
		screenShot.captureScreenShot("Test31_2");
		String expected7="Profile of Chaitra";
		String actual7= cytc_034POM.memberProfile();
		Assert.assertEquals(actual7, expected7);
		System.out.println("Registered member details are displayed");
		screenShot.captureScreenShot("Test34_10");
		
		cytc_034POM.clickViewLoanBtn();
		String expected8="Loans of Chaitra";
		String actual8= cytc_034POM.loanDetailsPendingAmtPage();
		Assert.assertEquals(actual8, expected8);
		System.out.println(actual8);
		System.out.println("Loan details with pending amount after repayment is displayed");
		screenShot.captureScreenShot("Test34_11"); 
		
		
		
		
		
		
	}}