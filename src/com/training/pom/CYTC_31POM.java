package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CYTC_31POM {
	private WebDriver driver; 
	
	public CYTC_31POM(WebDriver driver) {
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
	
	@FindBy(xpath="//tr[4]//td[1]//fieldset[1]//table[1]//tbody[1]//tr[1]//td[2]//input[1]")
	private WebElement advSubmitBtn1;
	
	@FindBy(xpath="//td[@class='tdHeaderTable']")
	private WebElement advOfMember;
	
	
	
	@FindBy(id="newButton")
	private WebElement insertAdvBtn;
	
	@FindBy(xpath="//td[@class='tdHeaderTable']")
	private WebElement newAdvertise;
	
	@FindBy(xpath="//input[@name='ad(title)']")
	private WebElement advTitle;
	
	@FindBy(xpath="//select[@name='ad(category)']")
	private WebElement advCategory;
	
	@FindBy(xpath="//input[@name='ad(price)']")
	private WebElement advPrice;
	
	@FindBy(id="publicationDate")
	private WebElement publicationDate;
	
	@FindBy(id="notExpirableCheck")
	private WebElement notExpire;
	
	@FindBy(id="expiryDate")
	private WebElement expiryDate;
	

	@FindBy(xpath="//iframe[@title='Rich text editor, descriptionText']")
	private WebElement description;
	
	@FindBy(id="saveButton")
	private WebElement SubmitAdv;
	
	@FindBy(xpath="//td[@class='tdHeaderTable']")
	private WebElement modifyAdv;
	
	
	@FindBy(xpath="//span[contains(text(),'Logout')]")
	private WebElement logoutBtn;
	
	@FindBy(xpath ="//span[contains(text(),'Logged user: Chaitu - Chaitra')]")
	private WebElement user1;
	
	@FindBy(xpath ="//span[contains(text(),'Personal')]")
	private WebElement personalTab;
	
	@FindBy(xpath ="//span[contains(text(),'Advertisements')]")
	private WebElement advertisementLink;
	
	@FindBy(xpath ="/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]")
	private WebElement myAdv;
	
	
		
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
	
	public void clickAdvertisementBtn() {
		this.advSubmitBtn1.click();
	}
	
	public String memAdvertise() {
		return this.advOfMember.getText();
	}
	
	public void clickInsertAdvBtn() {
		this.insertAdvBtn.click();
	}
	
	public String memAdv() {
		return this.newAdvertise.getText();
	} 
	
	public void sendTitle(String advTitle) {
		this.advTitle.clear();
		this.advTitle.sendKeys(advTitle);
	}
	
	
	public void sendAdvCategoryListBox(String advCategory) {
		Select advCategory_dropdown = new Select(driver.findElement(By.xpath("//select[@name='ad(category)']")));
		advCategory_dropdown.selectByVisibleText(advCategory);
		 
	}
	
	public void sendPrice(String advPrice) {
		this.advPrice.clear();
		this.advPrice.sendKeys(advPrice);
	}
	
	//checokbox method
	public void notExpirable() {
		//this.notExpire.clear();
		WebElement option1 = driver.findElement(By.id("notExpirableCheck"));
		option1.click();
		
	}
	
	public void description(String description) {
		driver.switchTo().frame(0);
		WebElement editable = driver.switchTo().activeElement();
		editable.sendKeys(description);
		driver.switchTo().defaultContent();
	}
	
	
	public void clickSubmitAdvBtn2() {
		this.SubmitAdv.click();
		
		//Alert alert =driver.switchTo().alert();
		//alert.accept();
	}
	
	public String modifyAdv() {
		return this.modifyAdv.getText();
	}
	
	public void clickLogoutBtn() {
		this.logoutBtn.click();
	}
	
	public String user1() {
	    return user1.getText();
	}
	
	public void clickpersonalTabLink() {
		this.personalTab.click();
	}
	
	public void clickadvertisementLink() {
		this.advertisementLink.click();
	}
	
	public String myAdv()
	{
		return this.myAdv.getText();
	}
	}
