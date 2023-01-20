package com.hms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	//declaration
	@FindBy(xpath  = "//a[.='Home']")
	private WebElement homepage;

	@FindBy(xpath  = "//div[@class='top-nav']//ul//li//a[@href='contact.php'][normalize-space()='contact']")
	private WebElement contactus;

	@FindBy(xpath = "//a[@href='hms/user-login.php']")
	private WebElement userlogin;

	@FindBy(xpath = "//a[@href='hms/doctor/']")
	private WebElement doctorlogin;

	@FindBy(xpath = "//a[@href='hms/admin']")
	private WebElement adminpage;

	//Initialization

	public  HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public WebElement getHomepage() {
		return homepage;
	}

	public WebElement getContactus() {
		return contactus;
	}

	public WebElement getUserlogin() {
		return userlogin;
	}

	public WebElement getDoctorlogin() {
		return doctorlogin;
	}

	public WebElement getAdminpage() {
		return adminpage;
	}
	//Create business library

	public void HomePage() {
		homepage.click();
		}
	public void contactpage(){

		contactus.click();}

	public void userpage()
	{
		userlogin.click();
	}
	public void doctorpage()
	{
		doctorlogin.click();
	}
	public void adminpage()
	{ 
		adminpage.click();}
}

