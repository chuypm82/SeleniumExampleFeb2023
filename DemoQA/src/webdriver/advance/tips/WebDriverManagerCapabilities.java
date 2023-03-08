package webdriver.advance.tips;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerCapabilities {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		// Creating webDriver instance
		ChromeOptions options = new ChromeOptions();
		WebDriverManager.chromedriver()
			.driverVersion("109")
			.arch32().proxy("proxyhostname:80")
			.proxyUser("username")
			.proxyPass("password")
		.setup();
		WebDriver driver = new ChromeDriver(options);

		String url = "https://rahulshettyacademy.com/locatorspractice/";
		driver.get(url);

		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise - only one window closed");

	}

}
