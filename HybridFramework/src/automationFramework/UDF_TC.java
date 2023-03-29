package automationFramework;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import appModule.SignIn_Action;
import pageObjects.Home_Page;
import pageObjects.ProductListing_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

public class UDF_TC {

	public WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;

	@BeforeMethod
	public void beforeTest() throws Exception {

		DOMConfigurator.configure("runs/log4j.xml");
		sTestCaseName = this.toString();
		sTestCaseName = Utils.getTestCaseName(this.toString());
		Log.startTestCase(sTestCaseName);
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Test-Data");
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
		driver = Utils.openBrowser(iTestCaseRow);
	}

	@Test
	public void ChromeTestMethod() throws Exception {
		// Pass Constant Variables as arguments to Execute method
		ProductListing_Page.Product_1.btn_AddToCart(driver);
		SignIn_Action.Execute(driver);
		Thread.sleep(1000);
		System.out.println("Login Successfully, now it is the time to Log Off buddy.");
		Home_Page.buttonLogout(driver).click();
		Log.info("Click action is perfomred on Log Out Button");
	}

	@AfterMethod
	public void afterTest() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
	}

}
