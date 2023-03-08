package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessChromeDemo {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command");
	
		  //create object of chrome options
        ChromeOptions options = new ChromeOptions();
        
        //add the headless argument
        options.addArguments("headless");
        
        //pass the options parameter in the Chrome driver declaration
        WebDriver driver = new ChromeDriver(options);
		
		String url="https://demoqa.com/";
		driver.get(url);
		
		System.out.println("Tittle of the page is -> "+driver.getTitle());
				
		Thread.sleep(1000);
		System.out.println("End of Exercise - only one window closed");

	}

}
