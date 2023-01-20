package practice;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class UsingDiffAnnotations {
	@BeforeMethod
	public void BM () {
		System.out.println("Login into application");	
	}
	@BeforeSuite
	public void BS() {
		System.out.println("connect to data base");}
	@BeforeClass
	public void BC() {
		System.out.println("Launch the browser");
	}
	@Test
	public void createclass() {
		System.out.println("created");
	}
	@Test
	public void createobject() {
		System.out.println("object created");
	}
	
	
	@AfterMethod
	public void AM () {
		System.out.println("Logout application");	
	}
	@AfterSuite
	public void AS() {
		System.out.println("disconnect to data base");}
	@AfterClass
	public void AC() {
		System.out.println("close the browser");	
}}


