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
import com.training.pom.CYTC_061POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class CYTC_061 {

	private WebDriver driver;
	private String baseUrl;
	private CYTC_061POM cytc_061POM;
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
		cytc_061POM = new CYTC_061POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		
		//Click onregsiter btn
		cytc_061POM.clickRegisterBtn();
		screenShot.captureScreenShot("Test061_RegisterButton");
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
	@Test(dataProvider="excel-inputs",dataProviderClass = LoginDataProviders.class)
	public void invalidRegistrationTest(String loginName,String fullName,String email,String birthday,String gender,String address,String postalCode,String city,String area,String phone,String mobPhone,String fax,String url,String password,String confirmPassword) throws InterruptedException {
		
		//enter invalid details
		cytc_061POM.sendLoginName(loginName);
		screenShot.captureScreenShot("Test61_1");
		
		cytc_061POM.sendFullName(fullName);
		screenShot.captureScreenShot("Test61_2");
		 
		cytc_061POM.sendEmail(email);
		screenShot.captureScreenShot("Test61_3");
		cytc_061POM.sendBirthday(birthday);
		screenShot.captureScreenShot("Test61_4");
		 
		
		cytc_061POM.sendGender(gender);
		screenShot.captureScreenShot("Test61_5");
		cytc_061POM.sendAddress(address);
		screenShot.captureScreenShot("Test61_6");
		cytc_061POM.sendPostalCode(postalCode);
		//screenShot.captureScreenShot("Test61_7");
		cytc_061POM.sendCity(city);
		//screenShot.captureScreenShot("Test61_8");
		cytc_061POM.sendArea(area);
		screenShot.captureScreenShot("Test61_9");
		cytc_061POM.sendPhone(phone);
		//screenShot.captureScreenShot("Test61_10");
		cytc_061POM.sendMobilePhone(mobPhone);
		//screenShot.captureScreenShot("Test61_11");
		cytc_061POM.sendFax(fax);
		screenShot.captureScreenShot("Test61_12");
		cytc_061POM.sendUrl(url);
		screenShot.captureScreenShot("Test61_13");
		//screenShot.captureScreenShot("Test1_third");
		screenShot.captureScreenShot("Test61_14");
		cytc_061POM.sendPassword(password);
		screenShot.captureScreenShot("Test61_15");
		cytc_061POM.sendConfirmPassword(confirmPassword);
		screenShot.captureScreenShot("Test61_16");
		cytc_061POM.sendCaptcha("admin");
		screenShot.captureScreenShot("Test61_17");
		cytc_061POM.clickSubmitBtn();
			
		 
		 String expectedResult;
		 String actualResult;
		 expectedResult = "Passwords are not Equal\nE-Mail is invalid\nMobile phone is not unique\nYou have not typed the image characters correctly" ;
         actualResult= driver.switchTo().alert().getText().trim();
         driver.switchTo().alert().accept();
          System.out.println(actualResult);
         assertEquals(expectedResult,actualResult);
		
		
	}
}
