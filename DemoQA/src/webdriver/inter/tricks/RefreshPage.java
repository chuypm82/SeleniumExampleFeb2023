package webdriver.inter.tricks;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RefreshPage {

	public static void main(String[] args) throws InterruptedException, IOException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		// Creating webDriver instance
		WebDriver driver = new ChromeDriver();

		String url = "https://rahulshettyacademy.com/locatorspractice/";
		driver.get(url);		
		Thread.sleep(1000);
		
		driver.navigate().refresh();		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@id='inputUsername']")).sendKeys(Keys.F5);		
		Thread.sleep(1000);
		
		driver.get(driver.getCurrentUrl());
		Thread.sleep(1000);
		
		driver.navigate().to(url);		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@id='inputUsername']")).sendKeys("\uE035");		
		Thread.sleep(1000);

		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise - only one window closed");

	}

}
