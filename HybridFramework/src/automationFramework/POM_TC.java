package automationFramework;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

// Import package pageObject.*

import pageObjects.Home_Page;
import pageObjects.Login_Page;

public class POM_TC {

	private static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {

		// Creating webDriver instance
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/client/");

		// Use page Object library now

		Login_Page.inputUsername(driver).sendKeys("chuy@bah.com");

		Login_Page.inputPassword(driver).sendKeys("Hello1234!");

		Login_Page.buttonLogin(driver).click();
		Thread.sleep(1000);

		System.out.println(" Login Successfully, now it is the time to Log Off buddy.");

		Home_Page.buttonLogout(driver).click();		
		Thread.sleep(1000);

		driver.quit();
	}
}
