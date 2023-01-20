package com.hms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contactquerypage {
	
	@FindBy(xpath = "//span[normalize-space()='Unread Query']")
	private WebElement unread;
	
	public Contactquerypage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}

	public WebElement getUnread() {
		return unread;
	}
	
	public void contactquery() {
		unread.click();
		
	}

}
