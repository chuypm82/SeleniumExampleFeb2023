package webdriver.inter.alertsandwindows;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedIframes {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		//Creating webDriver instance
		WebDriver driver= new ChromeDriver();
		
		String url="https://demoqa.com/nestedframes";
		driver.get(url);
		
		// By finding all the web elements using iframe tag
		int countIframesInPage = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Number of Frames on a Page:" + countIframesInPage);
		
		WebElement frame1= driver.findElement(By.xpath("//iframe[@id='frame1']"));
		
		driver.switchTo().frame(frame1);
		
		//Locate the Element inside the Frame1
        WebElement frame1Element= driver.findElement(By.tagName("body"));
        
        //Get the text for frame1 element
        String frame1Text=frame1Element.getText();
        System.out.println("Frame1 is :"+frame1Text);
        
        //Number of Frames on a Frame1
        int countIframesInFrame1 =driver.findElements(By.tagName("iframe")).size();
        System.out.println("Number of iFrames inside the Frame1: " + countIframesInFrame1);
        
        //switch to child frame
        driver.switchTo().frame(0);
        
        
        int countIframesInFrame2 =driver.findElements(By.tagName("iframe")).size();
        System.out.println("Number of iFrames inside the Frame2 :" + countIframesInFrame2);
				
		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise - only one window closed");

	}

}
