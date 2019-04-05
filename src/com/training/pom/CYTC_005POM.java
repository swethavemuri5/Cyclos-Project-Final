package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CYTC_005POM {
	private WebDriver driver; 
	
	public CYTC_005POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "cyclosUsername")
	private WebElement loginName1; 
	
	@FindBy(id="cyclosPassword")
	private WebElement password1; 
	
	@FindBy(xpath ="//td[@colspan='2']//input[@value='Submit']")
	private WebElement submitBtn1;
	
	@FindBy(xpath ="//span[contains(text(),'Logged user: Chaitu - Chaitra')]")
	private WebElement user;
	
	@FindBy(xpath ="//td[@class='tdContentTableForms innerBorder']//td[1]//a[1]")
	private WebElement myProfileIcon;
	
	@FindBy(xpath ="//td[@class='tdHeaderTable']")
	private WebElement myProfile;
	
	
	@FindBy(id ="modifyButton")
	private WebElement modifyBtn1;
	
	@FindBy(xpath ="/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[3]/form[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[7]/td[2]/span[1]/input[2]")
	private WebElement address1;
	
	@FindBy(id ="saveButton")
	private WebElement submitBtn2;
	
	
	
	
	
	
	
		
	public void sendLoginName(String loginName) {
		this.loginName1.clear();
		this.loginName1.sendKeys(loginName);
	}
	
	public void sendPassword(String password) {
		this.password1.clear(); 
		this.password1.sendKeys(password); 
	}
	
	public void clickSubmitBtn() {
		this.submitBtn1.click();
	}
	
	public String user1() {
		return user.getText();
	}
	
	public void clickMYProfileIcon() {
		this.myProfileIcon.click();
	}
	
	public String myProfile() {
		return myProfile.getText();
	}
	public void clickChangeBtn1() {
		this.modifyBtn1.click();
	}
	
	public void sendAddressChange(String address1) {
		this.address1.clear();
		this.address1.sendKeys(address1);
	}
	
	public void clickSubmitBtn2() {
		this.submitBtn2.click();
		
		
		//Alert alert =driver.switchTo().alert();
		//alert.accept();
	}
	}
