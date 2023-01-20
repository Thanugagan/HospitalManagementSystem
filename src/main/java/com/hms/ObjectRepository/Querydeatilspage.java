package com.hms.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Querydeatilspage {

	@FindBy(name = "adminremark")
	private WebElement remarks;

	@FindBy(name = "update")
	private WebElement update;

	public Querydeatilspage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getRemarks() {
		return remarks;
	}

	public WebElement getUpdate() {
		return update;
	}

public void addremark() {
	remarks.sendKeys("we will look into it");
	update.click();

}}
