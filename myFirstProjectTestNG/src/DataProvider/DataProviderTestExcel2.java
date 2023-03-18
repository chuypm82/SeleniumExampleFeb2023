package DataProvider;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import utility.ExcelUtils2;

public class DataProviderTestExcel2 {
	private String sTestCaseName;
	private int iTestCaseRow;
	private static WebDriver driver;

	@BeforeMethod
	public void beforeMethod() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
	}

	// Here we are calling the Data Provider object with its Name
	@Test(dataProvider = "Authentication")
	public void test(String sUsername, String sPassword) throws InterruptedException {
		WebElement userName = driver.findElement(By.xpath("//input[@id='inputUsername']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='inputPassword']"));
		userName.sendKeys(sUsername);
		password.sendKeys(sPassword);
		driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(1000);
		driver.close();
	}

	@DataProvider(name = "Authentication")
	public  Object[][] credentials() throws Exception {
		// Setting up the Test Data Excel file

		ExcelUtils2.setExcelFile("testData/TestData.xlsx", "Test-Data");

		sTestCaseName = this.toString();

		// From above method we get long test case name including package and class name
		// etc.

		// The below method will refine your test case name, exactly the name use have
		// used

		sTestCaseName = ExcelUtils2.getTestCaseName(this.toString());

		// Fetching the Test Case row number from the Test Data Sheet

		// Getting the Test Case name to get the TestCase row from the Test Data Excel
		// sheet

		iTestCaseRow = ExcelUtils2.getRowContains(sTestCaseName, 0);

		Object[][] testObjArray = ExcelUtils2.getTableArray("testData/TestData.xlsx",
				"Test-Data", iTestCaseRow);

		return (testObjArray);

		// Object[][] testObjArray = ExcelUtils.getTableArray("testData/TestData.xlsx",
		// "Test-Data");
		// return (testObjArray);
	}
}
