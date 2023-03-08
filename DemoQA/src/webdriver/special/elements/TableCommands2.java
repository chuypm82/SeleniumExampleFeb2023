package webdriver.special.elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableCommands2 {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		//Creating webDriver instance
		WebDriver driver= new ChromeDriver();
		
		String url="https://rahulshettyacademy.com/AutomationPractice/";
		driver.get(url);
		
		List<WebElement> listRows= driver.findElements(By.xpath("//table[@name='courses']//tr"));
		System.out.println("Number of rows: " + listRows.size());
		List<WebElement> listCol= driver.findElements(By.xpath("//table[@name='courses']//tr/th"));
		System.out.println("Number of rows: " + listCol.size());
		WebElement row2 = driver.findElement(By.xpath("//table[@name='courses']//tr[2]"));
		System.out.println("Values of Row 2: " + row2.getText());
		
		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise - only one window closed");

	}

}
