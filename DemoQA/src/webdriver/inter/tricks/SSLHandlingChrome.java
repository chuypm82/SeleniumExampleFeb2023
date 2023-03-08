package webdriver.inter.tricks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLHandlingChrome {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");
		
		ChromeOptions handlingSSL= new ChromeOptions();
		handlingSSL.setAcceptInsecureCerts(true);

		//Creating webDriver instance
		WebDriver driver= new ChromeDriver(handlingSSL);
		
		String url="https://expired.badssl.com/";
		driver.get(url);
		System.out.println("The page title is: " +driver.getTitle());
				
		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise - only one window closed");

	}

}
