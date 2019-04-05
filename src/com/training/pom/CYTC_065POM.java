package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CYTC_065POM {
	private WebDriver driver; 
	
	public CYTC_065POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
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
	
	
}













