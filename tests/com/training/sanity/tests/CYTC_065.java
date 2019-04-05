package com.training.sanity.tests;

import static org.testng.AssertJUnit.assertEquals;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.CYTC_065POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class CYTC_065 {

	private WebDriver driver;
	private String baseUrl;
	private CYTC_065POM cytc_065POM;
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
		cytc_065POM = new CYTC_065POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		
		cytc_065POM.sendLoginName1("admin"); 
		cytc_065POM.sendPassword1("123456");
		screenShot.captureScreenShot("Test65_1");
		cytc_065POM.clickSubmitBtn3();
		screenShot.captureScreenShot("Test65_2");
		String expected = "Logged user: admin - admini";
		String actual = cytc_065POM.user();
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
		System.out.println("Admin Page is displayed");
	}
	
	@Test(dataProvider="excel-inputs2",dataProviderClass = LoginDataProviders.class)
	public void validRegistrationTest(String memberLogin) throws InterruptedException {
	
	cytc_065POM.sendMemberLogin(memberLogin);
	//cytc_063POM.sendMemberFullName("Chaitra");
	screenShot.captureScreenShot("Test65_20");
	/*String expected1="Profile of reguser1";
	String actual1= cytc_065POM.memberProfile();
	Assert.assertEquals(actual1, expected1);*/
	System.out.println("Registered member details are displayed");
	screenShot.captureScreenShot("Test65_21");

	// change group for member 
	cytc_065POM.clickSubmitBtn4();
	screenShot.captureScreenShot("Test65_23");
	
	/*String expected2="Change group for member reguser1";
	String actual2= cytc_065POM.changeGroupPage();
	Assert.assertEquals(actual2, expected2);*/

	System.out.println("Change group for memeber page is displayed");


	cytc_065POM.sendNewGroupListBox("Full members");
	cytc_065POM.sendComments("Full access to the member");
	screenShot.captureScreenShot("Test65_24");
	cytc_065POM.clickSubmitBtn5();

	String expected3="The member's group was changed";
	String actual3= driver.switchTo().alert().getText().trim();
	driver.switchTo().alert().accept();
	System.out.println(actual3);
	assertEquals(expected3,actual3);

	System.out.println("Changed group for member is displayed");		

	screenShot.captureScreenShot("Test65_25");
	}

}