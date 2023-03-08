package webdriver.advance.tips;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptAsynch {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		//WebDriverManager.firefoxdriver().setup();
		// Creating webDriver instance
		WebDriver driver = new ChromeDriver();

		String url = "https://demo.guru99.com/V4/";
		driver.get(url);
		driver.manage().window().maximize();

		 //Set the Script Timeout to 20 seconds		
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);			
           
        //Declare and set the start time		
        long start_time = System.currentTimeMillis();			
                 
      //Creating the JavascriptExecutor interface object by Type casting		
        JavascriptExecutor js = (JavascriptExecutor)driver;	
        //Call executeAsyncScript() method to wait for 5 seconds		
        js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");			
        		
       //Get the difference (currentTime - startTime)  of times.		
       System.out.println("Passed time: " + (System.currentTimeMillis() - start_time));					

		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise - only one window closed");

	}

}
