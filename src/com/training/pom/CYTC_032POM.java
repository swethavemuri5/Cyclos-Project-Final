package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CYTC_032POM {
	private WebDriver driver; 
	
	public CYTC_032POM(WebDriver driver) {
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
	
	@FindBy(xpath="//tr[5]//td[1]//fieldset[1]//table[1]//tbody[1]//tr[2]//td[2]//input[1]")
	private WebElement paymentSystemToMemBtn;
	
	@FindBy(xpath="//td[@class='tdHeaderTable']")
	private WebElement paymentSystemToMempage;
	
	//@FindBy(xpath="//tr[5]//td[1]//fieldset[1]//table[1]//tbody[1]//tr[2]//td[2]//input[1]")
	//private WebElement paymentSystemToMemBtn;
	
	@FindBy(id="amount")
	private WebElement amountText;
	
	@FindBy(id="type")
	private WebElement transactionTypeListBox;
	
	@FindBy(id="description")
	private WebElement descriptionBox;
	
	@FindBy(id="submitButton")
	private WebElement payMemsubmitBtn;
	
	@FindBy(xpath="//td[@class='label']")
	private WebElement payMemConfirmPage;
	
	@FindBy(xpath="//input[@value='Submit']")
	private WebElement payMemConfirmBtn;
	
	@FindBy(xpath="//td[@align='center']")
	private WebElement paymentSuccessfulPage;
	
	@FindBy(xpath="//span[contains(text(),'Logout')]")
	private WebElement logoutBtn;
	
	@FindBy(xpath ="//span[contains(text(),'Logged user: Chaitu - Chaitra')]")
	private WebElement user1;
	
	@FindBy(xpath="//span[@class='menuText'][contains(text(),'Account')]")
	private WebElement accountTab;
	
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[3]/ul[1]/li[1]/span[2]")
	private WebElement accountInfoLink;
	
	@FindBy(xpath="//td[contains(text(),'Search transactions on Member account')]")
	private WebElement accountAddByAdminDisplay;

	
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
	
	public void clickPaymentSystemToMem() {
		this.paymentSystemToMemBtn.click();
	}
	
	public String paymentSystemToMempage() {
	    return paymentSystemToMempage.getText();
	}

	public  void sendamountText(String amountText) {
		this.amountText.clear(); 
		this.amountText.sendKeys(amountText); 
		}
	
	public void sendtranactionTypeListBox(String transactionTypeListBox) {
		Select transactList_drpdwn= new Select(driver.findElement(By.id("type")));
		transactList_drpdwn.selectByVisibleText(transactionTypeListBox);
	}
	
	public  void sendDescriptionBox(String descriptionBox) {
		this.descriptionBox.clear(); 
		this.descriptionBox.sendKeys(descriptionBox); 
		}
	
	public void clickPayMemSubmitBtn()
	{
		this.payMemsubmitBtn.click();
	}
	
	public String payMemConfirmPage() {
		return payMemConfirmPage.getText();
	}
	
	public void clickPayMemConfirmPage() {
		this.payMemConfirmBtn.click();
	}
	
	public String paymentSuccessfulPage() {
		return paymentSuccessfulPage.getText();
		
		}
	
	public void clickLogoutBtn() {
		this.logoutBtn.click();
	}
	
	public String user1() {
	    return user1.getText();
	}
	
	public void clickAccountTab() {
		this.accountTab.click();
	}
	
	public void clickAccountInfoLink() {
		this.accountInfoLink.click();
	}
	
	public String actAddByAdminPage() {
		return accountAddByAdminDisplay.getText();
	}
}