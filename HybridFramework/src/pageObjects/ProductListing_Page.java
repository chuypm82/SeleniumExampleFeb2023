package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;

public class ProductListing_Page extends BaseClass {

	private static WebElement element;
	public static String sProductName;
	public static String sProductType;
	public static WebElement productNameElement;

	public ProductListing_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	public static WebElement categoryElement(String categoryName) throws Exception {
		element = null;
		try {
			List<WebElement> elementsList = driver.findElements(By.xpath("(.//h6[text()='Categories'])[2]/parent::div/div"));
			for (WebElement e : elementsList) { // find element based on product name
				if (categoryName.equalsIgnoreCase(e.getText())) {
					WebElement categoryElementCB = e.findElement(By.xpath("./input"));
					Log.info("Check box element is found on Product Listing Page for" + categoryName + "Category");
					return categoryElementCB;
				}
			}
		} catch (Exception e) {
			Log.error("Check box element is found on Product Listing Page for" + categoryName + "Category");
			throw (e);
		}
		return element;
	}

	
	public static WebElement btn_AddToCart(String productName) throws Exception {
		element = null;
		try {
			List<WebElement> elementsList = driver.findElements(By.xpath(".//div/h5/b"));
			for (WebElement e : elementsList) { // find element based on product name
				if (productName.equalsIgnoreCase(e.getText())) {
					WebElement cartButtonElement = e.findElement(By.xpath("parent::h5/following-sibling::button[2]"));
					Log.info("Add to Cart button is found on Product Listing Page for " + productName);
					return cartButtonElement;
				}
			}
		} catch (Exception e) {
			Log.error("Add to Cart button is not found on Product Listing Page for " + productName);
			throw (e);
		}
		return element;
	}

	public static class Product_2 {

		public static WebElement txt_Name() throws Exception {
			element = null;
			try {
				element = driver.findElement(By.xpath(".//b[text()='adidas original']"));
				Log.info("Product Name is found for Product 2");
			} catch (Exception e) {
				Log.error("Product 2 Name is not found");
				throw (e);
			}
			return element;
		}

		public static WebElement btn_AddToCart() throws Exception {
			element = null;
			try {
				element = driver.findElement(
						By.xpath(".//b[text()='adidas original']/parent::h5/following-sibling::button[2]"));
				Log.info("Product Name is found for Product 2");
			} catch (Exception e) {
				Log.error("Product Name is not found");
				throw (e);
			}
			return element;
		}
	}

	public static class Product_1 {

		public static WebElement txt_Price(WebDriver driver) {
			WebElement element = null;
			// Write Code to find element here
			return element;
		}

		public static WebElement txt_SalesPrice(WebDriver driver) {
			WebElement element = null;
			// Write Code to find element here
			return element;
		}

		public static WebElement img_Product(WebDriver driver) {
			WebElement element = null;
			// Write Code to find element here
			return element;
		}

		public static WebElement txt_Name(WebDriver driver) {
			WebElement element = null;
			// Write Code to find element here
			return element;
		}

		public static WebElement txt_Desc(WebDriver driver) {
			WebElement element = null;
			// Write Code to find element here
			return element;
		}

		public static WebElement btn_AddToCart(WebDriver driver) {
			WebElement element = null;
			// Write Code to find element here
			return element;
		}
	}
}
