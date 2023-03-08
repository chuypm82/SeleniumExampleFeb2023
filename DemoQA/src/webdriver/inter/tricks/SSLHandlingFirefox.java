package webdriver.inter.tricks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SSLHandlingFirefox {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		//Creating webDriver instance
		WebDriver driver= new FirefoxDriver();
		
		String url="https://self-signed.badssl.com/";
		driver.get(url);
		System.out.println("The page title is: " +driver.getTitle());
				
		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise - only one window closed");

	}

}
