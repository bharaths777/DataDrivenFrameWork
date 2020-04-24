package com.orangehrm.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.orangehrm.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD = 40;
	public static long IMPLICIT_WAIT = 30;
	public 	static FileInputStream fis;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	
	
	
	public static Object[][] getData(String sheetName) {
		try {
			fis = new FileInputStream("G:\\Selenium_Rahul\\testng\\DDWithPOM\\testdata\\logindata.xlsx");
			wb = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		ws = wb.getSheet(sheetName);
		Object data[][] = new Object[ws.getLastRowNum()][ws.getRow(0).getLastCellNum()];
		
		for(int i =0 ; i <ws.getLastRowNum();i++) {
			for(int j = 0 ; j<ws.getRow(0).getLastCellNum();j++) {
				
				data[i][j] = ws.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}

}
