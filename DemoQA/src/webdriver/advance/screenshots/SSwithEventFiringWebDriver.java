package webdriver.advance.screenshots;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SSwithEventFiringWebDriver {

	public static void main(String[] args) throws InterruptedException, IOException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		//Creating webDriver instance
		WebDriver driver= new FirefoxDriver();
		EventFiringWebDriver eventDriver= new EventFiringWebDriver(driver);
		
		EventHandler handler= new EventHandler();
		
		String url="https://rahulshettyacademy.com/locatorspractice/";
		//driver.get(url);
		eventDriver.get(url);
		
		WebElement userName = eventDriver.findElement(By.xpath("//input[@id='inputUsername']"));
		WebElement pass = eventDriver.findElement(By.xpath("//input[@name='inputPassword']"));
		
		userName.sendKeys("Jesus");
		pass.sendKeys("rahulshettyacademy");
		
		
		WebElement element = eventDriver.findElement(By.xpath("//button[@class='submit signInBtn']"));
		element.click();
		
		
		
		WebElement strText = new WebDriverWait(eventDriver,Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='login-container']/h1")));
				
		String loginText= strText.getText();
		System.out.println("Found Text: " + loginText);
		System.out.println(loginText);
		
		eventDriver.register(handler);
		
		if(!loginText.equals("Welcome to Rahul Shetty Academ")) {
			System.out.println("Test FAIL, Taking screenshot and saving it as screenshots/screenshotOnFail.png\" ");
			File srcFile = eventDriver.getScreenshotAs(OutputType.FILE);// Takes a partial screenshot
			FileUtils.copyFile(srcFile, new File("screenshots/screenshotOnFail.png"));
		}
			
		eventDriver.unregister(handler);
		
		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise - only one window closed");

	}

}
