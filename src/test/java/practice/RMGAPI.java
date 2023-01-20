package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RMGAPI {
	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		Connection con=null;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://rmgtestingserver:8084/");
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.name("projectName")).sendKeys("Hospital managements");
		//driver.findElement(By.name("teamSize")).sendKeys('3');
		driver.findElement(By.name("createdBy")).sendKeys("Thanuja");
		WebElement e = driver.findElement(By.name("status"));
		Select s = new Select(e);
		s.selectByVisibleText("Created");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		try{
			con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
			Statement state = con.createStatement();
			String query = "select * from project where created_by='Thanuja';";
			ResultSet result = state.executeQuery(query);
			while(result.next())
			{
				{
					System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4));
				}}}
			catch (Exception e1) {
				
			}
			finally
			{
				con.close();
				System.out.println("Closed database connection succesfully");
			}
			
			}}
			
		
		
	
		
	

