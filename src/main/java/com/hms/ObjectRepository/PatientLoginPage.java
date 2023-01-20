package com.hms.ObjectRepository;

import java.util.jar.Attributes.Name;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientLoginPage {
	//declaration
	

	@FindBy(name="username")
	private WebElement username;

	@FindBy(name = "password")
	private WebElement pswrd;

	@FindBy(name = "submit")
	private WebElement submit;

	//Initalization

	public PatientLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	//Utilization

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPswrd() {
		return pswrd;
	}

	public WebElement getSubmit() {
		return submit;
	}

	//create buisness library
	public void userlogin(String Name,String pass) {
		username.sendKeys(Name);
		pswrd.sendKeys(pass);
		submit.click();

	}
















}
