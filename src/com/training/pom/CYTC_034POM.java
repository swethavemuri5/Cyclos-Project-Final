package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CYTC_034POM {
	private WebDriver driver; 
	
	public CYTC_034POM(WebDriver driver) {
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
	
	@FindBy(xpath ="//span[@class='menuText'][contains(text(),'Account')]")
	private WebElement accountTab;
	
	@FindBy(xpath ="//span[contains(text(),'Loans')]")
	private WebElement loansLink;
	
	@FindBy(xpath ="//td[contains(text(),'My loans')]")
	private WebElement myLoans;
	
	@FindBy(xpath ="//body[@class='main']//tr//tr[2]//td[4]//img[1]")
	private WebElement viewIcon;
	
	@FindBy(xpath ="//td[contains(text(),'Loan details')]")
	private WebElement viewLoanDetails;
	
	@FindBy(id = "amountText")
	private WebElement amountText;
	
	@FindBy(xpath ="//input[@value='Repay']")
	private WebElement loanRepayBtn;
	
	@FindBy(xpath ="//td[@class='tdHeaderTable']")
	private WebElement repayLoanDetails;
	
	@FindBy(xpath="//span[contains(text(),'Logout')]")
	private WebElement logoutBtn;
	
	@FindBy(xpath="//span[contains(text(),'Logged user: admin - admini')]")
	private WebElement User2;
	
	@FindBy(id="memberUsername")
	private WebElement memberLogin;
	
	@FindBy(id="memberName")
	private WebElement memberFullName;
	
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[3]/form[1]/table[1]/tbody[1]/tr[1]/td[1]")
	private WebElement memberProfile;
	
	@FindBy(xpath="//tr[8]//td[1]//fieldset[1]//table[1]//tbody[1]//tr[1]//td[2]//input[1]")
	private WebElement viewLoanBtn;
	
	@FindBy(xpath="//td[contains(text(),'Loans of Chaitra')]")
	private WebElement loanDetailsPendingAmt;
	
	
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
	
	public String user() {
	    return user.getText();
	}
	
	public void clickAccountTabLink() {
		this.accountTab.click();
	}
	
	public void clickLoansLink() {
		this.loansLink.click();
	}
	
	public String myLoans() {
		return myLoans.getText();
		
	}
	
	public void clickViewIcon() {
		this.viewIcon.click();
	}
	
	public String viewLoanDetails() {
		return viewLoanDetails.getText();
		
	}
	
	public void sendAmountText(String amountText) {
		this.amountText.clear(); 
		this.amountText.sendKeys(amountText); 
	}
	
	public void clickLoanRepayBtn() {
		this.loanRepayBtn.click();
	}
	
	public String repayLoanDetailsPage() {
		return repayLoanDetails.getText();
		
	}
	
	public void clickLogoutBtn() {
		this.logoutBtn.click();
	}
	
	public String sendUser2() {
		return User2.getText();
		
	}
	
	public void sendMemberLogin(String memberLogin) {
		this.memberLogin.clear(); 
		this.memberLogin.sendKeys(memberLogin); 
	}
	
	
	
	public void sendMemberFullName(String memberFullName) {
		this.memberFullName.clear(); 
		this.memberFullName.sendKeys(memberFullName); 
	}
	
	public String memberProfile() {
		return this.memberProfile.getText();
	}

	public void clickViewLoanBtn() {
		this.viewLoanBtn.click();
	}
	
	public String loanDetailsPendingAmtPage() {
		return loanDetailsPendingAmt.getText();
		
	}

		
	}
	

	

	
	
	
	
	
	

