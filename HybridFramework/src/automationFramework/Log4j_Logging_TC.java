package automationFramework;

import java.time.Duration;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import appModule.SignIn_Action;
import pageObjects.Home_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class Log4j_Logging_TC {
	
	private static WebDriver driver = null;

	public static void main(String[] args) throws Exception {
		
		DOMConfigurator.configure("runs/log4j.xml");
		
		Log.startTestCase("Selenium_Test_001");
		
		ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData, "Test-Data");
		
		Log.info("Excel sheet opened");

		// Creating webDriver instance
		driver = new ChromeDriver();
		Log.info("New driver instantiated");
		
		driver.get(Constant.URL);
		Log.info("Web application launched");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Log.info("Implicit wait applied on the driver for 10 seconds");

		// Pass Constant Variables as arguments to Execute method
		SignIn_Action.Execute(driver);
		Thread.sleep(1000);
		System.out.println("Login Successfully, now it is the time to Log Off buddy.");
		Home_Page.buttonLogout(driver).click();
		Log.info("Click action is perfomred on Log Out Button");
		Thread.sleep(1000);
		driver.quit();
		Log.info("Browser closed");
		
		//This is to send the PASS value to the Excel sheet in the result column.
		ExcelUtils.setCellData("Pass", 1, 3);
		Log.endTestCase("Selenium_Test_001");
	}
}
