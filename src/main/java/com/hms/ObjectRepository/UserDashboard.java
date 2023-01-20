package com.hms.ObjectRepository;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserDashboard { 
	@FindBy(xpath = "//a[normalize-space()='Update Profile']")
	private WebElement profile;
	
	@FindBy(xpath = "//a[normalize-space()='Appointment History']")
	private WebElement apntmnthistory;
	
	@FindBy(xpath = "//a[contains(text(),'Book Appointment')]")
	private WebElement bookaptmnt;
	
	public UserDashboard(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getProfile() {
		return profile;
	}

	public WebElement getApntmnthistory() {
		return apntmnthistory;
	}

	public WebElement getBookaptmnt() {
		return bookaptmnt;
	}
	
	public void profile() {
		profile.click();
	}
	public void apntmnthstry() {
		apntmnthistory.click();}
	
	public void bookapntmnt() {
		bookaptmnt.click();	
	}

}
