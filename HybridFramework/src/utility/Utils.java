package utility;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

	public static WebDriver driver = null;

	public static WebDriver openBrowser(int iTestCaseRow) throws Exception {

		String sBrowserName;
		try {

			sBrowserName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Browser);
			Log.info("Opening Browser");

			if (sBrowserName.equals("Chrome")) {
				driver = new ChromeDriver();
				Log.info("Chrome browser started");
			} else if (sBrowserName.equals("Edge")) {
				// You may need to change the code here to start Edge Driver
				driver = new EdgeDriver();
				Log.info("Edge browser started");
			} else if (sBrowserName.equals("Mozilla")) {
				// If value of the parameter is Mozilla, this will execute
				driver = new FirefoxDriver();
				Log.info("Mozilla browser started");
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			Log.info("Implicit wait applied on the driver for 5 seconds");
			driver.get(Constant.URL);
			Log.info("Web application launched successfully");

		} catch (Exception e) {
			Log.error("Class Utils | Method OpenBrowser | Exception desc : " + e.getMessage());
		}
		return driver;
	}

	public static String getTestCaseName(String sTestCase) throws Exception {

		String value = sTestCase;
		// automationFramework.UDF_TC@2550036c
		try {
			int posi = value.indexOf("@");
			value = value.substring(0, posi);
			posi = value.lastIndexOf(".");
			value = value.substring(posi + 1);
			return value;
		} catch (Exception e) {
			Log.error("Class Utils | Method getTestCaseName | Exception desc : " + e.getMessage());
			throw (e);
		}
	}

	public static void mouseHoverAction(WebElement mainElement, WebElement subElement, String subElementString)
			throws InterruptedException {

		try {
			Actions action = new Actions(driver);
			action.moveToElement(mainElement).perform();
			action.moveToElement(subElement);
			action.click().perform();
		} catch (Exception e) {
			Log.error("Class Utils | Method mouseHoverAction | Exception desc : " + e.getMessage());
			throw (e);
		}
	}

	public static void waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void waitForVisibleElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitForNotVisibleElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public static void takeScreenshot(WebDriver driver, String sTestCaseName) throws Exception {
		try {

			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(Constant.Path_ScreenShot + sTestCaseName + ".png"));

		} catch (Exception e) {
			Log.error("Class Utils | Method takeScreenshot | Exception occured while capturing ScreenShot : "
					+ e.getMessage());
			throw new Exception();
		}
	}
}