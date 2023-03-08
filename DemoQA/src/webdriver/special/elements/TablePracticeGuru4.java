package webdriver.special.elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TablePracticeGuru4 {

	public static void main(String[] args) throws InterruptedException {
		
		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		//Creating webDriver instance
		WebDriver driver= new ChromeDriver();
		
		String url="https://demo.guru99.com/test/table.html";
		driver.get(url);
		
		//Get all the values of a dynamic table
		//locate table
		WebElement myTable = driver.findElement(By.xpath("//body/table"));
		//locate rows of the table
		List<WebElement> rowsTable= myTable.findElements(By.tagName("tr"));
		//to calculate rows in a table
		int rowsCount=rowsTable.size();
		for(int row=0; row<rowsCount; row++) {
			//to locate columns(cells) of the specific row
			List<WebElement> columnsRow = rowsTable.get(row).findElements(By.tagName("td"));
			//to calculate number of columns in that specific row
			int columnsCount= columnsRow.size();
			System.out.println("*****ITERATE ROWS***** Number of cells in Row " + row + " are: " + columnsCount);
			for(int column=0; column<columnsCount; column++) {
				//To retrieve text from that specific text
				String celText=columnsRow.get(column).getText();
				System.out.println("*****ITERATE Columns***** Cel Value of row number " + row + " and column number " + column + " is: " + celText);
			}
		}
					
		Thread.sleep(1000);
		//driver.quit();
		System.out.println("End of Exercise - only one window closed");

	}

}
