package webdriver.special.elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TablePracticeGuru2 {

	public static void main(String[] args) throws InterruptedException {
		
		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		//Creating webDriver instance
		WebDriver driver= new ChromeDriver();
		
		String url="http://demo.guru99.com/test/web-table-element.php";
		driver.get(url);
		
		WebElement baseTable = driver.findElement(By.xpath("//table[@class='dataTable']"));

		WebElement tableRow= baseTable.findElement(By.xpath("//table[@class='dataTable']//tr[3]"));
		WebElement tableRowText= baseTable.findElement(By.xpath("//table[@class='dataTable']//tr[3]/td[1]"));
		
		String rowText= tableRow.getText();
		System.out.println(rowText);
		
		//To get 3rd row's 2nd column date
		
		WebElement cellIneed = baseTable.findElement(By.xpath("//table[@class='dataTable']//tr[3]/td[2]"));
		String valueIneed = cellIneed.getText();
		System.out.println("Cell Value is: " + valueIneed);
					
		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise - only one window closed");

	}

}
