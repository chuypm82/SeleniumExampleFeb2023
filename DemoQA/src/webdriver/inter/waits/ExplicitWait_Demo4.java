package webdriver.inter.waits;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait_Demo4 {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		// Creating webDriver instance
		WebDriver driver = new ChromeDriver();
		// launching gmail.com on the browser
		driver.get("https://demoqa.com/dynamic-properties");
		// maximized the browser window
		driver.manage().window().maximize();
		
		WebElement foo = new WebDriverWait(driver,Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='visibleAfter']")));
		
		System.out.println(foo.getText());
		
		assertEquals(foo.getText(),"Visible After 5 Seconds");

		/*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='visibleAfter']")));

		WebElement buttonVisAfter = driver.findElement(By.xpath("//button[@id='visibleAfter']"));
		buttonVisAfter.click();*/

		//Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise - only one window closed");

	}

}
