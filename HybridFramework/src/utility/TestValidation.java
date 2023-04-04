package utility;

import org.openqa.selenium.WebDriver;

import pageObjects.BaseClass;

public class TestValidation {
	
	public static void Execute(int iTestCaseRow) throws Exception {

		if(BaseClass.bResult==true){
			ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.Col_Result);
			Log.info("Test Case is completed with Pass status");
		}else{
			throw new Exception("Test Case Failed because of Verification");
		}
	}
	
	public static void onFailed(WebDriver driver,  String sTestCaseName, int iTestCaseRow, Exception e) throws Exception {

		ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.Col_Result);
		Utils.takeScreenshot(driver, sTestCaseName);
		Log.error(e.getMessage());
		throw (e);
	}

}
