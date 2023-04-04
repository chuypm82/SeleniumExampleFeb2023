package appModule;

import org.testng.Reporter;
import pageObjects.BaseClass;
import pageObjects.PlaceOrder_Page;
import pageObjects.Verification_Page;

public class Verification_Action {

	public static void Execute() throws Exception {
		
		
		Verification_Page.sProductName = Verification_Page.txt_ProductName().getText();
		if (Verification_Page.sProductName.equals(PlaceOrder_Page.sProductName)) {
			Reporter.log("Verification Passed for Product Name on Verification page");
		} else {
			Reporter.log("Verification Failed for Product Name on Verification page");
			BaseClass.bResult = false;
		}
		
		Verification_Page.sProductPrice = Verification_Page.txt_ProductPrice().getText();		
		if (Verification_Page.sProductPrice.equals(PlaceOrder_Page.sProductPrice)) {
			Reporter.log("Verification Passed for Product Price on Verification page");
		} else {
			Reporter.log("Verification Failed for Product Price on Verification page");
			BaseClass.bResult = false;
		}
		
		// Verify Last Page contains is correct and send to report
		Verification_Page.sVerificationText= Verification_Page.orderCompleteText().getText();
		if ("THANKYOU FOR THE ORDER.".equalsIgnoreCase(Verification_Page.sVerificationText)) { 
			Reporter.log("Verification Passed for Thank you for the order message on Verification page.");
		} else {
			Reporter.log("Verification Failed for Thank you for the order message on Verification page.");
			BaseClass.bResult = false;
		}
	}
}
