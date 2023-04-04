package testCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import appModule.CheckOut_Action;
import appModule.PlaceOrder_Action;
import appModule.ProductSelect_Action;
import appModule.SignIn_Action;
import appModule.SignOut_Action;
import appModule.Verification_Action;
import pageObjects.BaseClass;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.TestValidation;
import utility.Utils;

public class Framework_001 {

	public WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;

	@BeforeMethod
	public void beforeTest() throws Exception {

		DOMConfigurator.configure("runs/log4j.xml");
		sTestCaseName = this.toString();
		sTestCaseName = Utils.getTestCaseName(this.toString());
		Log.startTestCase(sTestCaseName);
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, Constant.SheetName);
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
		driver = Utils.openBrowser(iTestCaseRow);
		new BaseClass(driver);
	}

	@Test
	public void MainTestCase() throws Exception {

		try {
			SignIn_Action.Execute(iTestCaseRow);
			Thread.sleep(1000);
			ProductSelect_Action.productType(iTestCaseRow);
			Thread.sleep(1000);
			ProductSelect_Action.productName(iTestCaseRow);
			CheckOut_Action.Execute();
			PlaceOrder_Action.Execute(iTestCaseRow);
			Verification_Action.Execute();
			System.out.println("Login Successfully, now it is the time to Log Off buddy.");
			SignOut_Action.Execute();
			TestValidation.Execute(iTestCaseRow);
		} catch (Exception e) {
			TestValidation.onFailed(driver, sTestCaseName, iTestCaseRow, e);
		}
	}

	@AfterMethod
	public void afterTest() throws InterruptedException {
		Log.endTestCase(sTestCaseName);
		Thread.sleep(1000);
		driver.quit();

	}
}
