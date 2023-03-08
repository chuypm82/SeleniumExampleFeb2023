package webdriver.advance.tips;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class WebDriverManagerEdge {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		//Creating webDriver instance
		WebDriverManager.edgedriver().setup();
		WebDriver driver= new EdgeDriver();
		System.out.println("Browser executable path is set as :- "+System.getProperty("webdriver.edge.driver"));
		
		String url="https://rahulshettyacademy.com/locatorspractice/";
		driver.get(url);
				
		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise - only one window closed");

	}

}
