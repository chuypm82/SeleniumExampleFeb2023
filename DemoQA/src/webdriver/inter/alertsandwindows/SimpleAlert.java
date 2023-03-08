package webdriver.inter.alertsandwindows;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleAlert {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Alerts and Windows");

		// Creating webDriver instance
		WebDriver driver = new ChromeDriver();

		String url = "https://demoqa.com/alerts";
		driver.get(url);

		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@id='alertButton']")).click();
		
		Alert simpleAlert = driver.switchTo().alert();
		Thread.sleep(1000);
		simpleAlert.accept();
		
		//driver.switchTo().alert().
		
		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise");
		
	}

}
