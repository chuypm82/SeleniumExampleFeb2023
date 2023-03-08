package webdriver.special.elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableCommands {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		//Creating webDriver instance
		WebDriver driver= new ChromeDriver();
		
		String url="https://rahulshettyacademy.com/AutomationPractice/";
		driver.get(url);
		
		List<WebElement> listCol= driver.findElements(By.xpath("//table[@name='courses']//tr/td[3]"));
		int colSize=listCol.size();
				
		String colValue = "Price";
		String sValue= null;
		
		for(int i=1; i<=3; i++) {			
			sValue=driver.findElement(By.xpath("//table[@name='courses']//tr[1]/th["+i+"]")).getText();
			if(sValue.equalsIgnoreCase(colValue)) {
				
				for(int j=2;j<=colSize+1;j++) {
					String sRowValue=driver.findElement(By.xpath("//table[@name='courses']//tr["+j+"]/td["+i+"]")).getText();
					System.out.println(sRowValue);					
				}
			}			
		}					
		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise - only one window closed");

	}

}
