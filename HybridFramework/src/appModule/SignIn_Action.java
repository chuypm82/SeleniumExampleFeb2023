package appModule;

import org.openqa.selenium.WebDriver;
import pageObjects.Login_Page;
import utility.ExcelUtils;
import utility.Log;

public class SignIn_Action {

	public static void Execute(WebDriver driver) throws Exception {

		String sUserName= ExcelUtils.getCellData(1, 1);
		Log.info("Username picked from Excel is "+ sUserName );
		String sPassword= ExcelUtils.getCellData(1, 2);
		Log.info("Password picked from Excel is "+ sPassword );
		
		Login_Page.inputUsername(driver).sendKeys(sUserName);
		Log.info("Username entered in the Username text box");
		Login_Page.inputPassword(driver).sendKeys(sPassword);
		Log.info("Password entered in the Password text box");
		Login_Page.buttonLogin(driver).click();
		Log.info("Click action performed on login button");		
	}

}
