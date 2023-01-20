package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mictest {
	public static void main(String[] args) throws Throwable {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://mictests.com/"); 
		driver.findElement(By.xpath("//button[@id='mic-launcher']")).click();
		driver.findElement(By.xpath("//li[@class='notice-done done_testingComplete']"));
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
	}}