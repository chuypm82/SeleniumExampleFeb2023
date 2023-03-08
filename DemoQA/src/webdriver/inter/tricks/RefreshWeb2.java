package webdriver.inter.tricks;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RefreshWeb2 {

	public static void main(String[] args) throws InterruptedException, IOException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		// Creating webDriver instance
		WebDriver driver = new ChromeDriver();

		String url = "https://google.com";
		driver.get(url);

		WebElement ele = driver.findElement(By.xpath("//input[@class='gLFyf']"));
		// Refresh the web page
		driver.navigate().refresh();

		try {
			// Pass string using sendkeys to the web element
			ele.sendKeys("Testing String");
		} catch (StaleElementReferenceException e) {
			WebElement elem = driver.findElement(By.xpath("//input[@class='gLFyf']"));
			elem.sendKeys("Testing String from catch block");
			// Fetching the string entered in the search text box
			String str = elem.getAttribute("value");
			System.out.println("The string entered from catch block is - " + str);
		}

		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise - only one window closed");

	}

}
