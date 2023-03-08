package webdriver.inter.tricks;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAllURLLinks {

	public static void main(String[] args) throws InterruptedException, IOException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		// Creating webDriver instance
		WebDriver driver = new ChromeDriver();

		String url = "https://demoqa.com/links";
		driver.get(url);

		String link = "";
		List<WebElement> allURLs = driver.findElements(By.tagName("a"));
		System.out.println("Total links on the Wb Page: " + allURLs.size());
		
		for(WebElement e : allURLs) {
			link=e.getAttribute("href");
			System.out.println(link);
		}

		/*// We will iterate through the list and will check the elements in the list.
		Iterator<WebElement> iterator = allURLs.iterator();
		while (iterator.hasNext()) {
			link = iterator.next().getText();
			System.out.println(url);
		}*/

		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise - only one window closed");

	}

}
