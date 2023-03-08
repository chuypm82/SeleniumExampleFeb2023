package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GeckoDriver3 {

	public static void main(String[] args) throws InterruptedException {
		
		// Setting the driver path
		System.out.println("Execution started-- Opening Firefox browser.");

		WebDriverManager.firefoxdriver().setup();
		System.setProperty("webdriver.gecko.logfile", "logs/TestLog.txt");
		WebDriver driver= new FirefoxDriver();
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		Thread.sleep(2000);
		driver.quit();
		System.out.println("Execution ending-- Webdriver session is closed.");

	}

}
