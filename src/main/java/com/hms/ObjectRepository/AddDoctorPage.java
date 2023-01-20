package com.hms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddDoctorPage {
	@FindBy(name = "Doctorspecialization")
	private WebElement dctrspl;
	
	@FindBy(name = "docname")
	private WebElement name;
	
	@FindBy(name = "clinicaddress")
	private WebElement addrs;
	
	@FindBy(name = "docfees")
	private WebElement docfees;
	
	@FindBy(name = "doccontact")
	private WebElement doccontact;
	
	@FindBy(name = "docemail")
	private WebElement docemail;
	
	@FindBy(name="npass")
	private WebElement pass;
	
	@FindBy(name="cfpass")
	private WebElement cfpass;
	
	@FindBy(name = "submit")
	private WebElement submit;
	
	@FindBy(xpath = "//td[contains(text(),'Thanuja')]")
	private WebElement dctnme;
	
	public  AddDoctorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getDctrspl() {
		return dctrspl;
	}

	public WebElement getName() {
		return name;
	}

	public WebElement getAddrs() {
		return addrs;
	}

	public WebElement getDocfees() {
		return docfees;
	}

	public WebElement getDoccontact() {
		return doccontact;
	}

	public WebElement getDocemail() {
		return docemail;
	}

	public WebElement getPass() {
		return pass;
	}

	public WebElement getCfpass() {
		return cfpass;
	}

	public WebElement getSubmit() {
		return submit;
	}
	
	public WebElement getDctnme() {
		return dctnme;
	}

	public void adddoctor(String spcl,String name1,String address,String fees,String contact,String email,String paswrd,String again) {
		dctrspl.sendKeys(spcl);
		name.sendKeys(name1);
		addrs.sendKeys(address);
		docfees.sendKeys(fees);
		doccontact.sendKeys(contact);
		docemail.sendKeys(email);
		pass.sendKeys(paswrd);
		cfpass.sendKeys(again);
		submit.click();
		
	}
	public void canceldoctor() {
		
	}

}
