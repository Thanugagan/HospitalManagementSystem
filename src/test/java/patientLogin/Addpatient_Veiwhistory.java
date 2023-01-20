package patientLogin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hpsf.Array;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.bouncycastle.crypto.tls.UDPTransport;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hms.GenericUtilities.BaseClass;
import com.hms.GenericUtilities.ExcelUtility;
import com.hms.GenericUtilities.FileUtility;
import com.hms.GenericUtilities.JavaUtility;
import com.hms.GenericUtilities.WebDriverUtility;
import com.hms.ObjectRepository.Bookappointmentpage;
import com.hms.ObjectRepository.Createpatientpage;
import com.hms.ObjectRepository.HomePage;
import com.hms.ObjectRepository.PatientLoginPage;
import com.hms.ObjectRepository.UserDashboard;
@Listeners(com.hms.GenericUtilities.ListnerImplementationclass.class)
public class Addpatient_Veiwhistory extends BaseClass{
	@Test(retryAnalyzer = com.hms.GenericUtilities.IretryAnalyzerImplemention.class)
	public void patienthistory() throws Throwable {
		String url=fLib.readDataFromPropertyFile("patienturl");
		String pname = eLib.readDataFromExcelsheet("Patientname", 0, 7);
		String address = eLib.readDataFromExcelsheet("Patientname", 1, 7);
		String city = eLib.readDataFromExcelsheet("Patientname", 2, 7);
		String email = pname+jLib.getRandomNo()+eLib.readDataFromExcelsheet("Patientname", 3, 7);
		String pass = eLib.readDataFromExcelsheet("Patientname", 4, 7);
		String passagain = eLib.readDataFromExcelsheet("Patientname", 5, 7);
		eLib.WriteDataToExcel("Patientname", 3, 8,email);
		driver.get(url);
		Createpatientpage cpp = new Createpatientpage(driver);
		cpp.createpatiesntfemale(driver,pname, address, city, email, pass, passagain);
		PatientLoginPage plp = new PatientLoginPage(driver);
		plp.userlogin(email, pass);
		UserDashboard udb=new UserDashboard(driver);
		udb.bookapntmnt();
		Assert.fail(); 
		Bookappointmentpage bpp=new Bookappointmentpage(driver);
		String special = eLib.readDataFromExcelsheet("Patientname", 8, 1);
		String docname = eLib.readDataFromExcelsheet("Patientname", 9, 1);
		String date = eLib.readDataFromExcelsheet("Patientname", 10, 1);
		String time = eLib.readDataFromExcelsheet("Patientname", 11, 1);
		bpp.book(jLib, special, docname, date, time);
		udb.apntmnthstry();
	}
	
	
	
	
	@Test
	public void add(){
		System.out.println("smoke-add");

	}
}
