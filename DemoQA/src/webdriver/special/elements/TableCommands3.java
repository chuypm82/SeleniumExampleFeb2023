package webdriver.special.elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableCommands3 {

	public static void main(String[] args) throws InterruptedException {
		
		int rowSize=0;
		int colSize=0;
		

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		//Creating webDriver instance
		WebDriver driver= new ChromeDriver();
		
		String url="https://rahulshettyacademy.com/AutomationPractice/";
		driver.get(url);
		
		WebElement table= driver.findElement(By.xpath("//table[@name='courses']"));
		
		rowSize= table.findElements(By.tagName("tr")).size();
		System.out.println("Row Size: " + rowSize);
		
		colSize= table.findElements(By.tagName("th")).size();
		System.out.println("Row Size: " + colSize);
		
		List<WebElement> row2= table.findElements(By.tagName("tr")).get(9).findElements(By.tagName("td"));
		System.out.println(row2.get(0).getText());
		System.out.println(row2.get(1).getText());
		System.out.println(row2.get(2).getText());
		
		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise - only one window closed");

	}

}
