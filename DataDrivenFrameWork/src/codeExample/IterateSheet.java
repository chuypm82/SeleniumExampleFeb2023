package codeExample;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class IterateSheet {

	public static void main(String args[]) throws IOException {

		// Create an object of File class to open xlsx file
		File file = new File("testData/TestData.xlsx");

		// Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);

		// Creating workbook instance that refers to .xlsx file
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);

		// Creating a Sheet object using the sheet Name
		XSSFSheet sheet = wb.getSheet("Student-Data");

		// get all rows in the sheet
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		
		for(int i=0;i<=rowCount; i++) {
			
			//get cell count in a row
			int cellCount = sheet.getRow(i).getLastCellNum();
			
			System.out.println("Row" + i + " data is: " );
			for(int j=0; j<cellCount; j++) {
				System.out.print(sheet.getRow(i).getCell(j).getStringCellValue()+", ");
			}
			System.out.println();			
		}
	}
}
