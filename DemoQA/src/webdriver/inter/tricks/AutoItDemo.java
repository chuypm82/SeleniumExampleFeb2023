package webdriver.inter.tricks;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoItDemo {

	public static void main(String[] args) throws InterruptedException, IOException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		//Creating webDriver instance
		WebDriver driver= new ChromeDriver();
		
		String url="https://www.adobe.com/acrobat/online/pdf-to-jpg.html";
		driver.get(url);
		
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		WebElement element= driver.findElement(By.xpath("//button[starts-with(@id,'life')]"));
		System.out.println(element.getAttribute("id"));
		element.click();
		
		String strPath="C:\\Users\\625337\\OneDrive - BOOZ ALLEN HAMILTON\\Documents\\Personal\\Trainings\\Selenium\\Workspaces\\Feb2023\\DemoQA\\Others\\AutoIT\\ScriptTest1.exe";
		
		Runtime.getRuntime().exec(strPath);
				
		Thread.sleep(7000);
		driver.quit();
		System.out.println("End of Exercise - only one window closed");

	}

}
