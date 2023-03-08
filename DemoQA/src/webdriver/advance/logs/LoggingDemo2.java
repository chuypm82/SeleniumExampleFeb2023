package webdriver.advance.logs;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoggingDemo2 {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");
		
		String path= "properties/log4j.properties";
		PropertyConfigurator.configure(path);

		//Creating webDriver instance
		Logger log = Logger.getLogger(LoggingDemo2.class.getName());
		WebDriver driver= new ChromeDriver();
		
		String url="https://healthunify.com/bmicalculator/";
		driver.get(url);		
		log.debug("Opening website");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.xpath("//input[@name='wg']")).sendKeys("87");
		log.debug("entering weight");
		
        log.debug("selecting kilograms");
        driver.findElement(By.name("opt1")).sendKeys("kilograms");
        log.debug("selecting height in feet");
        driver.findElement(By.name("opt2")).sendKeys("5");
        log.debug("selecting height in inchs");
        driver.findElement(By.name("opt3")).sendKeys("10");
        log.debug("Clicking on calculate");
        driver.findElement(By.name("cc")).click();

		 log.debug("Getting SIUnit value");
        String SIUnit = driver.findElement(By.name("si")).getAttribute("value");
        log.debug("Getting USUnit value");
        String USUnit = driver.findElement(By.name("us")).getAttribute("value");
        log.debug("Getting UKUnit value");
        String UKUnit = driver.findElement(By.name("uk")).getAttribute("value");
        log.debug("Getting overall description");
        String note = driver.findElement(By.name("desc")).getAttribute("value");
     
        System.out.println("SIUnit = " + SIUnit);
        System.out.println("USUnit = " + USUnit);
        System.out.println("UKUnit = " + UKUnit);
        System.out.println("note = " + note); 

				
		Thread.sleep(1000);
		driver.quit();	
		System.out.println("End of Exercise - only one window closed");

	}

}
