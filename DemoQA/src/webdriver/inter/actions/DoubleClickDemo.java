package webdriver.inter.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickDemo {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		//Creating webDriver instance
		WebDriver driver= new ChromeDriver();
		
		String url="http://demoqa.com/buttons";
		driver.get(url);
		
		driver.manage().window().maximize();
		
		Actions actions= new Actions(driver);
		
		WebElement btnElement = driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
		
		actions.doubleClick(btnElement).perform();
		System.out.println("Right click Context Menu displayed");	
		
		WebElement msgElement= driver.findElement(By.xpath("//p[@id='doubleClickMessage']"));
		System.out.println(msgElement.getText());
				
		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise");

	}

}
