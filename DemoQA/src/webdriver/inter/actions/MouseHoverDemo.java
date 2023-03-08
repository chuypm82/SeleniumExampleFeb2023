package webdriver.inter.actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverDemo {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		//Creating webDriver instance
		WebDriver driver= new ChromeDriver();
		
		String url="https://demoqa.com/menu/";
		driver.get(url);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Actions actions= new Actions(driver);
		
		WebElement menuOption2 = driver.findElement(By.xpath("//ul[@id='nav']/li[2]"));
		WebElement subOption = driver.findElement(By.xpath("//*[contains(text(),'SUB')]"));	
		WebElement subSubOption = driver.findElement(By.xpath("//*[text()='Sub Sub Item 2']"));		
				
		actions.moveToElement(menuOption2).moveToElement(subOption).moveToElement(subSubOption).click().perform();
		
		System.out.println("Mouse hover over is completed");
					
		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise");

	}

}
