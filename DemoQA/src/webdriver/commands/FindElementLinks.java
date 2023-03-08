package webdriver.commands;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementLinks {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		//Creating webDriver instance
		WebDriver driver= new ChromeDriver();
		
		String url="https://demoqa.com/links";
		driver.get(url);
		
		
		WebElement linkHome = driver.findElement(By.linkText("Home"));
		if(linkHome!= null) {
			System.out.println("Element found by Link");
		}
		
		WebElement partialLink = driver.findElement(By.partialLinkText("Bad"));
		if(partialLink!= null) {
			System.out.println("Element found by Partial Link");
		}
				
		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise - WebElemetns and list of WebElemetns");


	}

}
