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


public class ActionKeywords {

	public static WebDriver driver;

	public static void openBrowser() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
	}

	public static void navigate() {
		String url = Constants.URL;
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	public static void click_MyAccount() {
		//driver.findElement(By.xpath(".//*[@id='account']/a")).click();
	}

	public static void input_Username() {
		WebElement userName = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='userEmail']")));
		userName.sendKeys(Constants.UserName);
	}

	public static void input_Password() {
		WebElement password = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='userPassword']")));		
		password.sendKeys(Constants.Password);
	}

	public static void click_Login() {
		driver.findElement(By.xpath("//input[@id='login']")).click();
	}

	public static void waitFor() throws Exception {
		Thread.sleep(2000);
	}
	
	public static void assertExample() {
		WebElement textElement = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='left mt-1']/p")));
		String textExp = "Automation Practice";
		String actText = textElement.getText();
		Assert.assertEquals(textExp, actText);
	}

	public static void click_Logout() {
		WebElement logoutBtn = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@class='btn btn-custom'])[4]")));
		logoutBtn.click();
	}

	public static void closeBrowser() {
		driver.quit();
	}

}