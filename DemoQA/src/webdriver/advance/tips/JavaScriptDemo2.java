package webdriver.advance.tips;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class JavaScriptDemo2 {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		//Creating webDriver instance
		WebDriver driver= new ChromeDriver();
		
		String url="https://rahulshettyacademy.com/locatorspractice/";
		driver.get(url);
		
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		
		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise - only one window closed");

	}

}
