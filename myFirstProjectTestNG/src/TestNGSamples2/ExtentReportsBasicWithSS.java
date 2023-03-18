package TestNGSamples2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExtentReportsBasicWithSS {
	static ExtentReports report;
	static ExtentTest test;
	static WebDriver driver;

	@BeforeClass
	public static void startTest() {
		report = new ExtentReports(System.getProperty("user.dir") + "\\reports\\ExtentReportResults.html");
		test = report.startTest("ExtentReportsTest");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
	}

	@Test(priority = 0)
	public void Login() throws IOException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		WebElement userName = driver.findElement(By.xpath("//input[@id='inputUsername']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='inputPassword']"));
		userName.sendKeys("Jesus");
		password.sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();

		WebElement strTextElement = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='login-container']/h1")));
		String valText = "Welcome to Rahul Shetty Academ";
		System.out.println("Message: " + strTextElement.getText());

		try {
			Assert.assertEquals(strTextElement.getText(), valText);
			test.log(LogStatus.PASS, "Navigated to the specified URL");
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
			test.log(LogStatus.FAIL, test.addScreenCapture(capture(driver)) + e.getMessage());
		}
	}

	public String capture(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File("ErrImages/" + System.currentTimeMillis() + ".png");
		String errflpath = Dest.getAbsolutePath();
		FileUtils.copyFile(scrFile, Dest);
		return errflpath;
	}

	@AfterClass
	public void afterTest() throws InterruptedException {
		System.out.println("Closing the browser ");
		Thread.sleep(2000);
		driver.quit();
		report.endTest(test);
		report.flush();
	}

}