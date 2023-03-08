package webdriver.inter.tricks;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTest {

	private static ChromeDriver driver;
	WebElement element;

	@BeforeClass
	public static void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void valid_UserCredential() throws InterruptedException {

		System.out.println("Starting test " + new Object() {
		}.getClass().getEnclosingMethod().getName());
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		// driver.findElement(By.xpath(".//*[@id='account']/a")).click();
		driver.findElement(By.xpath("//input[@id='inputUsername']")).sendKeys("Jesus");
		driver.findElement(By.xpath("//input[@name='inputPassword']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();

		String welcomeText="";
		
		try {

			WebElement element = new WebDriverWait(driver,Duration.ofSeconds(5))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='logout-btn']")));
			
			welcomeText= driver.findElement(By.xpath("//h2")).getText();
			
			System.out.println(welcomeText);
		} catch (Exception e) {
		}

		Assert.assertEquals(welcomeText,"Hello Jesus,");
		Thread.sleep(1000);
		System.out.println("Ending test " + new Object() {
		}.getClass().getEnclosingMethod().getName());
	}
	
	@Test
	public void inValid_UserCredential() throws InterruptedException {

		System.out.println("Starting test " + new Object() {
		}.getClass().getEnclosingMethod().getName());
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		// driver.findElement(By.xpath(".//*[@id='account']/a")).click();
		driver.findElement(By.xpath("//input[@id='inputUsername']")).sendKeys("Jesus");
		driver.findElement(By.xpath("//input[@name='inputPassword']")).sendKeys("rahulshettyacadem");
		driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();

		String welcomeText="";
		
		try {

			WebElement element = new WebDriverWait(driver,Duration.ofSeconds(5))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='error']")));
			
			welcomeText= driver.findElement(By.xpath("//p[@class='error']")).getText();
			
			System.out.println(welcomeText);
		} catch (Exception e) {
		}

		Assert.assertEquals(welcomeText,"* Incorrect username or password");
		Thread.sleep(1000);
		System.out.println("Ending test " + new Object() {
		}.getClass().getEnclosingMethod().getName());
	}

	@AfterClass
	public static void closeBrowser() {
		driver.quit();
	}

}
