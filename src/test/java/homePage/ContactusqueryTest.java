package homePage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.hms.GenericUtilities.BaseClass;
import com.hms.GenericUtilities.ExcelUtility;
import com.hms.GenericUtilities.FileUtility;
import com.hms.GenericUtilities.JavaUtility;
import com.hms.GenericUtilities.WebDriverUtility;
import com.hms.ObjectRepository.AdminDashboardPage;
import com.hms.ObjectRepository.AdminLoginPage;
import com.hms.ObjectRepository.Contactquerypage;
import com.hms.ObjectRepository.Contactuspage;
import com.hms.ObjectRepository.HomePage;
import com.hms.ObjectRepository.Querydeatilspage;

public class ContactusqueryTest extends BaseClass {

	
	@Test(groups = "smoke")
	public void contact() throws Throwable {
//		WebDriver driver=null;
//		JavaUtility jLib = new JavaUtility();
//		ExcelUtility eLib = new ExcelUtility();
//		WebDriverUtility wLib = new WebDriverUtility();
//		FileUtility fLib = new FileUtility();
		
		//USING GENERIC METHOD
		String browser=fLib.readDataFromPropertyFile("browser");
		int random = jLib.getRandomNo();
		driver=wLib.toLauchBrowser(driver, browser);
		String URL = fLib.readDataFromPropertyFile("pageurl");
		
		
		
		
//		Random ran = new Random();
//		int random = ran.nextInt(50);
//		FileInputStream fi = new FileInputStream("./src/test/resources/commondata.properties");
//		Properties pObj = new Properties();
//		pObj.load(fi);
//		String url = pObj.getProperty("pageurl");

		//USING GENERIC METHOD
String name = eLib.readDataFromExcelsheet("Contact Details", 0, 1);
String mbl = eLib.readDataFromExcelsheet("Contact Details", 1, 1);
String des = eLib.readDataFromExcelsheet("Contact Details", 2, 1);
String email=name+random+eLib.readDataFromExcelsheet("Contact Details", 3, 1);		
		
		
//		FileInputStream fis = new FileInputStream("./src/test/resources/testdata.xlsx");
//		Workbook wb = WorkbookFactory.create(fis);
//		Sheet sh = wb.getSheet("Contact Details");
		
		
	
//		WebDriver driver = new ChromeDriver();
	driver.get(URL);
	//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         wLib.waitForPageLaod(driver);
         
        HomePage hp = new HomePage(driver);
        
        hp.contactpage();
        Contactuspage cp = new Contactuspage(driver);
        cp.contactquery(name, email, mbl, des);
        wLib.acceptAlert(driver);
        hp.HomePage();
        
//		driver.findElement(By.xpath("//a[text()='contact']")).click();
//		ArrayList<String> list = new ArrayList<String>();
//		list.add("fullname");
//		list.add("mobileno");
//		list.add("description");
//		list.add("emailid");
//		String email=null;
	//	String name = sh.getRow(0).getCell(1).getStringCellValue();
	//	String mbl = sh.getRow(1).getCell(1).getStringCellValue();
	//	String des = sh.getRow(2).getCell(1).getStringCellValue();
//		int row = eLib.getlastrow("Contact Details");
//
//		for(int i=0;i<=row;i++)
//		{ 
////			String value= sh.getRow(i).getCell(1).getStringCellValue();
//			String value=eLib.readDataFromExcelsheet("Contact Details", i, 1);
//		if(list.get(i).equals("emailid")) {
//			email=name+random+value;
//			//driver.findElement(By.name(list.get(i))).sendKeys(email);
//			
//		
//		}
//		else
//			driver.findElement(By.name(list.get(i))).sendKeys(value);

		
	//	driver.findElement(By.name("submit")).click();
		
	//	driver.switchTo().alert().accept();
		hp.adminpage();
		
		
//		driver.findElement(By.xpath("//a[text()='Home']")).click();
//		driver.findElement(By.xpath("//h3[text()='Admin Login']/..//a")).click();
		
		String username1 = fLib.readDataFromPropertyFile("username1");
		String pswrd = fLib.readDataFromPropertyFile("password1");
		
		//String username1 = pObj.getProperty("username1");
		//String pswrd = pObj.getProperty("password1");
		AdminLoginPage alp = new AdminLoginPage(driver);
		alp.adminlogin(username1, pswrd);
//		driver.findElement(By.name("username")).sendKeys(username1);
//		driver.findElement(By.name("password")).sendKeys(pswrd);
//		driver.findElement(By.name("submit")).click();
//		driver.findElement(By.partialLinkText("New")).click();
		
		AdminDashboardPage adp = new AdminDashboardPage(driver);
		adp.contactus();
		Contactquerypage cqp = new Contactquerypage(driver);
		cqp.contactquery();
		try {
		boolean result = driver.findElement(By.xpath("//td[text()='"+email+"']")).isDisplayed();
		if(result) {
			System.out.println("displayed");
		}
		}
		catch (Exception e) {
			System.out.println("not displayed");

		}
		
		driver.findElement(By.xpath("//td[.='"+email+"']/..//a")).click();
		Querydeatilspage qdp = new Querydeatilspage(driver);
		qdp.addremark();
		 
		
//		driver.findElement(By.name("adminremark")).sendKeys("we will look into it");
//		driver.findElement(By.name("update")).click();
		wLib.acceptAlert(driver);
//		driver.switchTo().alert().accept();
		
			}
	@Test(groups = "regression")
	public void simple1() {
		System.out.println("regression");
	}
	@Test(groups = "smoke")
	public void simple2() {
		System.out.println("smoke");
	}
}
