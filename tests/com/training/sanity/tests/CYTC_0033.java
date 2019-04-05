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
import com.training.pom.CYTC_0033POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_0033 {

	private WebDriver driver;
	private String baseUrl;
	private CYTC_0033POM cytc_0033POM;
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
		cytc_0033POM = new CYTC_0033POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		
		//Login as admin page and admin home page is displayed.
        cytc_0033POM.sendLoginName("admin"); 
		cytc_0033POM.sendPassword("123456");
		cytc_0033POM.clickSubmitBtn();
		screenShot.captureScreenShot("Test31_1");
		String expected = "Logged user: admin - admini";
		String actual = cytc_0033POM.user();
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
		
		//Member details page
		cytc_0033POM.sendMemberLogin("Chaitu");
		//cytc_003POM.sendMemberFullName("Chaitra");
		//screenShot.captureScreenShot("Test0033_2");
		String expected1="Profile of Chaitra";
		String actual1= cytc_0033POM.memberProfile();
		Assert.assertEquals(actual1, expected1);
		System.out.println("Registered member details are displayed");
		screenShot.captureScreenShot("Test0033_2");
		
		//click submit of grant
		cytc_0033POM.grantLoanBtn();
		
		//loan details of member is displayed   
		String expected2="Grant loan to Chaitra";
		String actual2= cytc_0033POM.grantLoanPage();
		Assert.assertEquals(actual2, expected2);
		System.out.println(actual2);
		System.out.println("Loan details of the member are displayed");
		screenShot.captureScreenShot("Test0033_3");
		cytc_0033POM.amountBox("600");
		cytc_0033POM.descriptionGrantloan("Home Loan");
		cytc_0033POM.grantLoanSubmitBtn();
		String expected3= "Loan confirmation";
		String actual3= cytc_0033POM.loanConfrimPage();
		Assert.assertEquals(actual3, expected3);
		System.out.println(actual3);
		System.out.println("Loan Confirmation page is displayed");
		//screenShot.captureScreenShot("Test0033_4");
		cytc_0033POM.confrimGrantLoanSubmitBtn();
		String loanGrantMsg = driver.switchTo().alert().getText();
		//screenShot.captureScreenShot("Test0033_5");
		Assert.assertEquals("The loan was successfully granted", loanGrantMsg);
		System.out.println(loanGrantMsg);
		driver.switchTo().alert().accept();
		String expected4="Profile of Chaitra";
		String actual4= cytc_0033POM.memberProfile();
		Assert.assertEquals(actual4, expected4);
		System.out.println("Registered member details are displayed");
		cytc_0033POM.viewLoanBtn();
		screenShot.captureScreenShot("Test0033_6");
		String expected5= "Loans of Chaitra";
		String actual5= cytc_0033POM.memLoanPage();
		Assert.assertEquals(actual5, expected5);
		System.out.println(actual5);
		System.out.println("Detils of loans granted to memberare displayed");
		
		
		
		
	}
}	