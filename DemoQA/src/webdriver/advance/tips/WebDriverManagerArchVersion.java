package webdriver.advance.tips;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class WebDriverManagerArchVersion {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		//Creating webDriver instance
		ChromeOptions options= new ChromeOptions();
		//WebDriverManager.chromedriver().setup();
		WebDriverManager.chromedriver().driverVersion("110.0.5481.105").setup();
		WebDriverManager.chromedriver().browserVersion("110.0.5481.105").setup();
		WebDriver driver= new ChromeDriver(options);
		
		String url="https://rahulshettyacademy.com/locatorspractice/";
		driver.get(url);
				
		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise - only one window closed");

	}

}
