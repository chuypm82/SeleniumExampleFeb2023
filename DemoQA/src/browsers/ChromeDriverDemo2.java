package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class ChromeDriverDemo2 {

	public static void main(String[] args) throws InterruptedException {
		
		// Setting the driver path
		System.out.println("Execution after setting EdgeDriver path in System Variables");
		//String driverPath = "C:\\Users\\625337\\OneDrive - BOOZ ALLEN HAMILTON\\Documents\\Personal\\Trainings\\Selenium\\Drivers\\msedgedriver.exe";
		//System.setProperty("webdriver.edge.driver", driverPath);
				
		//Creating webDriver instance
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver= new ChromeDriver(options);
		
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		Thread.sleep(2000);
		driver.quit();
		System.out.println("Execution Complete on Windows");


	}

}
