package webdriver.advance.tips;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class JavaScriptWithXpath {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		//Creating webDriver instance
		WebDriver driver= new ChromeDriver();
		
		String url="https://rahulshettyacademy.com/locatorspractice/";
		driver.get(url);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//WebElement searchbox = null;

		
		WebElement value = (WebElement) js.executeScript("return document.evaluate( '//input[@id=\"inputUsername\"]' ,document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null ).singleNodeValue;");
		value.sendKeys("Jesus");

		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise - only one window closed");

	}

}
