package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class GeckoDriverHeadless {

	public static void main(String[] args) throws InterruptedException {
		
		// Setting the driver path
		System.out.println("Execution started-- Opening Firefox browser.");
		//String driverPath = "C:\\Users\\625337\\OneDrive - BOOZ ALLEN HAMILTON\\Documents\\Personal\\Trainings\\Selenium\\Drivers\\geckodriver.exe";
		//System.setProperty("webdriver.gecko.driver", driverPath);
		
		FirefoxOptions options = new FirefoxOptions();
		options.setHeadless(true);
				
		//Creating webDriver instance
		WebDriver driver= new FirefoxDriver(options);
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		Thread.sleep(2000);
		
		System.out.println("The page titlte is: " + driver.getTitle());
		
		driver.quit();
		System.out.println("Execution ending-- Webdriver session is closed.");

	}

}
