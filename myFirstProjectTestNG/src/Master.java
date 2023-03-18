import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Master {
	WebDriver driver ;
	@Test
	public void f() throws InterruptedException {
	  
	    String baseUrl = "https://rahulshettyacademy.com/locatorspractice/";	      
	         
	        System.out.println("Launching Google Chrome browser"); 
	        driver = new ChromeDriver();
	        driver.get(baseUrl);
	        String testTitle = "Rahul Shetty Academy - Login page";
	        String originalTitle = driver.getTitle();
	        System.out.println(originalTitle);
	        Assert.assertEquals(originalTitle, testTitle);
	        Thread.sleep(1000);
  }
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Starting Test On Chrome Browser - MASTER CLASS");
	}
	
	@AfterMethod
	public void afterMethod() {
		 driver.close();
		System.out.println("Finished Test On Chrome Browser - MASTER CLASS");
	}
}