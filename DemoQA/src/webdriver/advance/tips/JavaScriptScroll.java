package webdriver.advance.tips;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class JavaScriptScroll {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		//Creating webDriver instance
		WebDriver driver= new ChromeDriver();
		
		String url="https://rahulshettyacademy.com/AutomationPractice/";
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(1000);
					
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		js.executeScript("document.getElementById('mousehover').scrollIntoView(true);");
		
		//div[@class='tableFixHead']/table
		
		Thread.sleep(3000);
		driver.quit();
		System.out.println("End of Exercise - only one window closed");

	}

}
