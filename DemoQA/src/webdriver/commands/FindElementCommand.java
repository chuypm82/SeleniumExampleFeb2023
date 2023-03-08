package webdriver.commands;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementCommand {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		//Creating webDriver instance
		WebDriver driver= new ChromeDriver();
		
		String url="https://demoqa.com/text-box/";
		driver.get(url);
		
		List<WebElement> allInputElements =driver.findElements(By.xpath("//*[name()='input']"));
		
		if(allInputElements.size()!=0) {
			System.out.println(allInputElements.size() + " Elements found by Tagname as input \n");
			for(WebElement inputElement : allInputElements) {
				System.out.println(inputElement.getAttribute("id"));
			}			
		}
		
		WebElement submitButton = driver.findElement(By.id("submit"));
		submitButton.submit();
		if(submitButton!= null) {
			System.out.println("Element found by ID");
		}
		
		WebElement submitButton2 = driver.findElement(By.className("btn-primary"));
		if(submitButton2!= null) {
			System.out.println("Element found by class name");
		}
		
				
		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise - WebElemetns and list of WebElemetns");


	}

}
