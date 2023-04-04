package pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;

public class PlaceOrder_Page extends BaseClass {

	private static WebElement element;
	public static String sProductName;
	public static String sProductPrice;

	public PlaceOrder_Page(WebDriver driver) {
		super(driver);
	}

	public static WebElement txt_ProductName() {
		element = null;
		try {
			element = driver.findElement(By.xpath(".//div[@class='item__title']"));
			Log.info(element.getText() + " Product Name element is found on Place Order Page");
		} catch (Exception e) {
			Log.error(element.getText() + " Product Name element on Place Order page is not found");
			throw (e);
		}
		return element;
	}

	public static WebElement txt_ProductPrice() {
		element = null;
		try {
			element = driver.findElement(By.xpath(".//div[@class='item__price']"));
			Log.info(element.getText() + " Product Price element is found on Place Order Page");
		} catch (Exception e) {
			Log.error(element.getText() + " Product Price element on Place Order page is not found");
			throw (e);
		}
		return element;
	}
	
	public static WebElement input_Country() {
		element = null;
		try {
			element = driver.findElement(By.xpath(".//input[contains(@placeholder,'Country')]"));
			Log.info("Input Country element is found on Place Order Page");
		} catch (Exception e) {
			Log.error("Input Country element on Place Order page is not found");
			throw (e);
		}
		return element;
	}
	
	public static WebElement btn_Country(String countryName) {
		element = null;
		try {
			List<WebElement> elementsList = driver.findElements(By.xpath(".//button[contains(@class,'ta')]"));			
			for(WebElement e : elementsList) {
				if(countryName.equalsIgnoreCase(e.getText())) {					
					Log.info("Country dynamic button is found on Place Order Page");
					return e;
				}
			}			
		} catch (Exception e) {
			Log.error("Country dynamic button on Place Order page is not found");
			throw (e);
		}
		return element;
	}

	public static WebElement btn_PlaceOrder() {
		element = null;
		try {
			element = driver.findElement(By.xpath(".//a[contains(@class,'submit')]"));
			Log.info("Place Order button is found on Place Order Page");
		} catch (Exception e) {
			Log.error("Place Order button on Place Order page is not found");
			throw (e);
		}
		return element;
	}
}
