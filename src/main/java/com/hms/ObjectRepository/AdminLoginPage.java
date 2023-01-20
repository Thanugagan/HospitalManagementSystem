package com.hms.ObjectRepository;

import java.util.jar.Attributes.Name;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {
	@FindBy(name="username")
	private WebElement namElement;
	
	@FindBy(name = "password")
	private WebElement passElement;
	
	@FindBy(name = "submit")
	private WebElement submit;
	
	public  AdminLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getNamElement() {
		return namElement;
	}

	public WebElement getPassElement() {
		return passElement;
	}

	public WebElement getSubmit() {
		return submit;
	}
	
	public void adminlogin(String name,String Pass) {
		namElement.sendKeys(name);
		passElement.sendKeys(Pass);
		submit.click();
		
	}

}
