package webdriver.advance.screenshots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SSListener2 {
	
	public WebDriver driver;

	@Test // Failed Test
	public void OpenBrowser() throws InterruptedException, IOException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		// Creating webDriver instance
		driver = new FirefoxDriver();

		String url = "https://rahulshettyacademy.com/locatorspractice/";
		driver.get(url);

		String loginText = "Welcome to Rahul Shetty Academy";
		System.out.println("Found Text: " + loginText);
		System.out.println(loginText);
		
		if (!loginText.equals("Welcome to Rahul Shetty Academ")) {
			System.out.println("Test FAIL, Taking screenshot and saving it as screenshots/screenshotOnFail.png\" ");
		}
		Assert.assertEquals(loginText, "Welcome to Rahul Shetty Academ");

		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise - only one window closed");
	}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source= ts.getScreenshotAs(OutputType.FILE); //this takes screenshot
		//store screenshot
		File file= new File(System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	}

}
