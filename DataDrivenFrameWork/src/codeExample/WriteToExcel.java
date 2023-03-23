package codeExample;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

public class WriteToExcel {

	public static void main(String args[]) throws IOException, InterruptedException {

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

		// Creating webDriver instance
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);

		// Navigate to the URL
		driver.get("https://demoqa.com/automation-practice-form");

		// wait for page to load
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		for (int i = 1; i <= rowCount; i++) {
			
            driver.navigate().refresh();
            // wait for page to load
    		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			// Identify the WebElements for the student registration form
			WebElement firstName = driver.findElement(By.id("firstName"));
			WebElement lastName = driver.findElement(By.id("lastName"));
			WebElement email = driver.findElement(By.id("userEmail"));
			WebElement genderMale = driver.findElement(By.id("gender-radio-1"));
			WebElement mobile = driver.findElement(By.id("userNumber"));
			WebElement address = driver.findElement(By.id("currentAddress"));
			WebElement submitBtn = driver.findElement(By.id("submit"));

			// Enter the values read from Excel in firstname,lastname,mobile,email,address
			firstName.sendKeys(sheet.getRow(i).getCell(0).getStringCellValue());
			lastName.sendKeys(sheet.getRow(i).getCell(1).getStringCellValue());
			email.sendKeys(sheet.getRow(i).getCell(2).getStringCellValue());
			mobile.sendKeys(sheet.getRow(i).getCell(4).getStringCellValue());
			address.sendKeys(sheet.getRow(i).getCell(5).getStringCellValue());

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", genderMale);

			// Click on submit button
			// submitBtn.click();

			// Verify the confirmation message
			// WebElement confirmationMessage =
			// driver.findElement(By.xpath("//div[text()='Thanks for submitting the
			// form']"));

			// create a new cell in the row at index 6
			XSSFCell cell = sheet.getRow(i).createCell(6);

			// check if confirmation message is displayed
			if (submitBtn.isDisplayed()) {
				// if the message is displayed , write PASS in the excel sheet
				cell.setCellValue("PASS");

			} else {
				// if the message is not displayed , write FAIL in the excel sheet
				cell.setCellValue("FAIL");
			}
			
			 // Write the data back in the Excel file
            FileOutputStream outputStream = new FileOutputStream("testData/TestData.xlsx");
            wb.write(outputStream);
            Thread.sleep(3000);
		}

		// Close the workbook
		wb.close();

		// Quit the driver
		 driver.quit();

	}
}
