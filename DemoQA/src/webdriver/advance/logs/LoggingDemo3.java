package webdriver.advance.logs;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoggingDemo3 {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");
		
		String path= "properties/log4j.properties";
		PropertyConfigurator.configure(path);

		//Creating webDriver instance
		Logger logger = Logger.getLogger("LoggingDemo3");
		
		logger.debug("Debug this path for chrome path issue");
		WebDriver driver= new ChromeDriver();
		logger.info("Chrome driver is up and running");
		
		String url="http://www.dwuser.com/education/content/the-magical-iframe-tag-an-introduction/";
		driver.get(url);		
		logger.warn("Url is not loaded properly");

		//identifying the frame using locator or say using webelement
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='eduFooterWrap']//iframe[1]")));
		logger.error("Frame is not available");
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("SoftwareTestingHelp.com");
		logger.fatal("Message not entered");
				
		Thread.sleep(1000);
		driver.quit();	
		System.out.println("End of Exercise - only one window closed");

	}

}
