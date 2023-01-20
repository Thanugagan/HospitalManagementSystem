package practice;

import org.testng.annotations.Test;

public class Sampletest {
	@Test (priority =2,dependsOnMethods = "update" )
	public void create() {
		System.out.println("created");
	}
	@Test(invocationCount = 3)
	public void update() {
		System.out.println("Updated");
	}
	@Test (priority = -1)
public void delete() {
		System.out.println("Deleted");
	
}}

