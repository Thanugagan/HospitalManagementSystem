package practice;

import org.testng.annotations.Test;

@Test(dataProvider = "data")
public class DataProvider {
	public void  travel (String src,String dest,int price) {
		System.out.println("From"+src+"------->"+"to"+dest+  price);
	}
@org.testng.annotations.DataProvider
public Object[][] data()
{
	Object[][]objarr=new Object[3][3];
	objarr[0][0]="bang";
	objarr[0][1]="mysr";
	objarr[0][2]=150;
	
	objarr[1][0]="mysr";
	objarr[1][1]="bnglr";
	objarr[1][2]=150;
	
	objarr[2][0]="bnglr";
	objarr[2][1]="hassan";
	objarr[2][2]=250;
	
	return objarr;	
}

}
