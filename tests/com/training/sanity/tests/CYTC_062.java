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
import com.training.pom.CYTC_062POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class CYTC_062 {

	private WebDriver driver;
	private String baseUrl;
	private CYTC_062POM cytc_062POM;
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
		cytc_062POM = new CYTC_062POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		
		//Click on register btn
		cytc_062POM.clickRegisterBtn();
		screenShot.captureScreenShot("Test062_RegisterButton");
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
	@Test(dataProvider="excel-inputs1",dataProviderClass = LoginDataProviders.class)
	public void validRegistrationTest(String loginName,String fullName,String email,String birthday,String gender,String address,String postalCode,String city,String area,String phone,String mobPhone,String fax,String url,String password,String confirmPassword) throws InterruptedException {
		
		cytc_062POM.sendLoginName(loginName);
		screenShot.captureScreenShot("Test62_1");
		
		cytc_062POM.sendFullName(fullName);
		screenShot.captureScreenShot("Test62_2");
		 
		cytc_062POM.sendEmail(email);
		screenShot.captureScreenShot("Test62_3");
		cytc_062POM.sendBirthday(birthday);
		screenShot.captureScreenShot("Test62_4");
		 
		
		cytc_062POM.sendGender(gender);
		screenShot.captureScreenShot("Test62_5");
		cytc_062POM.sendAddress(address);
		screenShot.captureScreenShot("Test62_6");
		cytc_062POM.sendPostalCode(postalCode);
		//screenShot.captureScreenShot("Test61_7");
		cytc_062POM.sendCity(city);
		//screenShot.captureScreenShot("Test61_8");
		cytc_062POM.sendArea(area);
		screenShot.captureScreenShot("Test62_9");
		cytc_062POM.sendPhone(phone);
		//screenShot.captureScreenShot("Test61_10");
		cytc_062POM.sendMobilePhone(mobPhone);
		//screenShot.captureScreenShot("Test61_11");
		cytc_062POM.sendFax(fax);
		screenShot.captureScreenShot("Test62_12");
		cytc_062POM.sendUrl(url);
		screenShot.captureScreenShot("Test62_13");
		//screenShot.captureScreenShot("Test1_third");
		screenShot.captureScreenShot("Test62_14");
		cytc_062POM.sendPassword(password);
		screenShot.captureScreenShot("Test62_15");
		cytc_062POM.sendConfirmPassword(confirmPassword);
		screenShot.captureScreenShot("Test62_16");
		cytc_062POM.sendCaptcha("admin");
		screenShot.captureScreenShot("Test62_17");
		cytc_062POM.clickSubmitBtn();
			
		 String expectedResult;
		 String actualResult;
		 expectedResult = "You have not typed the image characters correctly" ;
         actualResult= driver.switchTo().alert().getText().trim();
         driver.switchTo().alert().accept();
         //System.out.println(actualResult);
         assertEquals(expectedResult,actualResult);
		System.out.println("Multiple users are registered successfully by taking inputs from excel sheet");
		
	}
}
