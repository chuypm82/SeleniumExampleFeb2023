package TestNGSamples2;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestNGAssertSimpleHard {
	WebDriver driver = new ChromeDriver();

	@Test(priority = 0)
	public void CloseBrowser() {
		driver.close();
		Reporter.log("Driver Closed After Testing");
	}

	@Test(priority = -1)
	public void OpenBrowser() {
		Reporter.log(
				"This test verifies the current selenium compatibility with TestNG by launching the chrome driver");
		Reporter.log("Launching Google Chrome Driver version 81 for this test");

		driver.get("https://www.demoqa.com");

		Reporter.log("The website used was DemoQA for this test", true);
		String expectedTitle = "Free QA Automation Tools For Everyone";
		String originalTitle = driver.getTitle();
		System.out.println("Original Title: " + originalTitle);
		Assert.assertEquals(originalTitle, expectedTitle); // hard assert
		
	}

}