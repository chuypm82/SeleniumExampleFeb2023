package Automation.KeywordFramework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import Keywords.Defined.Keywords;
import Keywords.Defined.Assertions1;

public class IrctcLogic {
	WebDriver driver;
	String path = System.getProperty("user.dir");

	Keywords keyword = new Keywords();
	Assertions1 assertion= new Assertions1();
	
	@Test
	public void readExcelandexecute() throws IOException, InterruptedException {

		FileInputStream fileInputStream = new FileInputStream(
				"C:\\Users\\625337\\Documents\\Personal\\Trainings\\Selenium-Dec2022\\Workspace\\KeywordFramework\\Externals\\TestCases.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

		int testcasescount = workbook.getNumberOfSheets() - 4;

		System.out.println("Total test cases :" + testcasescount);

		//iterate sheets (test cases)
		for (int testCaseNum = 0; testCaseNum < testcasescount; testCaseNum++) {
			//System.setProperty("webdriver.chrome.driver",
					//"C:\\Users\\625337\\Documents\\Personal\\Trainings\\Selenium\\Downloads\\chromedriver_win32\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);

			XSSFSheet worksheet = workbook.getSheetAt(testCaseNum);

			System.out.println("worksheet Number " + testCaseNum + ": " + worksheet.getSheetName());

			int totalRowCount = worksheet.getLastRowNum();
			int totalColumnCount = worksheet.getRow(1).getLastCellNum();

			//iterate rows (steps))
			for (int i = 1; i <= totalRowCount; i++) {

				LinkedList<String> Testexecution = new LinkedList<>();

				System.out
						.println("Row value: " + i + " It has first cell value as : " + worksheet.getRow(i).getCell(0));

				//iterate columns (parameters)
				for (int j = 0; j < totalColumnCount - 1; j++) {
					System.out.println("Column index :" + j);
					Cell Criteria = worksheet.getRow(i).getCell(j);

					String CriteriaText;
					if (Criteria == null) {
						CriteriaText = null;
					} else {
						if (Criteria.getCellType() == CellType.NUMERIC)
							CriteriaText = NumberToTextConverter.toText(Criteria.getNumericCellValue());
						else
							CriteriaText = Criteria.getStringCellValue();
					}
					Testexecution.add(CriteriaText);
				}
				System.out.println("List :" + Testexecution);

				String TestStep = Testexecution.get(0);
				String ObjectName = Testexecution.get(1);
				String LocatorType = Testexecution.get(2);
				String Testdata = Testexecution.get(3);
				String AssertionType = Testexecution.get(4);
				String ExpectedValue = Testexecution.get(5);
				String ActualValue = Testexecution.get(6);

				perform(TestStep, ObjectName, LocatorType, Testdata, AssertionType, ExpectedValue, ActualValue);

				System.out.println("Row" + i + " is read and action performed");
			}

			driver.quit();
			System.out.println("************************TEST CASE " + worksheet.getSheetName()
					+ " is executed*******************");
		}
	}

	public void perform(String operation, String objectName, String locatorType, String testdata, String assertionType,
			String expectedValue, String actualValue) throws IOException, InterruptedException {

		switch (operation) {
		case "enter_URL":
			keyword.enter_URL(driver, testdata);
			break;

		case "get_currentURL":
			keyword.get_currentURL(driver);
			break;

		case "type":
			keyword.type(driver, objectName, locatorType, testdata);
			break;

		case "click":
			keyword.click(driver, objectName, locatorType);
			break;
			
		case "implicitWait":
			keyword.implicitWait(driver, testdata);
			break;
			
		case "explicitWait":
			keyword.explicitWait(driver, testdata, objectName, locatorType);
			break;
			
		case "sleep":
			keyword.sleep(testdata);
			break;

		default:
			break;
		}

		if (operation.contains("AssertURL")) {

			switch (assertionType) {
			case "contains":			
				assertion.AssertURLContains(keyword.get_currentURL(driver), expectedValue);
				break;
				
			case "equals":
				assertion.AssertURLEquals(keyword.get_currentURL(driver), expectedValue);
				break;

			default:
				break;

			}
		}
		
		if(operation.contains("AssertElement")) {
			assertion.AssetElement(driver, assertionType, objectName, locatorType);
		}
	}

}
