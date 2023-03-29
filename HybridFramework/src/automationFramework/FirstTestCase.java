package automationFramework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FirstTestCase {

	public static void main(String[] args) throws InterruptedException {

		// Creating webDriver instance
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://rahulshettyacademy.com/client/");

		// use implicit wait to wait for pages to load
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// Maximize window
		driver.manage().window().maximize();

		// Retrieving web page title
		String title = driver.getTitle();
		System.out.println("The page title is: " + title);

		// Locating web element
		WebElement uName = driver.findElement(By.xpath("//input[@id='userEmail']"));
		WebElement pass = driver.findElement(By.xpath("//input[@id='userPassword']"));
		WebElement loginBtn = driver.findElement(By.xpath("//input[@id='login']"));

		// Performing actions on web elements
		uName.sendKeys("chuy@bah.com");
		pass.sendKeys("Hello1234!");
		loginBtn.click();
		Thread.sleep(1000);

		try {
			// locating web element
			WebElement logOutBtn = driver.findElement(By.xpath("(//button[@class='btn btn-custom'])[4]"));
			// validating presence of web element
			if (logOutBtn.isDisplayed()) {
				// Performing action on web element
				logOutBtn.click();
				System.out.println("Logout Successful");
			}
		} catch (Exception e) {
			System.out.println("Incorrec Login...");

		}
		Thread.sleep(1000);
		driver.quit();
	}
}
