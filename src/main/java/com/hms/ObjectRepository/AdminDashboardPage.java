package com.hms.ObjectRepository;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDashboardPage {
	@FindBy(xpath = "//a[@href=\'manage-users.php\']")
	private WebElement manageuser;

	@FindBy(xpath = "//a[@href='manage-doctors.php']")
	private WebElement managedoctor;

	@FindBy(xpath = "//a[@href='appointment-history.php']")
	private WebElement appointmenthistory;

	@FindBy(xpath = "//a[@href='manage-patient.php']")
	private WebElement managepatient;

	@FindBy(xpath = "(//div[@class='item-inner'])[6]")
	private WebElement contactus;
	@FindBy(xpath = "//span[normalize-space()='Doctors']")
	private WebElement doctorsdropdwn;
	
	@FindBy(xpath = "//span[normalize-space()='Doctor Specialization']")
	private WebElement spcl;
	
	@FindBy(xpath = "//span[.=' Add Doctor'] ")
	private WebElement dctr;

	@FindBy(xpath = "//i[@class='ti-angle-down']")
	private WebElement dropdwn;
	@FindBy(name = "//a[normalize-space()='Log Out']")
	private WebElement logout;


	public AdminDashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getManageuser() {
		return manageuser;
	}

	public WebElement getManagedoctor() {
		return managedoctor;
	}

	public WebElement getAppointmenthistory() {
		return appointmenthistory;
	}

	public WebElement getContactus() {
		return contactus;
	}

	public WebElement getManagepatient() {
		return managepatient;
	}

	public WebElement getDctr() {
		return dctr;
	}

	public WebElement getDoctorsdropdwn() {
		return doctorsdropdwn;
	}

	public WebElement getLogout() {
		return logout;
	}

	public WebElement getSpcl() {
		return spcl;
	}

	public WebElement getDropdwn() {
		return dropdwn;
	}

	public void veiwpatients() {
		manageuser.click();}

	public void contactus() {
		contactus.click();	}
	public void dctr() {
		dctr.click();
	}

	public void logout() {
		dropdwn.click();
		logout.click();
	}
	public void selectdct() {
		doctorsdropdwn.click();
		spcl.click();

	}
	public void details()  {
		doctorsdropdwn.click();
		dctr.click();
		
	}

}






