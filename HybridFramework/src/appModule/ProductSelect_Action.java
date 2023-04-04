package appModule;

import org.openqa.selenium.WebElement;

import pageObjects.Home_Page;
import pageObjects.ProductListing_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

public class ProductSelect_Action {

	public static void productType(int iTestCaseRow) throws Exception {
		
		String productType=ExcelUtils.getCellData(iTestCaseRow, Constant.Col_ProductType);
		WebElement mainElement=Home_Page.TopNavigation.Product_Type.mainElementCategory();
		WebElement subElement=Home_Page.TopNavigation.Product_Type.subElementCategory(productType);
		Utils.mouseHoverAction(mainElement, subElement, productType);
		Log.info(productType.toUpperCase() + " categoy is selected on Top Navigation of Home Page");
	}

	public static void productName(int iTestCaseRow) throws Exception {

		ProductListing_Page.sProductName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_ProductName);
		ProductListing_Page.btn_AddToCart(ProductListing_Page.sProductName).click();
		Log.info(ProductListing_Page.sProductName + " is selected from the Product Listing page");
		Home_Page.interceptElement();
		Home_Page.buttonCart().click();
		Log.info("Click action is performed on Main Cart button");

	}

}
