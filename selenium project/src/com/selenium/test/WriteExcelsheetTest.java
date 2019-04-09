package com.selenium.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteExcelsheetTest {

	public static void main(String[] args) throws Exception {

		FileInputStream fi=new FileInputStream("./testdataselenium.xlsx");
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh=wb.getSheet("Sheet1");
		sh.getRow(0).createCell(2).setCellValue("Pass");
		
		FileOutputStream fout=new FileOutputStream("./testdataselenium.xlsx");
		wb.write(fout);
		wb.close();

	}

}
