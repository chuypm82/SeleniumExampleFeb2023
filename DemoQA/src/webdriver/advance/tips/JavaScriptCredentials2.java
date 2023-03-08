package webdriver.advance.tips;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptCredentials2 {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		//WebDriverManager.firefoxdriver().setup();
		// Creating webDriver instance
		WebDriver driver = new ChromeDriver();

		String url = "https://demo.guru99.com/V4/";
		driver.get(url);
		driver.manage().window().maximize();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		//Fetching the Domain Name of the site. Tostring() change object to name.		
        String DomainName = js.executeScript("return document.domain;").toString();			
        System.out.println("Domain name of the site = "+DomainName);	
        
      //Fetching the URL of the site. Tostring() change object to name		
        String url2 = js.executeScript("return document.URL;").toString();			
        System.out.println("URL of the site = "+url2);	
        
      //Method document.title fetch the Title name of the site. Tostring() change object to name		
        String TitleName = js.executeScript("return document.title;").toString();			
        System.out.println("Title of the page = "+TitleName);
        
      //Navigate to new Page i.e to generate access page. (launch new url)		
        js.executeScript("window.location = 'https://demo.guru99.com/'");

		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise - only one window closed");

	}

}
