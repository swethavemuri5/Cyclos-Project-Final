package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CYTC_064POM {
	private WebDriver driver; 
	
	public CYTC_064POM(WebDriver driver) {
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
	
	@FindBy(id="cyclosUsername")
	private WebElement loginName1; 
	
	@FindBy(id="cyclosPassword")
	private WebElement password1; 
	
	@FindBy(xpath="//td[@colspan='2']//input[@value='Submit']")
	private WebElement submitBtn3;
	
	@FindBy(xpath="//span[contains(text(),'Logged user: admin - admini')]")
	private WebElement User;
	
	@FindBy(xpath="//span[contains(text(),'Logged user: reguser1 - reguser1')]")
	private WebElement User2;
	
	@FindBy(id="memberUsername")
	private WebElement memberLogin;
	
	@FindBy(id="memberName")
	private WebElement memberFullName;
	
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[3]/form[1]/table[1]/tbody[1]/tr[1]/td[1]")
	private WebElement memberProfile;
	
	@FindBy(xpath="//body[@class='main']//tr//tr[2]//td[1]//fieldset[1]//table[1]//tbody[1]//tr[1]//td[4]//input[1]")
	private WebElement submitBtn4;
	
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[3]/form[1]/table[1]/tbody[1]/tr[1]/td[1]")
	private WebElement changeGroupPage;
	
	@FindBy(xpath="//select[@name='newGroupId']")
	private WebElement newGroupListBox;
	
	@FindBy(id="comments")
	private WebElement comments;
	
	@FindBy(xpath="//td[@colspan='2']//input[@value='Submit']")
	private WebElement submitBtn5;
		
	@FindBy(xpath="//span[contains(text(),'Logout')]")
	private WebElement logoutBtn;
	
	
	
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
	
	public void sendLoginName1(String loginName1) {
		this.loginName1.clear();
		this.loginName1.sendKeys(loginName1);
	}
	
	public void sendPassword1(String password) {
		this.password1.clear(); 
		this.password1.sendKeys(password); 
	}
	
	public void clickSubmitBtn3() {
		this.submitBtn3.click();
	}
	
	public String user() {
	    return User.getText();
	}
	
	public void sendMemberLogin(String memberLogin) {
		this.memberLogin.clear(); 
		this.memberLogin.sendKeys(memberLogin); 
	}
	
	
	/*public void sendMemberLogin(String memberLogin) {
		Select memberLogin_dropdown = new Select(driver.findElement(By.id("memberUsername")));
		memberLogin_dropdown.selectByVisibleText(memberLogin);
		 
	}
	*/
	public void sendMemberFullName(String memberFullName) {
		this.memberFullName.clear(); 
		this.memberFullName.sendKeys(memberFullName); 
	}
	
	public String memberProfile() {
		return this.memberProfile.getText();
	}
	
	public void clickSubmitBtn4() {
		this.submitBtn4.click();
	}
	
	public String changeGroupPage() {
		return this.changeGroupPage.getText();
	}
	//vamsi change -> find the ele correctly
	public void sendNewGroupListBox(String newGroup) {
		Select newgroup_dropdown = new Select(driver.findElement(By.xpath("//select[@name='newGroupId']")));
		newgroup_dropdown.selectByVisibleText(newGroup);
		 
	}
	
	public void sendComments(String comments) {
		this.comments.clear();
		this.comments.sendKeys(comments);
	}
	
	public void clickSubmitBtn5() {
		this.submitBtn5.click();
		
		
	}
	
	
	public void clickLogoutBtn() {
		this.logoutBtn.click();
	}
	
	public String sendUser2() {
		return User2.getText();
	}
	}
