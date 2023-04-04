package appModule;

import pageObjects.Login_Page;
import org.testng.Reporter;
import pageObjects.Home_Page;
import utility.Log;
import utility.Utils;

public class SignOut_Action {

	public static void Execute() throws Exception {
		Home_Page.buttonLogout().click();
		Log.info("Click action performed on Logout button");
		Utils.waitForVisibleElement(Login_Page.verficationElement());
		Reporter.log("SignOut Action is successfully perfomred");
	}
}
