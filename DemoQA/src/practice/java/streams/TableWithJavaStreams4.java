package practice.java.streams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TableWithJavaStreams4 {

	public static void main(String[] args) throws InterruptedException {
		
		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Table with Java Streams");

		//Creating webDriver instance
		WebDriver driver= new ChromeDriver();
		
		String url="https://rahulshettyacademy.com/seleniumPractise/#/offers";
		driver.get(url);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Rice");
		List<WebElement> veggies= driver.findElements(By.xpath("//tr/td[1]"));
		//5 results
		List<WebElement> filteredList= veggies.stream().filter(v->v.getText().contains("Rice")).collect(Collectors.toList());
		// 1 result
		//compare lists, if the number of elements is not the same then, this will fail
		Assert.assertEquals(veggies.size(), filteredList.size());
		System.out.println(veggies.size());
		
		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise");

	}
}
