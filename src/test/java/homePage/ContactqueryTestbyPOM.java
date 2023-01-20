package homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

public class ContactqueryTestbyPOM {
	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		FileUtility fLib = new FileUtility();
		String browser=fLib.readDataFromPropertyFile("browser");
		int random = jLib.getRandomNo();
		driver=wLib.toLauchBrowser(driver, browser);
		String URL = fLib.readDataFromPropertyFile("pageurl");

		String name = eLib.readDataFromExcelsheet("Contact Details", 0, 1);
		String mbl = eLib.readDataFromExcelsheet("Contact Details", 1, 1);
		String des = eLib.readDataFromExcelsheet("Contact Details", 2, 1);
		String email=name+random+eLib.readDataFromExcelsheet("Contact Details", 3, 1);		
		driver.get(URL);
		wLib.waitForPageLaod(driver);
		HomePage hp = new HomePage(driver);
		hp.contactpage();
		Contactuspage cp = new Contactuspage(driver);
		cp.contactquery(name, email, mbl, des);
		wLib.acceptAlert(driver);
		hp.HomePage();

		hp.adminpage();
		String username1 = fLib.readDataFromPropertyFile("username1");
		String pswrd = fLib.readDataFromPropertyFile("password1");
		AdminLoginPage alp = new AdminLoginPage(driver);
		alp.adminlogin(username1, pswrd);
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
		wLib.acceptAlert(driver);
		
		
	}
}

