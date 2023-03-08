package webdriver.advance.tips;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptCredentials {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		//WebDriverManager.firefoxdriver().setup();
		// Creating webDriver instance
		WebDriver driver = new ChromeDriver();

		String url = "https://demo.guru99.com/V4/";
		driver.get(url);
		driver.manage().window().maximize();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement button = driver.findElement(By.name("btnLogin"));

		// Login to Guru99
		driver.findElement(By.name("uid")).sendKeys("mngr34926");
		driver.findElement(By.name("password")).sendKeys("amUpenu");

		//Perform Click on LOGIN button using JavascriptExecutor		
        js.executeScript("arguments[0].click();", button);
		//button.click();
        
        //To generate Alert window using JavascriptExecutor. Display the alert message 			
        //js.executeScript("alert('Welcome to Guru99');");  

		Thread.sleep(1000);
		// driver.quit();
		System.out.println("End of Exercise - only one window closed");

	}

}
