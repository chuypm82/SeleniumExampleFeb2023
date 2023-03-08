package webdriver.advance.tips;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptScrollbyLinesONLYFIREFOX {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		
		// Creating webDriver instance
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();

		String url = "https://rahulshettyacademy.com/AutomationPractice/";
		driver.get(url);
		driver.manage().window().maximize();

		Thread.sleep(1000);
		//Vertical scroll down by 600  pixels	
		JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("document.getElementById('text-8').scrollIntoView(true);");	
        
		WebElement value = (WebElement)js.executeScript(" return document.evaluate( '//a[text()=\"Latest News\"]' ,document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null ).singleNodeValue;");

		//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Only works with FIREFOX 
		int x = 0;

		while((Double) js.executeScript("return document.evaluate( '//a[text()=\"Latest News\"]' ,document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null ).singleNodeValue.getBoundingClientRect().top") > 702 )
		{

			x = x + 2;

			js.executeScript("window.scrollByLines(2)");

			System.out.println("Client top is = " + (Double) js.executeScript("return document.evaluate( '//a[text()=\"Latest News\"]' ,document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null ).singleNodeValue.getBoundingClientRect().top"));			

		}

		System.out.println("Element is visible after  " + x + " scrolls");
		
		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise - only one window closed");

	}

}
