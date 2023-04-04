package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;

public class CheckOut_Page extends BaseClass {

	private static WebElement element;

	public static String sProductName;

	public static String sProductPrice;

	public CheckOut_Page(WebDriver driver) {
		super(driver);
	}

	public static WebElement txt_ProductName() {
		element = null;
		try {
			element = driver.findElement(By.xpath(".//div[@class='cartSection']/h3"));
			Log.info(element.getText() + " Product Name element is found on Check Out Page");
		} catch (Exception e) {
			Log.error(element.getText() + " Product Name element on Check Out page is not found");
			throw (e);
		}
		return element;
	}

	public static WebElement txt_ProductPrice() {
		element = null;
		try {
			element = driver.findElement(By.xpath(".//div[@class='cartSection']/p[2]"));
			Log.info(element.getText() + " Product Price element is found on Check Out Page");
		} catch (Exception e) {
			Log.error(element.getText() + " Product Price element on Check Out page is not found");
			throw (e);
		}
		return element;
	}

	public static WebElement btn_Checkout() {

		element = null;
		try {
			element = driver.findElement(By.xpath(".//div[starts-with(@class,'subtotal')]//button"));
			Log.info("Continue button is found on Check Out Page");
		} catch (Exception e) {
			Log.error("Continue button on Check Out page is not found");
			throw (e);
		}
		return element;
	}
}
