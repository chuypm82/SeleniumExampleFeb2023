package webdriver.commands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverNavigate {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Commands - Navigation - Practice Exercises #1");

		//Creating webDriver instance
		WebDriver driver= new ChromeDriver();
		
		String url="https://www.rahulshettyacademy.com/AutomationPractice/";
		driver.get(url);
				
		driver.findElement(By.xpath("//button[text()='Home']")).click();
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().forward();
		Thread.sleep(1000);
		driver.navigate().to(url);
		Thread.sleep(1000);
		driver.navigate().refresh();
				
		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise");
	}

}
