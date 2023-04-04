package appModule;

import pageObjects.Login_Page;
import org.testng.Reporter;
import pageObjects.Home_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

public class SignIn_Action  {

	public static void Execute(int iTestCaseRow) throws Exception {

		String sUserName= ExcelUtils.getCellData(iTestCaseRow, Constant.Col_UserName);
		String sPassword= ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Password);		
		
		Login_Page.inputUsername().sendKeys(sUserName);
		Log.info(sUserName+" is entered in UserName text box" );
		Login_Page.inputPassword().sendKeys(sPassword);
		Log.info(sPassword+" is entered in Password text box" );
		
		Login_Page.buttonLogin().click();
		Log.info("Click action performed on login button");
		Utils.waitForVisibleElement(Home_Page.homePageVerficationElement());
		Reporter.log("SignIn Action is successfully perfomred");
	}

}
