package com.hms.ObjectRepository;

import javax.management.loading.PrivateClassLoader;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.GenericUtilities.ExcelUtility;

public class DoctorSpecializationpage {
	
  @FindBy(name = "doctorspecilization")
  private WebElement spclElement;
  
  @FindBy(name="submit")
  private WebElement submit;

public DoctorSpecializationpage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
public WebElement getSpclElement() {
	return spclElement;
}
public void selectspcl(String docname) {
	spclElement.sendKeys(docname);
	submit.click();
	
	  
	
}

}

