package com.hms.GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.hms.ObjectRepository.DoctorLoginPage;
import com.mysql.cj.jdbc.Driver;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;
	public ExcelUtility eLib=new ExcelUtility();
	public FileUtility fLib=new FileUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public JavaUtility jLib=new JavaUtility();
	
	static {
		System.setProperty("webdriver.edge.driver", "./geckodriver.exe");
	}
	@BeforeSuite
	public void configdb() {
		System.out.println("---connect to base---");
	}
	//@Parameters("BROWSER")
	@BeforeClass
	public void configBC() throws Throwable {
		String browser = fLib.readDataFromPropertyFile("browser");
	driver=	wLib.toLauchBrowser(driver, browser);
		
	sdriver=driver;
		wLib.maximizeWindow(driver);
		wLib.waitForPageLaod(driver);
	
		System.out.println("----launch browser----");
	}
	
	@AfterClass
	public void configAC() {
		driver.quit();
		
	}

}
