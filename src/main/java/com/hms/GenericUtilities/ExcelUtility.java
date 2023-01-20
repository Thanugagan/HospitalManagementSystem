package com.hms.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	/**
	 * @author Thanu
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 */
	public int getlastrow(String SheetName) throws Throwable {
		FileInputStream fis = new FileInputStream(IpathConstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int count = sh.getLastRowNum();
		return count;
	}
	/**
	 * @author Thanu
	 * @param SheetName
	 * @param RowNo
	 * @param ColumnNo
	 * @return
	 * @throws Throwable
	 */
public String readDataFromExcelsheet(String SheetName,int RowNo,int ColumnNo) throws Throwable {
	FileInputStream fis = new FileInputStream(IpathConstants.Excelpath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(SheetName);
	Row rw=sh.getRow(RowNo);
	Cell cel = rw.getCell(ColumnNo);
	String value = cel.getStringCellValue();
	return value;
}
/**
 * @author Thanu
 * @param SheetName
 * @param RowNo
 * @param ColumnNo
 * @param data
 * @throws Throwable
 */
public void WriteDataToExcel(String SheetName,int RowNo,int ColumnNo,String data) throws Throwable {
	
	FileInputStream fis = new FileInputStream(IpathConstants.Excelpath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(SheetName);
	Row rw=sh.getRow(RowNo);
	Cell cel = rw.getCell(ColumnNo);
	cel.setCellValue(data);
	FileOutputStream fos = new FileOutputStream(IpathConstants.Excelpath);
	wb.write(fos);}
	
	public Object[][] readMultiplesetofData(String SheetName) throws Throwable {
		FileInputStream fis = new FileInputStream(IpathConstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int lastRow = sh.getLastRowNum()+1;
		int lastcell=sh.getRow(0).getLastCellNum();
		
		Object[][]obj=new Object[lastRow][lastcell];
		for(int i=0;i<lastRow;i++) {
			for(int j=0;j<lastcell;j++) {
			obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
		}	
		}
		
	return obj;
	
}

}
