package webdriver.inter.alertsandwindows;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PromptAlert2 {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Alerts and Windows");

		// Creating webDriver instance
		WebDriver driver = new FirefoxDriver();

		String url = "https://demoqa.com/alerts";
		driver.get(url);

		driver.manage().window().maximize();
		WebElement element= driver.findElement(By.xpath("//button[@id='promtButton']"));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
		//JavascriptExecutor driverJS = (JavascriptExecutor)driver;
		//driver.executeScript("arguments[0].click()", element);
		
		Alert promptAlert = driver.switchTo().alert();
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		//Alert promptAlert = wait.until(ExpectedConditions.alertIsPresent());
		
		String alertText= promptAlert.getText();
		System.out.println("Alert text is: " + alertText);
		
		promptAlert.sendKeys("Test User");
		
		Thread.sleep(3000);
		promptAlert.accept();
		
		//driver.switchTo().alert().
		
		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise");
	}

}
