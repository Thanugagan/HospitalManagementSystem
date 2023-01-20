package practice;

import org.testng.annotations.Test;

public class SampleTestNGTest1 {
	@Test(groups = "smoke")
	public void Sample1() {
		System.out.println("---TestScript01----");
	}

	@Test(groups = "regression")
	public void Sample2() {
		System.out.println("---TestScript02----");
	}
	
}
