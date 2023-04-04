package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;

public class Verification_Page extends BaseClass {

	private static WebElement element;
	public static String sProductName;
	public static String sProductPrice;
	public static String sVerificationText;

	public Verification_Page(WebDriver driver) {
		super(driver);
	}

	public static WebElement txt_ProductName() {
		element = null;
		try {
			element = driver.findElement(By.xpath(".//table[@class='order-summary']//td[2]/div[@class='title']"));
			Log.info(element.getText() +" Product Name element is found on Verification Page");
		} catch (Exception e) {
			Log.error(element.getText() +" Product Name element is not found on Verification Page");
			throw (e);
		}
		return element;
	}

	public static WebElement txt_ProductPrice() {
		element = null;
		try {
			element = driver.findElement(By.xpath(".//table[@class='order-summary']//td[3]/div[@class='title']"));
			//Log.info("Product Price element is found on Verification Page");
			Log.info(element.getText() +" Product Price element is found on Verification Page");
		} catch (Exception e) {
			Log.error(element.getText() +" Product Price element is not found on Verification Page");
			throw (e);
		}
		return element;
	}

	public static WebElement orderCompleteText() {

		element = null;
		try {
			element = driver.findElement(By.xpath("(.//table)[3]//td/h1"));
			Log.info("Thank you for the order message element is found on Verification page");
		} catch (Exception e) {
			Log.info("Thank you for the order message element is not found on Verification page");
			throw (e);
		}
		return element;
	}
}
