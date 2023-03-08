package webdriver.inter.alertsandwindows;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConfirmationAlert {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Alerts and Windows");

		// Creating webDriver instance
		WebDriver driver = new ChromeDriver();

		String url = "https://demoqa.com/alerts";
		driver.get(url);

		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@id='confirmButton']")).click();
		
		Alert confirmAlert = driver.switchTo().alert();
		String alertText= confirmAlert.getText();
		System.out.println("Alert Text is: " + alertText);
		Thread.sleep(1000);
		//confirmAlert.accept();
		confirmAlert.dismiss();
		
		//driver.switchTo().alert().
		
		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise");
		
	}

}
