package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.NewSessionPayload;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hms.GenericUtilities.WebDriverUtility;
@Test
public class Assertforlogin {
	public void main() {
		WebDriverUtility w=new WebDriverUtility();
		WebDriver driver=null;
		driver=w.toLauchBrowser(driver, "chrome");
		driver.get("http://rmgtestingserver/domain/Hospital_Management_System/hms/doctor/");
		String tittle = driver.getTitle();
		Assert.assertTrue(tittle.contains("Login"), "failed bcs page doesnt contain tittle");
		WebElement UN = driver.findElement(By.name("username"));
		WebElement PSWRD = driver.findElement(By.name("password"));
		
		SoftAssert sa = new SoftAssert();
		Rectangle rectP = PSWRD.getRect();
		Rectangle rectUN = UN.getRect();
		int unht = rectUN.getHeight();
		int unwdth = rectUN.getWidth();
		int psht = rectP.getHeight();
		int pswdth = rectP.getWidth();
		String a=UN.getAttribute("placeholder");
		sa.assertEquals(a, "Username");
		String b=PSWRD.getAttribute("placeholder");
		sa.assertEquals(b, "Password");
		sa.assertEquals(unwdth, pswdth);
		sa.assertEquals(unht, psht);
		sa.assertAll();
		
		
	}
	

}
