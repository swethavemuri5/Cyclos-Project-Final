package com.training.sanity.tests;

import static org.testng.AssertJUnit.assertEquals;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import  java.util.concurrent.TimeUnit;

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
import com.training.pom.CYTC_063POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class CYTC_063 {

	private WebDriver driver;
	private String baseUrl;
	private CYTC_063POM cytc_063POM;
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
		cytc_063POM = new CYTC_063POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		cytc_063POM.clickRegisterBtn();
		screenShot.captureScreenShot("Test063_RegisterButton");
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
	@Test(dataProvider="db-inputs",dataProviderClass = LoginDataProviders.class)
	public void ValidRegistrationTest(String loginName,String fullName,String email,String birthday,String gender,String address,String postalCode,String city,String area,String phone,String mobPhone,String fax,String url,String password,String confirmPassword) throws InterruptedException {
		{
			
			cytc_063POM.sendLoginName(loginName);
			screenShot.captureScreenShot("Test63_1");
			
			cytc_063POM.sendFullName(fullName);
			cytc_063POM.sendEmail(email);
		    cytc_063POM.sendBirthday(birthday);
			cytc_063POM.sendGender(gender);
			screenShot.captureScreenShot("Test63_5");
			cytc_063POM.sendAddress(address);
			screenShot.captureScreenShot("Test63_6");
			cytc_063POM.sendPostalCode(postalCode);
			cytc_063POM.sendCity(city);
			cytc_063POM.sendArea(area);
			screenShot.captureScreenShot("Test63_9");
			cytc_063POM.sendPhone(phone);
			cytc_063POM.sendMobilePhone(mobPhone);
			cytc_063POM.sendFax(fax);
			cytc_063POM.sendUrl(url);
			cytc_063POM.sendPassword(password);
			cytc_063POM.sendConfirmPassword(confirmPassword);
			screenShot.captureScreenShot("test63_3");
			cytc_063POM.sendCaptcha("admin");
			cytc_063POM.clickSubmitBtn();
				
			 String expectedResult;
			 String actualResult;
			 expectedResult = "You have not typed the image characters correctly" ;
	         actualResult= driver.switchTo().alert().getText().trim();
	         driver.switchTo().alert().accept();
	        //System.out.println(actualResult);
	         assertEquals(expectedResult,actualResult);
	         System.out.println("new member is registered by taking values from db");
		}
	}
		}
	    