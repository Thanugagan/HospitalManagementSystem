package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteMultipleDataForExcelTest {
	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("./src/test/resources/testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Candidates");
		Row ro = sh.createRow(5);
		Cell cell = ro.createCell(0);
		cell.setCellValue("Sanvi");
		Cell ce = ro.createCell(1);
		ce.setCellValue("27");
		FileOutputStream fos = new FileOutputStream("./src/test/resources/testdata.xlsx");
		wb.write(fos);
	}

}
