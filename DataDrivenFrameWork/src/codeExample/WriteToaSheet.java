package codeExample;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteToaSheet {

	public static void main(String args[]) throws IOException {

		// Create an object of File class to open xlsx file
		File file = new File("testData/TestData.xlsx");

		// Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);

		// Creating workbook instance that refers to .xlsx file
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);

		// Creating a Sheet object using the sheet Name
		XSSFSheet sheet = wb.getSheet("Student-Data");

		//Create a new Row
		XSSFRow row2=sheet.createRow(3);
		
		//create a cell object to enter value in it using cell Index
		row2.createCell(0).setCellValue("Diana");
		row2.createCell(1).setCellValue("Jane");
		row2.createCell(2).setCellValue("djanes@gmail.com");
        row2.createCell(3).setCellValue("Female");
        row2.createCell(4).setCellValue("8786858432");
        row2.createCell(5).setCellValue("Park Lane, Flat C1 , New Jersey");
		
		//To write into Excel File
		FileOutputStream outputStream= new FileOutputStream ("testData/TestData.xlsx");
		wb.write(outputStream);		
		
	}	
}
