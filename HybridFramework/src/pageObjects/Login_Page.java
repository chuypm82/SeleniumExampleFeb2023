package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Log;

public class Login_Page extends BaseClass {
	
	private static WebElement element = null;

	public Login_Page(WebDriver driver) {
		super(driver);
	}

	// Method to verify login page element
	public static WebElement verficationElement() {
		element = driver.findElement(By.xpath(".//h1[contains(@class,'login')]"));
		Log.info("Verification element is found on Login page");
		return element;
	}
	

	// Method to enter username
	public static WebElement inputUsername() {
		element = null;
		try {
			element = driver.findElement(By.xpath("//input[@id='userEmail']"));
			Log.info("Username text box is found on Login page");
		} catch (Exception e) {
			Log.error("Username text box is not found on Login page");
			throw (e);
		}
		return element;
	}
	
	// Method to enter password
	public static WebElement inputPassword() {
		element = driver.findElement(By.xpath("//input[@id='userPassword']"));
		Log.info("Password text box is found on Login page");
		return element;
	}

	// Method to click login button
	public static WebElement buttonLogin() {
		element = driver.findElement(By.xpath("//input[@id='login']"));
		Log.info("Login button is found on Login page");
		return element;
	}

}