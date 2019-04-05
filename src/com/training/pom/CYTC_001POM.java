package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CYTC_001POM {
	private WebDriver driver; 
	
	public CYTC_001POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@id='loginRegistrationDiv']//input[@value='Submit']")
	private WebElement registerBtn; 
	
	@FindBy(xpath="//input[@name='member(user).username']")
	private WebElement loginName; 
	
	@FindBy(xpath ="//input[@name='member(name)']")
	private WebElement fullName;
	
	@FindBy(xpath ="//input[@name='member(email)']")
	private WebElement email; 
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[4]/td[2]/input[3]")
	private WebElement birthday;
	
	@FindBy(id="_radio_2_0")
	private WebElement gender;
	
	@FindBy(id="_radio_2_1")
	private WebElement gender1;
	
	@FindBy(xpath ="//tr[6]//td[2]//input[3]")
	private WebElement address;
	
	@FindBy(xpath="//tr[7]//td[2]//input[3]")
	private WebElement postalCode;
	
	@FindBy(xpath="//tr[8]//td[2]//input[3]")
	private WebElement city;
	
	@FindBy(id="custom_field_select_6")
	private WebElement area;
	
	@FindBy(xpath="//tr[10]//td[2]//input[3]")
	private WebElement phone;
	
	@FindBy(xpath="//tr[11]//td[2]//input[3]")
	private WebElement mobPhone;
	
	@FindBy(xpath="//tr[12]//td[2]//input[3]")
	private WebElement fax;
	
	@FindBy(xpath="//tr[13]//td[2]//input[3]")
	private WebElement url;
	
	@FindBy(xpath="//input[@name='member(user).password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@name='confirmPassword']")
	private WebElement confirmPassword;
	
	@FindBy(xpath="//input[@name='captcha']")
	private WebElement captcha;
	
	@FindBy(id="saveButton")
	private WebElement submitBtn;
	
	
	public void clickRegisterBtn() {
		this.registerBtn.click();
	}
		
		
	public void sendLoginName(String loginName) {
		this.loginName.clear();
		this.loginName.sendKeys(loginName);
	}
	
	public void sendFullName(String fullName) {
		this.fullName.clear(); 
		this.fullName.sendKeys(fullName); 
	}
	
	public void sendEmail(String email) {
		this.email.clear(); 
		this.email.sendKeys(email); 
	}
	
	public void sendBirthday(String birthday) {
		//WebElement datebox = driver.findElement(By.id("_id1551978560928_966"));
		//datebox.sendKeys(birthday);
	this.birthday.clear(); 
		this.birthday.sendKeys(birthday); 
	}
	
	public void sendGender(String gender) {
		if (gender == "Female") {
				WebElement radio1=driver.findElement(By.id("_radio_2_0"));
				radio1.click();
				this.gender.sendKeys(gender);
		}
		else {
			WebElement radio2=driver.findElement(By.id("_radio_2_1"));
			radio2.click(); 
			this.gender1.sendKeys(gender);
		}
		 
	}
	
	public void sendAddress(String address) {
		this.address.clear(); 
		this.address.sendKeys(address); 
	}
	
	public void sendPostalCode(String postalCode) {
		this.postalCode.clear(); 
		this.postalCode.sendKeys(postalCode); 
	}
	
	public void sendCity(String city) {
		this.city.clear(); 
		this.city.sendKeys(city); 
	}
	
	public void sendArea(String area) {
		Select area_dropdown = new Select(driver.findElement(By.id("custom_field_select_6")));
		area_dropdown.selectByVisibleText(area);
		//this.area.clear(); 
		//this.area.sendKeys(area); 
	}
	
	public  void sendPhone(String phone) {
		this.phone.clear(); 
		this.phone.sendKeys(phone); 
	}
	
	public void sendMobilePhone(String mobPhone) {
		this.mobPhone.clear(); 
		this.mobPhone.sendKeys(mobPhone); 
	}
	
	public void sendFax(String fax) {
		this.fax.clear(); 
		this.fax.sendKeys(fax); 
	}
	
	public void sendUrl(String url) {
		this.url.clear(); 
		this.url.sendKeys(url); 
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void sendConfirmPassword(String confirmPassword) {
		this.confirmPassword.clear(); 
		this.confirmPassword.sendKeys(confirmPassword); 
	}
	
	public void sendCaptcha(String captcha) {
		this.captcha.clear(); 
		this.captcha.sendKeys(captcha); 
	}
	
	public void clickSubmitBtn() {
		//this.submitBtn.clear(); 
		this.submitBtn.click(); 
	}
	
	}
