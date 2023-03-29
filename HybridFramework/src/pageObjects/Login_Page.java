package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Log;

public class Login_Page {

	private static WebElement element = null;

	public static WebElement lnk_MyAccount(WebDriver driver) {
		element = driver.findElement(By.id("account"));
		return element;
	}

	// Method to enter username
	public static WebElement inputUsername(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='userEmail']"));
		Log.info("Username text box found");
		return element;
	}
	
	// Method to enter password
	public static WebElement inputPassword(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='userPassword']"));
		Log.info("Password text box found");
		return element;
	}

	// Method to click login button
	public static WebElement buttonLogin(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='login']"));
		Log.info("Login button found");
		return element;
	}

}