package TestNGSamples2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MultiBrowser {
	public WebDriver driver;

	@Parameters("browser")
	@BeforeClass
	// Passing Browser parameter from TestNG xml
	public void beforeTest(String browser) {

		// If the browser is Firefox, then do this
		if (browser.equalsIgnoreCase("firefox")) {
			// Initializing the firefox driver (Gecko)
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			// Initialize the chrome driver
			driver = new ChromeDriver();
		}
		// Enter the website address in the browser
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
	}
	// Once Before method is completed, Test method will start
	@Test
	public void login() throws InterruptedException {
		WebElement userName = driver.findElement(By.xpath("//input[@id='inputUsername']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='inputPassword']"));
		userName.sendKeys("Jesus");
		password.sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
		Thread.sleep(2000);
	}

	@AfterClass
	public void afterTest() {
		driver.quit();
	}

}