package com.selenium.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtils {

	String excelpath = "./testdataselenium.xlsx";
	String filepath = "./config.properties";

	/* to get property file datas */
	public Properties getPropertyFileData() throws IOException {
		FileInputStream fi = new FileInputStream(filepath);
		Properties prop = new Properties();
		prop.load(fi);
		return prop;
	}

	/* to read excel file datas */
	public String getExceldata(String sheetname, int rowNum, int colNum)
			throws Exception, InvalidFormatException, IOException {
		FileInputStream fis = new FileInputStream(excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		String data = sh.getRow(rowNum).getCell(colNum).getStringCellValue();
		wb.close();
		return data;
	}

	/* to write excel file datas */

	public void setExceldata(String sheetname, int rowNum, int colNum, String data)
			throws Exception, InvalidFormatException, IOException {
		FileInputStream fis = new FileInputStream(excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		sh.getRow(rowNum).createCell(colNum).setCellValue(data);

		FileOutputStream fo = new FileOutputStream(excelpath);
		wb.write(fo);
		wb.close();
	}

	/* getrowCount method */
	public int getrowCount(String sheetname) throws EncryptedDocumentException, InvalidFormatException, IOException {
		FileInputStream fis = new FileInputStream(excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int row = sh.getLastRowNum();
		int rowcount = row + 1;
		return rowcount;
	}

}
