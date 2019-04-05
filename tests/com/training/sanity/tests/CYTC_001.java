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
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.CYTC_001POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class CYTC_001 {

	private WebDriver driver;
	private String baseUrl;
	private CYTC_001POM cytc_001POM;
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
		cytc_001POM = new CYTC_001POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		cytc_001POM.clickRegisterBtn();
		screenShot.captureScreenShot("Test1_RegisterButton");
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
	@Test
	public void validLoginTest() {
		
		//Enter valid details to register new user.
		cytc_001POM.sendLoginName("Chaitu1");
		screenShot.captureScreenShot("Test1_1");
		
		cytc_001POM.sendFullName("Chaitra1");
		screenShot.captureScreenShot("Test1_2");
		cytc_001POM.sendEmail("swethaofcl@gmail.com");
		screenShot.captureScreenShot("Test1_3");
		cytc_001POM.sendBirthday("05/01/1993");
		screenShot.captureScreenShot("Test1_4");
		
		cytc_001POM.sendGender("Female");
		screenShot.captureScreenShot("Test1_5");
		cytc_001POM.sendAddress("KrishnaApts");
		screenShot.captureScreenShot("Test1_6");
		cytc_001POM.sendPostalCode("500090");
		screenShot.captureScreenShot("Test1_7");
		cytc_001POM.sendCity("Hyderabad");
		screenShot.captureScreenShot("Test1_8");
		cytc_001POM.sendArea("Example area");
		screenShot.captureScreenShot("Test1_9");
		cytc_001POM.sendPhone("2345678901");
		screenShot.captureScreenShot("Test1_10");
		cytc_001POM.sendMobilePhone("2345678901");
		screenShot.captureScreenShot("Test1_11");
		cytc_001POM.sendFax("2345678901");
		screenShot.captureScreenShot("Test1_12");
		cytc_001POM.sendUrl("www.google.com");
		screenShot.captureScreenShot("Test1_13");
		//screenShot.captureScreenShot("Test1_third");
		screenShot.captureScreenShot("Test1_14");
		cytc_001POM.sendPassword("Chaitu@123");
		screenShot.captureScreenShot("Test1_15");
		cytc_001POM.sendConfirmPassword("Chaitu@123");
		screenShot.captureScreenShot("Test1_16");
		cytc_001POM.sendCaptcha("admin");
		screenShot.captureScreenShot("Test1_17");
		cytc_001POM.clickSubmitBtn();
			
		//Assertion 
		String expectedResult;
	    String actualResult;
		expectedResult = "You have not typed the image characters correctly" ;
        actualResult= driver.switchTo().alert().getText().trim();
        driver.switchTo().alert().accept();
        System.out.println(actualResult);
        System.out.println("Member details are registered");
        assertEquals(expectedResult,actualResult);
		
		
	}
}
