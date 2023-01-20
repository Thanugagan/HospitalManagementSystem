package com.hms.ObjectRepository;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contactuspage {
	//declaration
	@FindBy(name = "fullname")
	private WebElement name;
	
	@FindBy(name = "emailid")
	private WebElement email;
	
	@FindBy(name = "mobileno")
	private WebElement mblno;
	
	@FindBy(name = "description")
	private WebElement description;
	
	@FindBy(name = "submit")
	private WebElement submit;
	
	
	//Intialisation
	
	
	
	public Contactuspage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public WebElement getName() {
		return name;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getMblno() {
		return mblno;
	}

	public WebElement getDescription() {
		return description;
	}
	public WebElement getSubmit() {
		return submit;
	}
	//Business libraries
		
		public void contactquery(String name1,String email1,String mobile,String desc) {
			name.sendKeys(name1);
			email.sendKeys(email1);
			mblno.sendKeys(mobile);
			description.sendKeys(desc);
			submit.click();	
		}
	
	
		}	
	

