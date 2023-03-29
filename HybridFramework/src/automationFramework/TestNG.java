package automationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG {

	public WebDriver driver;

	@Test
	public void ChromeTestMethod() throws InterruptedException {
		String baseUrl = "https://rahulshettyacademy.com/locatorspractice/";
		System.out.println("Launching Google Chrome browser");
		driver = new ChromeDriver();
		driver.get(baseUrl);
		Reporter.log("We used Google Chrome ver 111 for this test");
		String testTitle = "Rahul Shetty Academy - Login pag";
		String originalTitle = driver.getTitle();
		//System.out.println("Original Title: "+ originalTitle);
		Assert.assertEquals(originalTitle, testTitle);
	}

	@BeforeMethod
	public void beforeTest() {
		System.out.println("Starting Test On Chrome Browser");
	}

	@AfterMethod
	public void afterTest() throws InterruptedException {
		System.out.println("Closing the browser ");
		Thread.sleep(2000);
		driver.quit();
	}

}
