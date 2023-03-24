package config;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import static executionEngine.DriverScript.OR;


public class ActionKeywords {

	public static WebDriver driver;

	public static void openBrowser(String object) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
	}

	public static void navigate(String object) {
		String url = Constants.URL;
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	public static void click(String object) {
		driver.findElement(By.xpath(OR.getProperty(object))).click();
	}

	public static void input_Username(String object) {
		WebElement userName = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty(object))));
		userName.sendKeys(Constants.UserName);
	}

	public static void input_Password(String object) {
		WebElement password = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty(object))));		
		password.sendKeys(Constants.Password);
	}

	public static void waitFor(String object) throws Exception {
		Thread.sleep(2000);
	}
	
	public static void assertExample(String object) {
		WebElement textElement = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty(object))));
		String textExp = "Automation Practice";
		String actText = textElement.getText();
		Assert.assertEquals(textExp, actText);
	}
	public static void closeBrowser(String object) {
		driver.quit();
	}

}