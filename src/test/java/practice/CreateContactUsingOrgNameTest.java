package practice;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateContactUsingOrgNameTest {
		public static void main(String[] args) throws Throwable {
			
		Random ran = new Random();
		int random = ran.nextInt(500);
		
		
		//get Common Data
		FileInputStream fis = new FileInputStream("./src/test/resources/vtigerdata.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		//get data from excel
		FileInputStream fi = new FileInputStream("./src/test/resources/testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Contacts");
		String OrgName = sh.getRow(1).getCell(1).getStringCellValue()+random;
		String lastName = sh.getRow(1).getCell(0).getStringCellValue()+random;
	
		
		//launch browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//login to App
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
			//Create Organization
			driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			driver.findElement(By.name("accountname")).sendKeys(OrgName);
		
		//click on contacts link
		driver.findElement(By.linkText("Contacts")).click();
		
		//click on lookup image
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		//create Contacts
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		
		//select existing Org
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		
		Set<String> window = driver.getWindowHandles();
		
		Iterator<String> it = window.iterator();
		while(it.hasNext())
		{
			String wind = it.next();
			String currentTitle = driver.switchTo().window(wind).getTitle();
			if(currentTitle.contains("Accounts&action"))
			{
				break;
			}
		}
		driver.findElement(By.id("search_txt")).sendKeys(OrgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).click();
	
		Set<String> win = driver.getWindowHandles();
		for(String win1:win)
		{
			driver.switchTo().window(win1);
		}
		
		
		//handle leadsource dropdown
				WebElement element = driver.findElement(By.name("leadsource"));
				
				Select sel = new Select(element);
				
				
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
				
				//Signout from App
				WebElement signout = driver.findElement(By.linkText("Sign Out"));
				
				Actions act = new Actions(driver);
				act.moveToElement(signout);
				
				signout.click();
	}

}