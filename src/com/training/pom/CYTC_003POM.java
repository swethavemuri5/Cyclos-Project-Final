package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CYTC_003POM {
	private WebDriver driver; 
	
	public CYTC_003POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "cyclosUsername")
	private WebElement loginName1; 
	
	@FindBy(id="cyclosPassword")
	private WebElement password1; 
	
	@FindBy(xpath ="//td[@colspan='2']//input[@value='Submit']")
	private WebElement submitBtn;
	
	@FindBy(xpath="//span[contains(text(),'Logged user: admin - admini')]")
	private WebElement User;
	
	@FindBy(id="memberUsername")
	private WebElement memberLogin;
	
	@FindBy(id="memberName")
	private WebElement memberFullName;
	
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[3]/form[1]/table[1]/tbody[1]/tr[1]/td[1]")
	private WebElement memberProfile;
	
	@FindBy(xpath="//body[@class='main']//tr//tr[2]//td[1]//fieldset[1]//table[1]//tbody[1]//tr[1]//td[4]//input[1]")
	private WebElement submitBtn1;
	
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[3]/form[1]/table[1]/tbody[1]/tr[1]/td[1]")
	private WebElement changeGroupPage;
	
	@FindBy(xpath="//select[@name='newGroupId']")
	private WebElement newGroupListBox;
	
	@FindBy(id="comments")
	private WebElement comments;
	
	@FindBy(xpath="//td[@colspan='2']//input[@value='Submit']")
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
		this.submitBtn.click();
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
	
	public void clickSubmitBtn1() {
		this.submitBtn1.click();
	}
	
	public String changeGroupPage() {
		return this.changeGroupPage.getText();
	}
	public void sendNewGroupListBox(String newGroup) {
		Select newgroup_dropdown = new Select(driver.findElement(By.xpath("//select[@name='newGroupId']")));
		newgroup_dropdown.selectByVisibleText(newGroup);
		 
	}
	
	public void sendComments(String comments) {
		this.comments.clear();
		this.comments.sendKeys(comments);
	}
	
	public void clickSubmitBtn2() {
		this.submitBtn2.click();
		
		//Alert alert =driver.switchTo().alert();
		//alert.accept();
	}
	
	
	
	}
