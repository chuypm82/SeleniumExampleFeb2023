package webdriver.special.elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableCommands4 {

	public static void main(String[] args) throws InterruptedException {
		
		String colName= "Price";
		int colSize= 0;
		int colNum= 0;

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		//Creating webDriver instance
		WebDriver driver= new ChromeDriver();
		
		String url="https://rahulshettyacademy.com/AutomationPractice/";
		driver.get(url);
		
		WebElement table= driver.findElement(By.xpath("//table[@name='courses']"));
		List<WebElement> colList = table.findElements(By.tagName("th"));
		colSize = colList.size();
		System.out.println("Col Size: " + colSize);
		
		for(WebElement col : colList) {
			colNum++;
			if(col.getText().equalsIgnoreCase(colName)) {
				break;
			}
		}
		System.out.println("Col index is: " + colNum);
		
		List<WebElement> colValues = driver.findElements(By.xpath("//table[@name='courses']//tr/td["+colNum+"]"));
		
		for(WebElement colValue : colValues) {
			System.out.println(colValue.getText());
		}
				
		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise - only one window closed");

	}

}
