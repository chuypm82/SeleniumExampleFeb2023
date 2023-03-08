package webdriver.inter.alertsandwindows;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiplechildWindows {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
				System.out.println("Selenium WebDriver Browser Command - Practice Alerts and Windows");

				// Creating webDriver instance
				WebDriver driver = new ChromeDriver();

				String url = "https://demoqa.com/browser-windows";
				driver.get(url);

				// Open new window by clicking the button
				driver.findElement(By.xpath("//button[@id='windowButton']")).click();
				driver.findElement(By.xpath("//button[@id='messageWindowButton']")).click();
				
				String mainWindow= driver.getWindowHandle();
				System.out.println("Main window handle is: " +mainWindow);
				
				Set<String> s1= driver.getWindowHandles();
				System.out.println("Child Window handle is: " +s1);
				Iterator<String> i1= s1.iterator();
				
				while(i1.hasNext()) {
					String childWindow=i1.next();
					if(!mainWindow.equals(childWindow)) {
						driver.switchTo().window(childWindow);
						Thread.sleep(1000);
						driver.close();				
						System.out.println("Child Window closed");
					}
				}

				Thread.sleep(1000);
				driver.quit();
				System.out.println("End of Exercise");
	}

}
