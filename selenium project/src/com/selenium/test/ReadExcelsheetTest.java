package com.selenium.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcelsheetTest {

	public static void main(String[] args) throws Exception {
		
		 FileInputStream fi=new FileInputStream("C:\\Users\\Asus-User\\eclipse-workspace\\selenium project\\testdataselenium.xlsx");
		 Workbook wb=WorkbookFactory.create(fi);
		 Sheet sh=wb.getSheet("Sheet1");
		 String data=sh.getRow(3).getCell(1).getStringCellValue();
		 System.out.println(data);
		 
		 int rowcount=sh.getLastRowNum();
		 System.out.println("total row count is "+(rowcount+1));
		 
		 for (int i = 0; i <= rowcount; i++) {
		 String data1=sh.getRow(i).getCell(0).getStringCellValue();
		 System.out.println("data from row "+i+" is "+data1);
		}
		 wb.close();
	}

}
