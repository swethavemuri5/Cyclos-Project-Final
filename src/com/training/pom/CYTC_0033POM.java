package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CYTC_0033POM {
	private WebDriver driver; 
	
	public CYTC_0033POM(WebDriver driver) {
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
	
	@FindBy(xpath="//tr[8]//td[1]//fieldset[1]//table[1]//tbody[1]//tr[1]//td[4]//input[1]")
	private WebElement grantLoanBtn;
	
	@FindBy(xpath="//td[@class='tdHeaderTable']")
	private WebElement grantLoanPage;
	
	@FindBy(id="amount")
	private WebElement amountBox;
	
	@FindBy(id="description")
	private WebElement descriptionGrantLoan;
	
	@FindBy(xpath="//input[@value='Submit']")
	private WebElement grantLoanSubmitBtn;
	
	@FindBy(xpath="//td[@class='tdHeaderTable']")
	private WebElement loanConfirmPage;
	
	@FindBy(xpath="//input[@value='Submit']")
	private WebElement confirmGrantLoanSubmitBtn;
	
	@FindBy(xpath="//tr[8]//td[1]//fieldset[1]//table[1]//tbody[1]//tr[1]//td[2]//input[1]")
	private WebElement viewLoanBtn;
	
	@FindBy(xpath="//td[contains(text(),'Loans of Chaitra')]")
	private WebElement memLoanPage;
	
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
	
	public void grantLoanBtn() {
		this.grantLoanBtn.click();
	}
	
	public String grantLoanPage() {
	     return this.grantLoanPage.getText();
	}
	
	public void amountBox(String amountBox) {
		this.amountBox.sendKeys(amountBox);
	}
	
	public void descriptionGrantloan(String descriptionGrantloan) {
		this.descriptionGrantLoan.sendKeys(descriptionGrantloan);
	}
	
	public void grantLoanSubmitBtn() {
		this.grantLoanSubmitBtn.click();
	}
	
	public String loanConfrimPage() {
		return this.loanConfirmPage.getText();
	}
	
	public void confrimGrantLoanSubmitBtn() {
		this.confirmGrantLoanSubmitBtn.click();
	}
	
	public void viewLoanBtn() {
		this.viewLoanBtn.click();
	}
	
	public String memLoanPage() {
		return this.memLoanPage.getText();
	}
}