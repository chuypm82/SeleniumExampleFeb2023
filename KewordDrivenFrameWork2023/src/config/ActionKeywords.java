package config;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import executionEngine.DriverScript;
import utility.Log;

import static executionEngine.DriverScript.OR;

public class ActionKeywords {

	public static WebDriver driver;

	public static void openBrowser(String object, String data) {
		try {
			Log.info("Opening Browser");

			
			if (data.equals("Chrome")) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(options);
				Log.info("Chrome browser started");				
			} else if (data.equals("Edge")) {
				// You may need to change the code here to start Edge Driver
				driver= new EdgeDriver();
				Log.info("Edge browser started");
			} else if (data.equals("Mozilla")) {
				// If value of the parameter is Mozilla, this will execute
				driver = new FirefoxDriver();
				Log.info("Mozilla browser started");
			}

		} catch (Exception e) {
			// This is to print the logs - Method Name & Error description/stack
			Log.info("Not able to open Browser --- " + e.getMessage());
			// Set the value of result variable to false
			DriverScript.bResult = false;
		}
	}

	public static void navigate(String object, String data) {
		try {
			Log.info("Navigating to URL");
			String url = Constants.URL;
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		} catch (Exception e) {
			Log.info("Not able to navigate --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}

	public static void click(String object, String data) {
		try {
			Log.info("Clicking on Webelement " + object);
			driver.findElement(By.xpath(OR.getProperty(object))).click();
		} catch (Exception e) {
			Log.error("Not able to click --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}

	public static void input(String object, String data) {
		try {
			Log.info("Entering the text in " + object);
			WebElement userName = new WebDriverWait(driver, Duration.ofSeconds(5))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty(object))));
			userName.sendKeys(data);
		} catch (Exception e) {
			Log.error("Not able to Enter UserName --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}

	public static void waitFor(String object, String data) throws Exception {
		try {
			Log.info("Wait for 5 seconds");
			Thread.sleep(2000);
		} catch (Exception e) {
			Log.error("Not able to Wait --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}

	public static void assertExample(String object, String data) {
		try {
			Log.info("Assert Example");
			WebElement textElement = new WebDriverWait(driver, Duration.ofSeconds(5))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty(object))));
			String textExp = "Automation Practice";
			String actText = textElement.getText();
			Assert.assertEquals(textExp, actText);
		} catch (Exception e) {
			Log.error("Not able to Assert --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}

	public static void closeBrowser(String object, String data) {
		try {
			Log.info("Closing the browser");
			driver.quit();
		} catch (Exception e) {
			Log.error("Not able to Close the browser --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}

}