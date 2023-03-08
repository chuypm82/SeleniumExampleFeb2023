package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadlessFirefoxDemo {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command");
	
        //Set Firefox Headless mode as TRUE
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        
        //pass the options parameter in the Firefox driver declaration
        WebDriver driver = new FirefoxDriver(options);
		
		String url="https://demoqa.com/";
		driver.get(url);
		
		System.out.println("Tittle of the page is -> "+driver.getTitle());
				
		Thread.sleep(1000);
		System.out.println("End of Exercise - only one window closed");

	}

}
