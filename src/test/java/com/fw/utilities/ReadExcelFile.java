package com.fw.utilities;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static FileInputStream fis;
	String path;
	
	public ReadExcelFile(String path) {
		this.path = path;
	}
	
	
	public int getRowCount(String xlsheetname) throws Exception{
		
		fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(xlsheetname);
		
		int rowCount = sheet.getLastRowNum();
		wb.close();
		fis.close();
		return rowCount;
	}
	
	
	public int getCellCount(String xlsheetname) throws Exception {
		fis = new FileInputStream(path);
		wb = new  XSSFWorkbook(fis);
		sheet = wb.getSheet(xlsheetname);
		
		int cellCount = sheet.getRow(0).getLastCellNum();
		wb.close();
		fis.close();
		return cellCount;
		
	}
	
	
	public String getCellData(String xlsheetname, int rowNum, int cellNum) throws Exception {
		fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(xlsheetname);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		String cellData;
		
		DataFormatter formatter = new DataFormatter();
		cellData = formatter.formatCellValue(cell);
		
		wb.close();
		fis.close();
		
		return cellData;
		
	}
}
