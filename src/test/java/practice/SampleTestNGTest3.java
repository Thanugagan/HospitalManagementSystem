package practice;

import org.testng.annotations.Test;

public class SampleTestNGTest3 {

	@Test(groups = "regression")
	public void Sample5() {
		System.out.println("---TestScript05----");
	}
	@Test(groups = "smoke")
	public void Sample6() {
		System.out.println("---TestScript06----");
	}
}

