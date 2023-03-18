package DataProvider;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;

public class DataProviderTest {
	private static WebDriver driver;

	@DataProvider(name = "Authentication")

	public static Object[][] credentials() {

		// The number of times data is repeated, test will be executed the same no. of
		// times
		// Here it will execute two times
		return new Object[][] { { "Jesus1", "rahulshettyacademy" }, { "Jesus2", "rahulshettyacademy" } };
	}

	// Here we are calling the Data Provider object with its Name

	@Test(dataProvider = "Authentication")

	public void test(String sUsername, String sPassword) throws InterruptedException {

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		WebElement userName = driver.findElement(By.xpath("//input[@id='inputUsername']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='inputPassword']"));
		userName.sendKeys(sUsername);
		password.sendKeys(sPassword);
		driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
		Thread.sleep(1000);
		driver.quit();

	}
}
