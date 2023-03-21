package Integrated;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utility.ExcelUtils;

public class SSListenerParallelTSafe2 {

	static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	@Parameters({ "browserName" })
	@BeforeMethod
	public void beforeTest(String browserName) {
		System.out.println("Initilizing the Google Chrome Driver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver.set(new ChromeDriver(options));
	}
	
	public static WebDriver getDriver() {
	    return driver.get();
	  }

	@Test(enabled = true, priority = 1) // Positive Test
	public void OpenBrowserShop() throws InterruptedException {
		String url = "https://rahulshettyacademy.com/client/";
		getDriver().get(url);
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("Thread id = " + Thread.currentThread().getId());
		//System.out.println("Hashcode of webDriver instance = " + ThreadDriverManager.getDriver().hashCode());
		String expectedTitle = "Let's Shoop";
		String originalTitle = getDriver().getTitle();
		System.out.println("Title: " + originalTitle);
		
		WebElement emailElement = new WebDriverWait(getDriver(), Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='form-group']/input")));
		
		emailElement.sendKeys("OpenBrowserShop");
		
		Assert.assertEquals(originalTitle, expectedTitle, "Titles of the website do not match");
	}
	
	@Test(enabled = false, priority = 1) // Negative Test
	public void OpenBrowserShopNegatvie() throws InterruptedException {
		String url = "https://rahulshettyacademy.com/client/";
		getDriver().get(url);
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("Thread id = " + Thread.currentThread().getId());
		//System.out.println("Hashcode of webDriver instance = " + ThreadDriverManager.getDriver().hashCode());
		String expectedTitle = "Let's Shop";
		String originalTitle = getDriver().getTitle();
		System.out.println("Title: " + originalTitle);
		
		WebElement emailElement = new WebDriverWait(getDriver(), Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='form-group']/input")));
		
		emailElement.sendKeys("OpenBrowserShopNegatvie");
		
		Assert.assertEquals(originalTitle, expectedTitle, "Titles of the website do not match");
	}
 

	public String capture(String testCaseName, ThreadLocal<WebDriver> tdriver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) tdriver.get();
		File source = ts.getScreenshotAs(OutputType.FILE); // this takes screenshot
		// store screenshot
		String filePath = "reports/" + testCaseName + ".png";
		File dest = new File(filePath);
		String errflpath = dest.getAbsolutePath();
		FileUtils.copyFile(source, dest);
		return errflpath;
	}

	public String getScreenshot(String testCaseName, ThreadLocal<WebDriver> tdriver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) tdriver.get();
		File source = ts.getScreenshotAs(OutputType.FILE); // this takes screenshot
		// store screenshot
		File file = new File(System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
	}

	@AfterMethod
	public void afterTest() throws InterruptedException {
		System.out.println("Closing the browser ");
		Thread.sleep(2000);
		driver.get().quit();
		driver.remove();
	}
}
