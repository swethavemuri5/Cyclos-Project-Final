package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CYTC_035POM {
	private WebDriver driver; 
	
	public CYTC_035POM(WebDriver driver) {
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
	
	@FindBy(xpath ="//span[contains(text(),'System Payment')]")
	private WebElement systemPaymentLink;
	
	@FindBy(xpath ="//td[@class='tdHeaderTable']")
	private WebElement paymentSystemPage;
	
	@FindBy(id ="amount")
	private WebElement amountTextBox;

	@FindBy(id ="type")
	private WebElement transactionTypeListBox;
	
	@FindBy(id ="description")
	private WebElement paymentDescription;
	
	@FindBy(id ="submitButton")
	private WebElement paymentSubmitBtn;
	
	@FindBy(xpath ="//td[@class='label']")
	private WebElement transactionConfirmPageLabel;
	
	@FindBy(xpath ="//input[@value='Submit']")
	private WebElement confirmTransactionSubmit;
	
	@FindBy(xpath ="//td[@align='center']")
	private WebElement successfulPaymentPage;
	
	@FindBy(xpath ="//span[contains(text(),'Account Information')]")
	private WebElement accountInfoLink;
	
	@FindBy(xpath ="//td[contains(text(),'Search transactions on Member account')]")
	private WebElement transactionDetailsPage;
	
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
	
	
	public void clickaccountTab() {
		this.accountTab.click();
	}
	
	public void clickSystemPaymentLink() {
		this.systemPaymentLink.click();
	}
	
	public String paymentSystempage() {
		return paymentSystemPage.getText();
	}
	
	public void amountTextBox(String amountTextbox) {
	this.amountTextBox.clear();
	this.amountTextBox.sendKeys(amountTextbox);
	}
	
	public void transactionTypeListBox(String transactionTypeListBox) {
		Select transactionTypeListBox_dropdown = new Select(driver.findElement(By.id("type")));
		transactionTypeListBox_dropdown.selectByVisibleText(transactionTypeListBox);
		 
	}
	
	public void paymentDescriptions(String paymentDescription) {
		this.paymentDescription.clear();
		this.paymentDescription.sendKeys(paymentDescription);
	}
	
	public void clickPaymentSubmitBtn() {
		this.paymentSubmitBtn.click();
	}

	public String transactionConfrimPagelabel() {
		return transactionConfirmPageLabel.getText();
	}
	
	public void clickconfirmTransactionsubmitBtn() {
		this.confirmTransactionSubmit.click();
	}
	
	public String successfulPaymentPage() {
		return successfulPaymentPage.getText();
	}
	
	public void clickAccountInfolink() {
		this.accountInfoLink.click();
	}
	
	public String viewTranscationDetailsPage() {
		return transactionDetailsPage.getText();
	}

}