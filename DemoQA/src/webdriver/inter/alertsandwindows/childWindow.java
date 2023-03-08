package webdriver.inter.alertsandwindows;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class childWindow {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Alerts and Windows");

		// Creating webDriver instance
		WebDriver driver = new ChromeDriver();

		String url = "https://demoqa.com/browser-windows";
		driver.get(url);

		// Open new window by clicking the button
		driver.findElement(By.xpath("//button[@id='windowButton']")).click();

		// Get handles of the windows
		String mainWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		Iterator<String> iterator = allWindowHandles.iterator();

		// Here we will check if child window has other child windows and will fetch the
		// heading of the child window
		while(iterator.hasNext()) {
			String childWindow=iterator.next();
			if(! mainWindowHandle.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
				WebElement text = driver.findElement(By.xpath("//h1"));
				System.out.println("Heading of child window is " + text.getText());
			}
		}
		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise");
	}

}
