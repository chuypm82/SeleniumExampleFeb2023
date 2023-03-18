package TestNGSamples2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ParallelTest {
	public WebDriver driver;
	@Test
	public void FirefoxTest() throws InterruptedException {
		
		System.out.println("The Thread ID for Firefox is: " + Thread.currentThread().getId());
		driver = new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		WebElement userName = driver.findElement(By.xpath("//input[@id='inputUsername']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='inputPassword']"));
		userName.sendKeys("Jesus");
		password.sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test
	public void ChromeTest() throws InterruptedException {
		
		System.out.println("The Thread ID for Chrome is: " + Thread.currentThread().getId());
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver= new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		WebElement userName = driver.findElement(By.xpath("//input[@id='inputUsername']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='inputPassword']"));
		userName.sendKeys("Jesus");
		password.sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
		Thread.sleep(2000);
		driver.quit();
	}
}