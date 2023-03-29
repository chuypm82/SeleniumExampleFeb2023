package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Log;

public class Home_Page {

	private static WebElement element = null;

	// Method to get element for search string and display the same on console
	public static WebElement elemSearchStr(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@class='py-2 border-bottom ml-3']/input"));
		Log.info("Search element found");
		return element;
	}

	// Method to get element for logout button
	public static WebElement buttonLogout(WebDriver driver) {
		element = driver.findElement(By.xpath("(//button[@class='btn btn-custom'])[4]"));
		Log.info("Log Out button found");
		return element;
	}

}