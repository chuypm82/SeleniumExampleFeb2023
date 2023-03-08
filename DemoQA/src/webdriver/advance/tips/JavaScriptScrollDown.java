package webdriver.advance.tips;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptScrollDown {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		//WebDriverManager.firefoxdriver().setup();
		// Creating webDriver instance
		WebDriver driver = new ChromeDriver();

		String url = "http://moneyboats.com/";
		driver.get(url);
		driver.manage().window().maximize();

		Thread.sleep(1000);
		//Vertical scroll down by 600  pixels	
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");	

		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise - only one window closed");

	}

}
