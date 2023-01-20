package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hms.GenericUtilities.ExcelUtility;

public class DataProviderTest {
	@Test(dataProvider ="getData")
	public void reaData(String from,String to) {
		System.out.println(from+"----->"+to);
		
	}
@DataProvider
public Object[][]getData() throws Throwable{
		ExcelUtility elib=new ExcelUtility();
		Object[][] value = elib.readMultiplesetofData("DataProvider");
		return value;
		
	}
}
