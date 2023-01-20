package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcelTest {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Candidates");
		int count=sh.getLastRowNum();
		short cellcount = sh.getRow(0).getLastCellNum();
		for(int i=0;i<=count;i++)
		{ 
		
			for(int j=0;j<cellcount;j++)
			{
			String data=sh.getRow(i).getCell(j).getStringCellValue();
				System.out.println(data);
			}
		}
	}
}
