package TestNGSamples3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RetryTest {

	WebDriver driver;
	String baseURL = "https://www.linkedin.com/";

	@BeforeClass
	public void setup() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	}

	@Test(priority=1)
	public void verifyLoginPageText() {
		driver.navigate().to(baseURL);
		System.out.println("Verify login page test started");
		WebElement element = driver.findElement(By.xpath("//div[starts-with(@class,'self-start')]/h1"));
		String headerText = element.getText();
		System.out.println("Header Text: " + headerText);
		Assert.assertEquals(headerText, "Welcome to your professional communit");
	}

	//@Test(priority=2)
	public void verifyForgotPasswordPage() {
		driver.navigate().to(baseURL);
		System.out.println("Verify Forgot password page test started");
		WebElement element = driver.findElement(By.linkText("Forgot your password?"));
		element.click();
		WebElement pageTextElement = driver.findElement(By.xpath("//div[starts-with(@class,'header__content')]/h1"));
		String pageText = pageTextElement.getText();
		System.out.println("Header Text: " + pageText);
		Assert.assertEquals(pageText, "Wrong text");
		//Assert.assertEquals(pageText, "Change your password");
	}
	
	@AfterClass
	public void afterTest() throws InterruptedException {
		System.out.println("Closing the browser ");
		Thread.sleep(2000);
		driver.quit();
	}
}
