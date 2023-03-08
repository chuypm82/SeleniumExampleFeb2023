package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GeckoDriver2 {

	public static void main(String[] args) throws InterruptedException {
		
		// Setting the driver path
		System.out.println("Execution started-- Opening Firefox browser.");
		//String driverPath = "C:\\Users\\625337\\OneDrive - BOOZ ALLEN HAMILTON\\Documents\\Personal\\Trainings\\Selenium\\Drivers\\geckodriver.exe";
		//System.setProperty("webdriver.gecko.driver", driverPath);
		//Creating webDriver instance
		//FirefoxOptions options = new FirefoxOptions();
		//options.setCapability("marionette", true);
		
		//setup the appropriate firefox driver
		//WebDriverManager.firefoxdriver().setup();
		WebDriverManager.firefoxdriver().setup();		
		WebDriver driver= new FirefoxDriver();
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		Thread.sleep(2000);
		driver.quit();
		System.out.println("Execution ending-- Webdriver session is closed.");

	}

}
