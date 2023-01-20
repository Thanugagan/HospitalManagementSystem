package practice;

import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionTest {
	@Test
	public void sample1() {
		System.out.println("----Testscript01-----");
		System.out.println("----Testscript02-----");
		Assert.assertEquals("A", "B");
		System.out.println("----Testscript03-----");
		System.out.println("----Testscript04-----");	
	}
	@Test
public void sample2() {
	System.out.println("----Testscript05-----");
	System.out.println("----Testscript06-----");
	assertEquals("a", "a");
	System.out.println("----Testscript07-----");
	System.out.println("----Testscript08-----");
}
	@Test
	public void sample3() {
		String a=null;
		assertNotNull(a);
		System.out.println("-----");
	}
	@Test
	public void Sample4() {
		System.out.println("test9");
		SoftAssert sa = new SoftAssert();
		sa.assertEquals("x", "y");
		System.out.println("Test10");
		sa.assertAll();
		}
	
}
