package webdriver.inter.alertsandwindows;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PromptAlert {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Alerts and Windows");

		// Creating webDriver instance
		WebDriver driver = new FirefoxDriver();

		String url = "https://demoqa.com/alerts";
		driver.get(url);

		driver.manage().window().maximize();
		// This step will result in an alert on screen
		WebElement element = driver.findElement(By.id("promtButton"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
		Alert promptAlert = driver.switchTo().alert();
		String alertText = promptAlert.getText();
		System.out.println("Alert text is " + alertText);
		// Send some text to the alert
		Thread.sleep(1000);
		promptAlert.sendKeys("Test User");
		driver.switchTo().alert().sendKeys("Test User");
		Thread.sleep(1000);
		promptAlert.accept();

		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise");
	}

}
