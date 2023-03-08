package webdriver.special.elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableCommands7 {

	public static void main(String[] args) throws InterruptedException {
		
		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		//Creating webDriver instance
		WebDriver driver= new ChromeDriver();
		
		String url="http://demo.guru99.com/test/web-table-element.php";
		driver.get(url);
		
		List <WebElement> col= driver.findElements(By.xpath("//table[@class='dataTable']//tr/th"));
		System.out.println("No. of columns are: " + col.size());
		
		List <WebElement> rows= driver.findElements(By.xpath("//table[@class='dataTable']//tr/td[1]"));
		System.out.println("No. of columns are: " + rows.size());
			
		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise - only one window closed");

	}

}
