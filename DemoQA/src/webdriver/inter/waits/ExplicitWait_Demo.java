package webdriver.inter.waits;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait_Demo {

	WebDriver driver;

	@Before
	public void setup() throws InterruptedException {

		// initializing drv variable using FirefoxDriver
		driver = new ChromeDriver();
		// launching gmail.com on the browser
		driver.get("https://demoqa.com/dynamic-properties");
		// maximized the browser window
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws InterruptedException {

		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='visibleAfter']")));
		
		WebElement buttonVisAfter = driver.findElement(By.xpath("//button[@id='visibleAfter']"));
		buttonVisAfter.click();

		// entering username
		//username.sendKeys("chuypm@gmail.com");

		//driver.findElement(By.xpath(" //*[@*='identifierNext']")).click();
		
		//Thread.sleep(5000);

/*		// entering password
		driver.findElement(By.id("Passwd")).sendKeys("password");

		// clicking signin button
		driver.findElement(By.id("signIn")).click();

		// explicit wait - to wait for the compose button to be click-able
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'COMPOSE')]")));
		// click on the compose button as soon as the "compose" button is visible
		driver.findElement(By.xpath("//div[contains(text(),'COMPOSE')]")).click();
		
		*/
	}

	@After
	public void teardown() {
		// closes all the browser windows opened by web driver
		driver.quit();
	}
}
