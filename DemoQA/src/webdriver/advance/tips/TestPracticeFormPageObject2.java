package webdriver.advance.tips;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TestPracticeFormPageObject2 {

	@Test
	public void TestFirstAndLastNameFields() throws InterruptedException
	{
		// In order to understand how action on WebElements using PageObjects work,
		// we will save all the logs of chrome driver. Below statement helps us
		// save all the logs in a file called TestLog.txt
		System.setProperty("webdriver.chrome.logfile", "logs/TestLog.txt");

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/automation-practice-form");

		// Initialize the Page object
		PracticeFormPageObject pageObject = PageFactory.initElements(driver, PracticeFormPageObject.class);

		// set some text to fetch it later
		pageObject.firsName.sendKeys("Jesus");

		// We will first try to get Text from the WebElement version which is not cached.
		// We will measure the time to perform 1000 getText operations
		long withoutCacheStartTime = System.currentTimeMillis();
		for(int i = 0; i < 1000; i ++)
		{
			pageObject.firsName.getText();
		}
		long withoutCacheEndTime = System.currentTimeMillis();
		System.out.println("Time take in seconds Without cache " + ((withoutCacheEndTime - withoutCacheStartTime)/ 1000));

		// Let us now repeat the same process on the cached element and see
		// the amount of time it takes to perform the same operation 1000 times
		long withCacheStartTime = System.currentTimeMillis();
		for(int i = 0; i < 1000; i ++)
		{
			pageObject.firsNameCached.getText();
		}
		long withCacheEndTime = System.currentTimeMillis();
		System.out.println("Time take in seconds With cache " + ((withCacheEndTime - withCacheStartTime)/ 1000));

		driver.close();
		driver.quit();
	}
}
