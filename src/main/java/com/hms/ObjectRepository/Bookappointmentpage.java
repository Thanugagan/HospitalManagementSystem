package com.hms.ObjectRepository;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.GenericUtilities.JavaUtility;
import com.hms.GenericUtilities.WebDriverUtility;

public class Bookappointmentpage extends WebDriverUtility {
	@FindBy(name = "Doctorspecialization")
	private WebElement specialization;
	
	@FindBy(name="doctor")
	private WebElement doct;
	
	@FindBy(name = "appdate")
	private WebElement date;
	
	@FindBy(name="apptime")
	private WebElement time;
	
	@FindBy(name = "submit")
	private WebElement submit;
	
	public Bookappointmentpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSpecialization() {
		return specialization;
	}

	public WebElement getDoct() {
		return doct;
	}

	public WebElement getDate() {
		return date;
	}

	public WebElement getTime() {
		return time;
	}
	
	public WebElement getSubmit() {
		return submit;
	}

	public void book(JavaUtility jlib, String special,String docname,String date1,String tim) {
		select(special, specialization);
		select(docname, doct);
		date.sendKeys(date1);
		time.sendKeys(tim);
		submit.click();
	}

}
