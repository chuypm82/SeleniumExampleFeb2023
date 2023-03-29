package automationFramework;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import appModule.SignIn_Action;
import pageObjects.Home_Page;
import utility.Constant;
import utility.ExcelUtils;

public class Apache_POI_TC {
	
	private static WebDriver driver = null;

	public static void main(String[] args) throws Exception {
		
		ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData, "Test-Data");

		// Creating webDriver instance
		driver = new ChromeDriver();
		
		driver.get(Constant.URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Pass Constant Variables as arguments to Execute method
		SignIn_Action.Execute(driver);
		Thread.sleep(1000);
		System.out.println("Login Successfully, now it is the time to Log Off buddy.");
		Home_Page.buttonLogout(driver).click();
		Thread.sleep(1000);
		driver.quit();
		
		//This is to send the PASS value to the Excel sheet in the result column.
		ExcelUtils.setCellData("Pass", 1, 3);
	}

}
