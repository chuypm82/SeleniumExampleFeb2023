package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Log;
import utility.Utils;

public class Home_Page extends BaseClass {

	private static WebElement element = null;

	public Home_Page(WebDriver driver) {
		super(driver);
	}
	
	// Method to verify home page element
	public static WebElement homePageVerficationElement() {
		element = driver.findElement(By.xpath(".//h3[contains(text(),'Automation')]"));
		Log.info("Verification(welcome) element is found on Home page");
		return element;
	}
	

	// Method to get element for search string and display the same on console
	public static WebElement elemSearchStr() {
		element = driver.findElement(By.xpath(".//div[@class='py-2 border-bottom ml-3']/input"));
		Log.info("Search element is found on Home page");
		return element;
	}

	// Method to get element for logout button
	public static WebElement buttonLogout() {
		element = driver.findElement(By.xpath("(.//button[@class='btn btn-custom'])[4]"));
		Log.info("Logout element is found on Home page");
		return element;
	}
	
	// Method to get element for Cart button
	public static WebElement buttonCart() {
		element = driver.findElement(By.xpath("(.//button[@class='btn btn-custom'])[3]"));
		Utils.waitForVisibleElement(element);
		Log.info("Main Cart button is found on Home page");
		return element;
	}
	
	// Method to get intercept element 
	public static WebElement interceptElement() {
		element = driver.findElement(By.xpath(".//div[contains(@class,'multiple')]"));
		Utils.waitForNotVisibleElement(element);
		Log.info("interceptElement element is found on Home page");
		return element;
	}

	public static class TopNavigation {

		public static class Product_Type {

			public static WebElement mainElement;
			public static WebElement subElement;
			static WebElement element;
			
			public static WebElement mainElementCategory() throws Exception {
				mainElement = null;
				try {
					mainElement = driver.findElement(By.xpath("(.//h6[text()='Categories'])[2]/parent::div"));
					Log.info("Product Category Section element is found under Top Navigation of Home page");
				} catch (Exception e) {
					Log.info("Product Category Section element is not found under Top Navigation of Home page");
					throw (e);
				}
				return mainElement;
			}
			
			public static WebElement subElementCategory(String categoryName) throws Exception {
				element = null;
				try {
					List<WebElement> elementsList = mainElement.findElements(By.xpath("./div/child::label"));
					for (WebElement e : elementsList) { // find element based on product name
						if (categoryName.equalsIgnoreCase(e.getText())) {
							subElement=e.findElement(By.xpath("./parent::div/child::input"));
							Log.info("Check box element is found on Top Navigation of Home Page for " + categoryName + " Category");
							return subElement;
						}
					}
				} catch (Exception e) {
					Log.error("Check box element is not found on Top Navigation of Home Page for " + categoryName + " Category");
					throw (e);
				}
				return element;
			}

			public static void Accessories() throws Exception {
				try {
					mainElement = driver.findElement(By.linkText("Product Category"));
					Log.info("Product category link is found under Top Navigation");
					subElement = driver.findElement(By.linkText("Accessories"));
					Log.info("Accessories link is found under Product Category");
					Utils.mouseHoverAction(mainElement, subElement, getSubElementString(subElement));
				} catch (Exception e) {
					Log.error("Accessories link is not found under Product Category");
				}

			}
			
			public static void fashion() throws Exception {
				try {
					mainElement = driver.findElement(By.xpath("(.//h6[text()='Categories'])[2]/parent::div"));
					Log.info("Product category link is found under Top Navigation");
					subElement = mainElement.findElement(By.xpath("./div[2]/child::input"));
					Log.info("Fashion checkbox is found under Product Category");
					Utils.mouseHoverAction(mainElement, subElement, getSubElementString(subElement));
				} catch (Exception e) {
					Log.error("Fashion checkbox is not found under Product Category");
					throw (e);
				}
			}
			
			public static String getSubElementString(WebElement subElement) {
				String strSubElement= subElement.findElement(By.xpath("./parent::div/child::label")).getText();
				return strSubElement;
			}
		}

	}
}