package webdriver.inter.alertsandwindows;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PromptAlert3 {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Alerts and Windows");

		// Creating webDriver instance
		WebDriver driver = new ChromeDriver();

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
		//Thread.sleep(1000);
		promptAlert.sendKeys("Test User");
		driver.switchTo().alert().sendKeys("Test User");
		//Thread.sleep(2000);
		promptAlert.accept();
		WebElement promptElement =driver.findElement(By.xpath("//*[@id='promptResult']"));
		String promptElementText = promptElement.getText();
		String finalString=promptElementText.split("entered")[1].trim();
		
		System.out.println("Result: " + finalString);
		
		//Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise");
	}

}
