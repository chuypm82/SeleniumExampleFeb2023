package Keywords.Defined;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Keywords extends Common {

	public void enter_URL(WebDriver driver, String TestData) throws IOException {
		driver.get(TestData);
	}
	
	public String get_currentURL(WebDriver driver) {
		String URL = driver.getCurrentUrl();
		System.out.println("print URL " + URL);
		return URL;
	}

	public void type(WebDriver driver, String ObjectName, String locatorType, String testdata) throws IOException {
		driver.findElement(getObject(ObjectName, locatorType)).sendKeys(testdata);
		// driver.findElement(By.xpath("//")).sendKeys(testdata);
	}
	
	public void click(WebDriver driver, String ObjectName, String locatorType) throws IOException {
		driver.findElement(getObject(ObjectName, locatorType)).click();
	}
	
	public void implicitWait(WebDriver driver, String TestData) throws IOException {
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeSec(TestData)));
	}

	public void explicitWait(WebDriver driver, String TestData, String ObjectName, String locatorType) throws IOException {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeSec(TestData)));	
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(getObject(ObjectName, locatorType))));
	}
	
	public void sleep(String TestData) throws IOException, InterruptedException {
		Thread.sleep(getMiliSec(TestData));
}
}
