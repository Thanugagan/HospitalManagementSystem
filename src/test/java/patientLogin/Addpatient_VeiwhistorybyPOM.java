package patientLogin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.hms.GenericUtilities.BaseClass;
import com.hms.GenericUtilities.ExcelUtility;
import com.hms.GenericUtilities.FileUtility;
import com.hms.GenericUtilities.JavaUtility;
import com.hms.GenericUtilities.WebDriverUtility;
import com.hms.ObjectRepository.Bookappointmentpage;
import com.hms.ObjectRepository.Createpatientpage;
import com.hms.ObjectRepository.PatientLoginPage;
import com.hms.ObjectRepository.UserDashboard;

public class Addpatient_VeiwhistorybyPOM extends BaseClass {


	@Test 
	public void Addpatient_Veiwhistorytest() throws Throwable{
		
		int random = jLib.getRandomNo();
		String url = fLib.readDataFromPropertyFile("patienturl");
		String browser = fLib.readDataFromPropertyFile("browser");
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
		Bookappointmentpage bpp=new Bookappointmentpage(driver);
		String special = eLib.readDataFromExcelsheet("Patientname", 8, 1);
		String docname = eLib.readDataFromExcelsheet("Patientname", 9, 1);
		String date = eLib.readDataFromExcelsheet("Patientname", 10, 1);
		String time = eLib.readDataFromExcelsheet("Patientname", 11, 1);
		bpp.book(jLib, special, docname, date, time);
		wLib.acceptAlert(driver);
		udb.apntmnthstry(); 	
		
	}

}

