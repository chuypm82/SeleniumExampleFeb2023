package webdriver.inter.alertsandwindows;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchToIframes {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		//Creating webDriver instance
		WebDriver driver= new ChromeDriver();
		
		String url="https://demoqa.com/frames";
		driver.get(url);
		
		driver.switchTo().frame(4);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame1"); // system not finding it with this function
		driver.switchTo().defaultContent();
		WebElement element= driver.findElement(By.xpath("//iframe[@id='frame1']"));
		driver.switchTo().frame(element);
		//System.out.println(element.getText());
		driver.switchTo().defaultContent();
		
				
		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise - only one window closed");

	}

}
