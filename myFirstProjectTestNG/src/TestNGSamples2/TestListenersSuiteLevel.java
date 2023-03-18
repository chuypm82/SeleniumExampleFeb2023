package TestNGSamples2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.Reporter;

public class TestListenersSuiteLevel {
	public WebDriver driver;
	private int i = 1;
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Initilizing the Google Chrome Driver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
	}

	@Test // Success Test
	public void CloseBrowser() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
		Reporter.log("Driver Closed After Testing");
	}

	@Test // Failed Test
	public void OpenBrowser() {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		String expectedTitle = "Rahul Shetty Academy - Login page";
		String originalTitle = driver.getTitle();
		Assert.assertEquals(originalTitle, expectedTitle, "Titles of the website do not match");
	}
	
	@Test (successPercentage = 60, invocationCount = 3) //Failing Within Success
	public void AccountTest() {
		System.out.println("i value: " + i);
			if(i < 2)
				Assert.assertEquals(i , i);
		i++;
	}

	@Test  // Skip Test
	public void SkipTest() {
		throw new SkipException("Skipping The Test Method ");
	}

}