package webdriver.commands;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementwithStrategies {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		//Creating webDriver instance
		WebDriver driver= new ChromeDriver();
		
		String url="https://demoqa.com/automation-practice-form";
		driver.get(url);
		
		driver.manage().window().maximize();
		
		WebElement genderButton = driver.findElement(By.name("gender"));
		//WebElement genderButton = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
		//genderButton.click();
		
		if(genderButton!= null) {
			System.out.println("Element found by Name");
		}
		
		WebElement inputField = driver.findElement(By.tagName("input"));
		
		if(inputField!= null) {
			System.out.println("Element found by tag name");
		}
		
		WebElement inputEmail = driver.findElement(By.cssSelector("#userEmail"));
		//inputEmail.sendKeys("chuypm");		
		//Thread.sleep(1000);
		if(inputEmail!= null) {
			System.out.println("Element found by CSS Selector");
		}
				
		WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
		if(submitButton!= null) {
			System.out.println("Element found by Xpath");
		}		
				
		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise - WebElemetns and list of WebElemetns");

	}

}
