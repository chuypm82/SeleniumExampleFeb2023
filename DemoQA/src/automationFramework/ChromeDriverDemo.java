package automationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverDemo {

	public static void main(String[] args) throws InterruptedException {
		
		// Setting the driver path
		System.out.println("Execution after setting ChromeDriver path in System Variables");
		//String driverPath = "C:\\Users\\625337\\OneDrive - BOOZ ALLEN HAMILTON\\Documents\\Personal\\Trainings\\Selenium\\Drivers\\chromedriver.exe";
		//System.setProperty("webdriver.chrome.driver", driverPath);
				
		//Creating webDriver instance
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		//String sourceCode= driver.getPageSource();
		//System.out.println(sourceCode);
		
		Thread.sleep(2000);
		driver.quit();
		System.out.println("Execution after setting ChromeDriver path in System Variables");

	}

}
