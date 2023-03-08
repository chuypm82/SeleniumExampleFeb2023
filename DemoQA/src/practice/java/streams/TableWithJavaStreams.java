package practice.java.streams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TableWithJavaStreams {

	public static void main(String[] args) throws InterruptedException {
		
		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		//Creating webDriver instance
		WebDriver driver= new ChromeDriver();
		
		String url="https://rahulshettyacademy.com/seleniumPractise/#/offers";
		driver.get(url);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		//capture WebElements in list
		List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));
		List<String> orignalList = elementsList.stream().map(s->s.getText()).collect(Collectors.toList());
		//capture text of all web elements into new (original) list
		
		//sort on the original list of step 3 -> sorted list
		List<String> sortedList= orignalList.stream().sorted().collect(Collectors.toList());
		
		//compare original vs sorted
		Assert.assertTrue(orignalList.equals(sortedList));
		//if there is a bug the system will not sort it, if we compare it, it will fail.
		
		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise - only one window closed");

	}

}
