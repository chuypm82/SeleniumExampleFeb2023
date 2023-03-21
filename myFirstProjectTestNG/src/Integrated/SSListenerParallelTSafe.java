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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utility.ExcelUtils;

public class SSListenerParallelTSafe {

	public WebDriver driver;

	@Parameters({ "browserName" })
	@BeforeMethod
	public void beforeTest(String browserName) {
		System.out.println("Initilizing the Google Chrome Driver");
		driver = ThreadDriverManager.CreateDriverThread(browserName);
	}

	
	@Test(enabled = true, priority = 1) // Positive Test
	public void OpenBrowserShop() throws InterruptedException {
		String url = "https://rahulshettyacademy.com/client/";
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("Thread id = " + Thread.currentThread().getId());
		System.out.println("Hashcode of webDriver instance = " + ThreadDriverManager.getDriver().hashCode());
		String expectedTitle = "Let's Shop";
		String originalTitle = driver.getTitle();
		System.out.println("Title: " + originalTitle);
		
		WebElement emailElement = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='form-group']/input")));
		
		emailElement.sendKeys("OpenBrowserShop");
		
		Assert.assertEquals(originalTitle, expectedTitle, "Titles of the website do not match");
	}
	
	@Test(enabled = true, priority = 1) // Negative Test
	public void OpenBrowserShopNegatvie() throws InterruptedException {
		String url = "https://rahulshettyacademy.com/client/";
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("Thread id = " + Thread.currentThread().getId());
		System.out.println("Hashcode of webDriver instance = " + ThreadDriverManager.getDriver().hashCode());
		String expectedTitle = "Let's Shop";
		String originalTitle = driver.getTitle();
		System.out.println("Title: " + originalTitle);
		
		WebElement emailElement = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='form-group']/input")));
		
		emailElement.sendKeys("OpenBrowserShopNegatvie");
		
		Assert.assertEquals(originalTitle, expectedTitle, "Titles of the website do not match");
	}
	
	@Test(enabled = false, priority = 1) // Positive Test
	public void OpenBrowser() throws InterruptedException {
		String url = "https://rahulshettyacademy.com/locatorspractice/";
		driver.get(url);
		System.out.println("Thread id = " + Thread.currentThread().getId());
		//System.out.println("Hashcode of webDriver instance = " + ThreadDriverManager.getDriver().hashCode());
		String expectedTitle = "Rahul Shetty Academy - Login page";
		String originalTitle = driver.getTitle();
		Assert.assertEquals(originalTitle, expectedTitle, "Titles of the website do not match");
	}

	@Test(enabled = false, priority = 2) // Negative Test
	public void OpenBrowserNegative() throws InterruptedException {
		String url = "https://rahulshettyacademy.com/locatorspractice/";
		driver.get(url);
		System.out.println("Thread id = " + Thread.currentThread().getId());
		//System.out.println("Hashcode of webDriver instance = " + ThreadDriverManager.getDriver().hashCode());
		String expectedTitle = "Rahul Shetty Academy - Login pag";
		String originalTitle = driver.getTitle();
		Assert.assertEquals(originalTitle, expectedTitle, "Titles of the website do not match");
	}

	@Test(enabled = false, priority = 3) // Positive Test
	public void OpenBrowserSecond() throws InterruptedException {
		String url = "https://rahulshettyacademy.com/locatorspractice/";
		driver.get(url);
		System.out.println("Thread id = " + Thread.currentThread().getId());
		//System.out.println("Hashcode of webDriver instance = " + ThreadDriverManager.getDriver().hashCode());
		String expectedTitle = "Rahul Shetty Academy - Login page";
		String originalTitle = driver.getTitle();
		Assert.assertEquals(originalTitle, expectedTitle, "Titles of the website do not match");
	}

	@Test(enabled = false, priority = 4) // Positive Test
	public void Login() throws InterruptedException {
		String url = "https://rahulshettyacademy.com/locatorspractice/";
		driver.get(url);
		System.out.println("Thread id = " + Thread.currentThread().getId());
		//System.out.println("Hashcode of webDriver instance = " + ThreadDriverManager.getDriver().hashCode());
		WebElement userName = driver.findElement(By.xpath("//input[@id='inputUsername']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='inputPassword']"));
		userName.sendKeys("Jesus");
		password.sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();

		WebElement textElement = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='login-container']/h1")));

		String textExp = "Welcome to Rahul Shetty Academy";
		String actText = textElement.getText();
		Assert.assertEquals(textExp, actText);
	}

	private WebDriver invokeBrowser(String url) {
		System.out.println("Thread id = " + Thread.currentThread().getId());
		System.out.println("Hashcode of webDriver instance = " + ThreadDriverManager.getDriver().hashCode());
		ThreadDriverManager.getDriver().get(url);
		return ThreadDriverManager.getDriver();
	}

	public String capture(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE); // this takes screenshot
		// store screenshot
		String filePath = "reports/" + testCaseName + ".png";
		File dest = new File(filePath);
		String errflpath = dest.getAbsolutePath();
		FileUtils.copyFile(source, dest);
		return errflpath;
	}

	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE); // this takes screenshot
		// store screenshot
		File file = new File(System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
	}

	@Test(enabled = false, priority = 2, dataProvider = "Authentication") // Passed Test
	public void LoginDP(String sUserName, String sPassword) throws InterruptedException, IOException {

		String url = "https://rahulshettyacademy.com/locatorspractice/";
		driver.get(url);

		WebElement userName = driver.findElement(By.xpath("//input[@id='inputUsername']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='inputPassword']"));
		userName.sendKeys(sUserName);
		password.sendKeys(sPassword);
		driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();

		WebElement textElement = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='login-container']/h1")));

		String textExp = "Welcome to Rahul Shetty Academy";
		String actText = textElement.getText();
		Assert.assertEquals(textExp, actText);
	}

	@AfterMethod
	public void afterTest() throws InterruptedException {
		System.out.println("Closing the browser ");
		ThreadDriverManager.removeThread(driver);
	}

	@DataProvider(name = "Authentication")
	public static Object[][] credentials() throws Exception {
		Object[][] testObjArray = ExcelUtils.getTableArray("testData/TestData.xlsx", "Test-Data");
		return (testObjArray);
	}
}
