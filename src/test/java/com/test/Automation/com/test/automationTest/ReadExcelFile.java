package com.test.Automation.com.test.automationTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xslf.usermodel.XSLFSheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	public static Object[][] readData() throws IOException
	{
		String [][] arrayExcelData=null;
		File file= new File("D:/Ashwini/Data.xlsx");
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook book = new XSSFWorkbook(fis);
		XSSFSheet sheet= book.getSheetAt(0);
		int rowcount=sheet.getLastRowNum()-sheet.getFirstRowNum();
		XSSFRow row=sheet.getRow(0);
		int columnCount = row.getLastCellNum();
		arrayExcelData=new String[rowcount][columnCount];
		for(int i=1;i<=rowcount;i++)
		{
			row=sheet.getRow(i);
			for(int j=0;j<row.getLastCellNum();j++)
			{
				//XSSFCell cell=row.getCell(j);
				//XSSFCell cell=row(i).
				arrayExcelData[i-1][j]=row.getCell(j).toString();
			}
		}
		return arrayExcelData;
	}

}
