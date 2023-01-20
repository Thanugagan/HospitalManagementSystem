package com.hms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorLoginPage {
	@FindBy(name = "username")
	private WebElement namElement;
	
	@FindBy(name="password")
	private WebElement pasElement;
	
	@FindBy(name = "submit")
	private WebElement submit;
	
	public DoctorLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getNamElement() {
		return namElement;
	}

	public WebElement getPasElement() {
		return pasElement;
	}

	public WebElement getSubmit() {
		return submit;
	}

	public void doctorlogin(String name,String pas) {
		namElement.sendKeys(name);
		pasElement.sendKeys(pas);
		submit.click();
		
	}
}
