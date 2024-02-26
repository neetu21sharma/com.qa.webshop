package com.ws.utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	XSSFWorkbook workbook;
	public ExcelUtil(String xcelpath)
	{
	try
	{
		File file = new File(xcelpath);
		FileInputStream fis = new FileInputStream(file);
		workbook = new XSSFWorkbook(fis);
	}
	catch(Exception e)
	{
	System.out.println("Unable to read the xcel sheet. Please check");
	e.printStackTrace();
	}

}
	//this method is used to retrieve active row count from the sheetno
	public int getRowCount(int sheetNo)//(paramater to tell which sheet I am getting the data from)
	{
		int count = workbook.getSheetAt(sheetNo).getLastRowNum()+1;
		return count;
	}
	//retrieve the data from excel
	public String getCellData(int sheetNo, int row, int cell)
	{
		String data = workbook.getSheetAt(sheetNo).getRow(row).getCell(cell).toString();
		return data;
}
}       


