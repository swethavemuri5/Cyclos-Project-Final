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
import com.training.pom.CYTC_064POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class CYTC_064 {

	private WebDriver driver;
	private String baseUrl;
	private CYTC_064POM cytc_064POM;
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
		cytc_064POM = new CYTC_064POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		cytc_064POM.clickRegisterBtn();
		screenShot.captureScreenShot("Test064_RegisterButton");
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
	
	@Test
	public void validLoginTest() {
		
		cytc_064POM.sendLoginName("abcdef");
		screenShot.captureScreenShot("Test64_1");
		
		cytc_064POM.sendFullName("abcdef");
		screenShot.captureScreenShot("Test64_2");
		 
		cytc_064POM.sendEmail("abc@gmail.com");
		screenShot.captureScreenShot("Test64_3");
		cytc_064POM.sendBirthday("02102001");
		screenShot.captureScreenShot("Test64_4");
		 
		
		cytc_064POM.sendGender("Male");
		screenShot.captureScreenShot("Test64_5");
		cytc_064POM.sendAddress("Kukatpally");
		screenShot.captureScreenShot("Test64_6");
		cytc_064POM.sendPostalCode("5496321");
		//screenShot.captureScreenShot("Test61_7");
		cytc_064POM.sendCity("Hyderabad");
		//screenShot.captureScreenShot("Test61_8");
		cytc_064POM.sendArea("Example area");
		screenShot.captureScreenShot("Test64_9");
		cytc_064POM.sendPhone("2369874125");
		//screenShot.captureScreenShot("Test61_10");
		cytc_064POM.sendMobilePhone("2369874125");
		//screenShot.captureScreenShot("Test61_11");
		cytc_064POM.sendFax("2369874125");
		screenShot.captureScreenShot("Test64_12");
		cytc_064POM.sendUrl("www.google.com");
		screenShot.captureScreenShot("Test64_13");
		//screenShot.captureScreenShot("Test1_third");
		screenShot.captureScreenShot("Test64_14");
		cytc_064POM.sendPassword("abcd123");
		//screenShot.captureScreenShot("Test64_15");
		cytc_064POM.sendConfirmPassword("abcd123");
		screenShot.captureScreenShot("Test64_16");
		cytc_064POM.sendCaptcha("admin");
		screenShot.captureScreenShot("Test64_17");
		 
		 
			 cytc_064POM.clickSubmitBtn();
			
		 String expectedResult;
		 String actualResult;
		 expectedResult = "You have not typed the image characters correctly" ;
         actualResult= driver.switchTo().alert().getText().trim();
         driver.switchTo().alert().accept();
         System.out.println(actualResult);
         assertEquals(expectedResult,actualResult);
		

driver.get(baseUrl);
cytc_064POM.sendLoginName1("admin"); 
cytc_064POM.sendPassword1("123456");
screenShot.captureScreenShot("Test64_1");
cytc_064POM.clickSubmitBtn3();
screenShot.captureScreenShot("Test2_2");
String expected = "Logged user: admin - admini";
String actual = cytc_064POM.user();
Assert.assertEquals(actual, expected);
System.out.println(actual);
System.out.println("Admin Page is displayed");

cytc_064POM.sendMemberLogin("reguser1");
//cytc_063POM.sendMemberFullName("Chaitra");
screenShot.captureScreenShot("Test64_20");
String expected1="Profile of reguser1";
String actual1= cytc_064POM.memberProfile();
Assert.assertEquals(actual1, expected1);
System.out.println("Registered member details are displayed");
screenShot.captureScreenShot("Test64_21");

// change group for member reguser1
cytc_064POM.clickSubmitBtn4();
screenShot.captureScreenShot("Test64_23");

String expected2="Change group for member reguser1";
String actual2= cytc_064POM.changeGroupPage();
Assert.assertEquals(actual2, expected2);

System.out.println("Change group for memeber page is displayed");


cytc_064POM.sendNewGroupListBox("Full members");
cytc_064POM.sendComments("Full access to the member");
screenShot.captureScreenShot("Test64_24");
cytc_064POM.clickSubmitBtn5();

String expected3="The member's group was changed";
String actual3= driver.switchTo().alert().getText().trim();
driver.switchTo().alert().accept();
System.out.println(actual3);
assertEquals(expected3,actual3);

System.out.println("Changed group for member is displayed");		

screenShot.captureScreenShot("Test64_25");

//Clicking on logout btn
		cytc_064POM.clickLogoutBtn();
		String logoutmsg = driver.switchTo().alert().getText();
		Assert.assertEquals("Please confirm to logout", logoutmsg);
		driver.switchTo().alert().accept();
		screenShot.captureScreenShot("Test064_26");
		
		cytc_064POM.sendLoginName1("reguser1"); 
		cytc_064POM.sendPassword1("reguser1");
		screenShot.captureScreenShot("Test64_27");
		cytc_064POM.clickSubmitBtn3();
		screenShot.captureScreenShot("Test2_2");
		String expected8 = "Logged user: reguser1 - reguser1";
		String actual8 = cytc_064POM.sendUser2();
		Assert.assertEquals(actual8, expected8);
		System.out.println(actual8);
		System.out.println("member page is displayed Page is displayed");

	}
}
