package webdriver.advance.screenshots;

import java.io.IOException;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
public class ScreenshotPartialpage {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		//Creating webDriver instance
		WebDriver driver= new ChromeDriver();
		
		String url="https://demoqa.com";
		driver.get(url);
		
		//Take the screenshot
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		//Copy the file to a location and use try catch block to handle exception
        try {
            FileUtils.copyFile(screenshotFile, new File("screenshots/screenshot.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
				
		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise - only one window closed");

	}

}
