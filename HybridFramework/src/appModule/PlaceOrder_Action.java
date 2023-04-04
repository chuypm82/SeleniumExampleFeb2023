package appModule;

import org.testng.Reporter;
import pageObjects.BaseClass;
import pageObjects.PlaceOrder_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class PlaceOrder_Action {

	public static void Execute(int iTestCaseRow) throws Exception {

		PlaceOrder_Page.sProductName = PlaceOrder_Page.txt_ProductName().getText();		
		if (!"".equals(PlaceOrder_Page.sProductName)) { // Verify  product name is not null and send to report
			Reporter.log("Verification Passed for Product Name on Place Order page.");
		} else {
			Reporter.log("Verification Failed for Product Name on Place Order page.");
			BaseClass.bResult = false;
		}
		
		PlaceOrder_Page.sProductPrice = PlaceOrder_Page.txt_ProductPrice().getText();		
		if (!"".equals(PlaceOrder_Page.sProductPrice)) {// Verify  product price is not null and send to report
			Reporter.log("Verification Passed for Product Price on Place Order page.");
		} else {
			Reporter.log("Verification Failed for Product Price on Place Order page.");
			BaseClass.bResult = false;
		}		
		
		String countryName= ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Country);
		PlaceOrder_Page.input_Country().sendKeys(countryName);
		PlaceOrder_Page.btn_Country(countryName).click();
		//Thread.sleep(1000);
		Log.info(countryName + " is entered as Country value on Place Order page");
		PlaceOrder_Page.btn_PlaceOrder().click();
		Log.info("Click action performed on Place Order button");
	}

}
