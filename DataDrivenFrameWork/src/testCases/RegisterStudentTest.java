package testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import utilities.ExcelUtils;
import utilities.Constants;

public class RegisterStudentTest {

	// creating object of ExcelUtils class
	static ExcelUtils excelUtils = new ExcelUtils();

	// using the Constants class values for excel file path
	static String excelFilePath = Constants.Path_TestData + Constants.File_TestData;

	public static void main(String args[]) throws IOException, InterruptedException {

		// Creating webDriver instance
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);

		// Navigate to the URL
		driver.get("https://demoqa.com/automation-practice-form");

		// wait for page to load
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// calling the ExcelUtils class method to initialise the workbook and sheet
		excelUtils.setExcelFile(excelFilePath, "Student-Data");

		// iterate over all the row to print the data present in each cell.
		for (int i = 1; i <= excelUtils.getRowCountInSheet(); i++) {

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
			firstName.sendKeys(excelUtils.getCellData(i, 0));
			lastName.sendKeys(excelUtils.getCellData(i, 1));
			email.sendKeys(excelUtils.getCellData(i, 2));
			mobile.sendKeys(excelUtils.getCellData(i, 4));
			address.sendKeys(excelUtils.getCellData(i, 5));

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", genderMale);

			// Click on submit button
			// submitBtn.click();

			// Verify the confirmation message
			// WebElement confirmationMessage =
			// driver.findElement(By.xpath("//div[text()='Thanks for submitting the
			// form']"));

			// check if confirmation message is displayed
			if (submitBtn.isDisplayed()) {
				// if the message is displayed , write PASS in the excel sheet
				excelUtils.setCellValue(i, 6, "PASS", excelFilePath);

			} else {
				// if the message is not displayed , write FAIL in the excel sheet
				excelUtils.setCellValue(i, 6, "FAIL", excelFilePath);
			}

			Thread.sleep(3000);
		}

		// Close the workbook
		excelUtils.closeWorkBook();

		// Quit the driver
		driver.quit();

	}

}
