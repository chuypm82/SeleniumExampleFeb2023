package webdriver.inter.waits;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ImplicitWaitS2 {

	protected WebDriver driver;

	@Test
	public void implicitWaitExcercise() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.manage().timeouts().(10, TimeUnit.SECONDS);

		// launch Chrome and redirect it to the URL
		driver.get("https://demoqa.com/dynamic-properties");

		// This element will appear after 5 secs
		driver.findElement(By.id("visibleAfter")).click();

		// close browser
		driver.close();
	}

}
