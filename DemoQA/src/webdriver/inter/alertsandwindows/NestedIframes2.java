package webdriver.inter.alertsandwindows;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedIframes2 {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		//Creating webDriver instance
		WebDriver driver= new ChromeDriver();
		
		String url="https://demoqa.com/nestedframes";
		driver.get(url);
		
		//Find the total number of iframes on the page
        int totalIFramesOnPage=driver.findElements(By.tagName("iframe")).size();
        
        //Print the total iframes on page
        System.out.println("Total iframes on Page:"+totalIFramesOnPage);
        
        //switch to first frame using index=0
        driver.switchTo().frame(0);
				
		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise - only one window closed");

	}

}
