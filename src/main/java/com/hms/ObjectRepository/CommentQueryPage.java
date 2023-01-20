package com.hms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommentQueryPage {
	@FindBy(xpath = "//a[@href='query-details.php?id=9']")
	private WebElement details;
	public CommentQueryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getDetails() {
		return details;
	}
	public void details() {
		details.click();
		
	}


}
