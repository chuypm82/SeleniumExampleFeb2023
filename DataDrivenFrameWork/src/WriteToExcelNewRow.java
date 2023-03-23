
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteToExcelNewRow {

	public static void main(String args[]) throws IOException {

		// Create an object of File class to open xlsx file
		File file = new File("testData/TestData.xlsx");

		// Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);

		// Creating workbook instance that refers to .xlsx file
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);

		// Creating a Sheet object using the sheet Name
		XSSFSheet sheet = wb.getSheet("Student-Data");

		//Get Cell and set values
		XSSFCell cell= sheet.getRow(1).createCell(6);
		cell.setCellValue("PASS");
		cell= sheet.getRow(2).createCell(6);
		cell.setCellValue("FAIL");
		
		//To write into Excel File
		FileOutputStream outputStream= new FileOutputStream ("testData/TestData.xlsx");
		wb.write(outputStream);
		
		
	}	
}
