package webdriver.advance.screenshots;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SSListener {
	
	public WebDriver driver;

	@Test // Failed Test
	public void OpenBrowser() throws InterruptedException, IOException {

		// Creating webDriver instance
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);

		String url = "https://rahulshettyacademy.com/locatorspractice/";
		driver.get(url);
		
		WebElement userName = driver.findElement(By.xpath("//input[@id='inputUsername']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='inputPassword']"));
		userName.sendKeys("Jesus");
		password.sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
	
		WebElement textElement = new WebDriverWait(driver,Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='login-container']/h1")));
		
		String textExp = "Welcome to Rahul Shetty Academy";
		String actText=textElement.getText();
		Assert.assertEquals(textExp, actText);

		Thread.sleep(1000);
		driver.quit();
	}
	
	public String capture(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source= ts.getScreenshotAs(OutputType.FILE); //this takes screenshot
		//store screenshot
		String filePath="reports/"+testCaseName+".png";
		File dest= new File(filePath);
		String errflpath = dest.getAbsolutePath();
		FileUtils.copyFile(source, dest);
		return errflpath;
	}

}
