package com.hms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.GenericUtilities.ExcelUtility;
import com.hms.GenericUtilities.JavaUtility;
import com.hms.GenericUtilities.WebDriverUtility;
import com.mysql.cj.jdbc.Driver;

public class Createpatientpage extends WebDriverUtility {
	@FindBy(partialLinkText = "Create")
	private WebElement create;
	
	@FindBy(name = "full_name")
	private WebElement fullnamElement;
	
	@FindBy(name = "address")
	private WebElement address;
	
	@FindBy(name = "city")
	private WebElement city;
	
	@FindBy(xpath = "//label[@for='rg-female']")
	private WebElement female;
	
	@FindBy(xpath = "//label[@for='rg-male']")
	private WebElement male;
	
	
	@FindBy(name="email")
	private WebElement mail;
	
	@FindBy(name = "password")
	private WebElement pswrd;
	
	
	@FindBy (name = "password_again")
	private WebElement passagain;
	
	@FindBy(xpath = "//label[@for='agree']")
	private WebElement agree;
	
	@FindBy(name   = "submit")
	private WebElement submit;
	
	@FindBy(xpath = "//a[normalize-space()='Log-in']")
	private WebElement login;

	//Intialisation

		public Createpatientpage(WebDriver driver) {
			PageFactory.initElements(driver, this);}

//Utilisation

		public WebElement getCreate() {
			return create;
		}

		public WebElement getFullnamElement() {
			return fullnamElement;
		}

		public WebElement getAddress() {
			return address;
		}

		public WebElement getCity() {
			return city;
		}

		public WebElement getFemale() {
			return female;
		}

		public WebElement getMale() {
			return male;
		}

		public WebElement getMail() {
			return mail;
		}

		public WebElement getPswrd() {
			return pswrd;
		}

		public WebElement getPassagain() {
			return passagain;
		}

		public WebElement getAgree() {
			return agree;
		}

		public WebElement getSubmit() {
			return submit;
		}
		public WebElement getLogin() {
			return login;
		}
		
	//Buisness Libraries
	
		public void createpatiesntfemale(WebDriver driver, String name,String addrs,String City,String email,String pass,String pasagain) {
			create.click();
			fullnamElement.sendKeys(name);
			address.sendKeys(addrs);
			city.sendKeys(City);
			female.click();
			mail.sendKeys(email);
			pswrd.sendKeys(pass);
			passagain.sendKeys(pasagain);
			agree.click();
			submit.click();
			acceptAlert( driver);
			login.click();}
		public void createpatiesntmale(ExcelUtility eul, JavaUtility jul,String name,String addrs,String City,String email,String pass,String pasagain) throws Throwable {
			create.click();
			fullnamElement.sendKeys(name);
			address.sendKeys(addrs);
			city.sendKeys(City);
			male.click();
			mail.sendKeys(email);
			pswrd.sendKeys(pass);
			passagain.sendKeys(pasagain);
			agree.click();
			submit.click();	
		}}

		
		
		