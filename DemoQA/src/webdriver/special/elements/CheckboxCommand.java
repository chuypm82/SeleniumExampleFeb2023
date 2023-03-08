package webdriver.special.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxCommand {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		//Creating webDriver instance
		WebDriver driver= new ChromeDriver();
		
		//driver.manage().window().maximize();
		
		String url="https://demoqa.com/automation-practice-form";
		driver.get(url);
		
		WebElement checkbox1= driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']"));
		checkbox1.click();
		WebElement checkbox2= driver.findElement(By.xpath("//label[@for='hobbies-checkbox-2']"));
		checkbox2.click();
		
		WebElement checkbox3= driver.findElement(By.cssSelector("label[for='hobbies-checkbox-3']"));
		boolean checkbox3IsSelected =checkbox3.isSelected(); 
		boolean checkbox3IsDisplayed =checkbox3.isDisplayed(); 
		boolean checkbox3IsEnabled =checkbox3.isEnabled(); 
		
		if(!checkbox3IsSelected && checkbox3IsDisplayed && checkbox3IsEnabled ) {
			checkbox3.click();
		}		
		
		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise - only one window closed");
	}

}
