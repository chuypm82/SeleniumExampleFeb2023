package practice.java.streams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TableWithJavaStreams3 {

	public static void main(String[] args) throws InterruptedException {
		
		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Table with Java Streams");

		//Creating webDriver instance
		WebDriver driver= new ChromeDriver();
		
		String url="https://rahulshettyacademy.com/seleniumPractise/#/offers";
		driver.get(url);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		//capture WebElements in list
		List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));
		List<String> orignalList = elementsList.stream().map(s->s.getText()).collect(Collectors.toList());
		System.out.println("original list: " + orignalList);
		//capture text of all web elements into new (original) list
		
		//sort on the original list of step 3 -> sorted list
		List<String> sortedList= orignalList.stream().sorted().collect(Collectors.toList());
		System.out.println("Sorted list: " + sortedList);
		
		//compare original vs sorted
		Assert.assertTrue(orignalList.equals(sortedList));
		//if there is a bug the system will not sort it, if we compare it, it will fail.
		
		//Scan the name collumn with getText
		List<String> price;
		do {
			List<WebElement> rows= driver.findElements(By.xpath("//tr/td[1]"));
			price= rows.stream().filter(s->s.getText().contains("Rice")).map(s->getPriceVeggie(s)).collect(Collectors.toList());
			
			//beans in the first page but not rice
			price.forEach(a->System.out.println(a));
			//if price is > than one element is found
			if(price.size()<1) // element is not found
				driver.findElement(By.xpath("//a[@*='Next']")).click();
			
		}while(price.size()<1);
		
		price.forEach(element->System.out.println(element));
		
		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise");

	}
	
	private static  String getPriceVeggie(WebElement s) {
		String priceValue= s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;		
	}

}
