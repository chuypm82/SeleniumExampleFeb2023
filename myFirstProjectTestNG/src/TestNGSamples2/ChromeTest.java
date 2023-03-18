package TestNGSamples2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChromeTest {

	public WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		System.out.println("Initilizing the Google Chrome Driver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
	}

	@Test
	public void ChromeTestMethod() throws InterruptedException {
		System.out.println("The Thread ID for Chrome is: " + Thread.currentThread().getId());
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		WebElement userName = driver.findElement(By.xpath("//input[@id='inputUsername']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='inputPassword']"));
		userName.sendKeys("Jesus");
		password.sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		System.out.println("Closing the browser ");
		Thread.sleep(2000);
		driver.quit();
	}

}
