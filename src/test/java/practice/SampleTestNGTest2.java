package practice;

import org.testng.annotations.Test;

public class SampleTestNGTest2 {
	
		@Test(groups = {"smoke","regression"})
		public void Sample3() {
			System.out.println("---TestScript03----");
		}

		@Test(groups = {"smoke","regression"})
		public void Sample4() {
			System.out.println("---TestScript04----");
		}

	}


