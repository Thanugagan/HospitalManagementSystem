 package doctorLogin;

import org.openqa.selenium.WebDriver;

import com.hms.GenericUtilities.ExcelUtility;
import com.hms.GenericUtilities.FileUtility;
import com.hms.GenericUtilities.JavaUtility;
import com.hms.GenericUtilities.WebDriverUtility;
import com.hms.ObjectRepository.AddDoctorPage;
import com.hms.ObjectRepository.AdminDashboardPage;
import com.hms.ObjectRepository.AdminLoginPage;
import com.hms.ObjectRepository.DoctorSpecializationpage;
import com.hms.ObjectRepository.HomePage;

public class ManagedoctortestbyPOM {
public static void main(String[] args) throws Throwable {
	WebDriver driver=null;
	JavaUtility jLib = new JavaUtility();
	ExcelUtility eLib = new ExcelUtility();
	WebDriverUtility wLib = new WebDriverUtility();
	FileUtility fLib = new FileUtility();
	String browser=fLib.readDataFromPropertyFile("browser");
	int random = jLib.getRandomNo();
	driver=wLib.toLauchBrowser(driver, browser);
	wLib.maximizeWindow(driver);
	wLib.waitForPageLaod(driver);
	String url=fLib.readDataFromPropertyFile("adminurl");
	driver.get(url);
	AdminLoginPage alp=new AdminLoginPage(driver);
	String name = fLib.readDataFromPropertyFile("username1");
	String pass=fLib.readDataFromPropertyFile("password1");
	alp.adminlogin(name,pass);
	AdminDashboardPage adp=new AdminDashboardPage(driver); 
	adp.selectdct();
	DoctorSpecializationpage dsp=new DoctorSpecializationpage(driver);
	String spcl=eLib.readDataFromExcelsheet("Doctor",0,1);
	dsp.selectspcl(spcl);
	adp.details();
	String dctnme = eLib.readDataFromExcelsheet("Doctor", 4,1 )+random;
	String addrs = eLib.readDataFromExcelsheet("Doctor", 5,1 );
	String fees = eLib.readDataFromExcelsheet("Doctor", 6,1 );
	String contact = eLib.readDataFromExcelsheet("Doctor", 7,1 );
	String email = dctnme+eLib.readDataFromExcelsheet("Doctor", 8,1 );
	Thread.sleep(2000);
	String pass1  = eLib.readDataFromExcelsheet("Doctor", 9,1 );
	String passa = eLib.readDataFromExcelsheet("Doctor", 10,1 );
	AddDoctorPage adps=new AddDoctorPage(driver);
	adps.adddoctor(spcl, dctnme, addrs, fees, contact, email, pass1, passa);
    wLib.acceptAlert(driver);
    
    
	
	
	
	

	
	
	
	
	
	
}
}
