package webdriver.advance.tips;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class WebDriverManagerChrome {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		//Creating webDriver instance
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		System.out.println("Browser executable path is set as :- "+System.getProperty("webdriver.chrome.driver"));
		
		String url="https://rahulshettyacademy.com/locatorspractice/";
		driver.get(url);
				
		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise - only one window closed");

	}

}
