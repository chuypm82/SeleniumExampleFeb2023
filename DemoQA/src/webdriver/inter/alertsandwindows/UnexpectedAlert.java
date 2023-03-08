package webdriver.inter.alertsandwindows;


import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UnexpectedAlert {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Alerts and Windows");

		// Creating webDriver instance
		WebDriver driver = new ChromeDriver();

		String url = "https://demoqa.com/alerts";
		driver.get(url);

		driver.manage().window().maximize();
		
		try {
			driver.findElement(By.xpath("//button[@id='timerAlertButton']")).click();
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.alertIsPresent());
			
			Alert simpleAlert = driver.switchTo().alert();
			Thread.sleep(1000);
			simpleAlert.accept();
			System.out.println("Unexpected Alert Accepted");
			
		}catch (Exception e) {
			System.out.println("Unexpected Alert not present");
		}
		
		//driver.switchTo().alert().
		
		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise");
		
	}

}
