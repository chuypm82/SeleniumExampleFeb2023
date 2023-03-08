package webdriver.commands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverCommands2 {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");
		String driverPath = "C:\\Users\\625337\\OneDrive - BOOZ ALLEN HAMILTON\\Documents\\Personal\\Trainings\\Selenium\\Drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);

		//Creating webDriver instance
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://demoqa.com/browser-windows/");
		
		driver.findElement(By.xpath("//button[@id='tabButton']")).click();
		
		Thread.sleep(2000);
		driver.close();
		System.out.println("End of Exercise - only one window closed");

	}

}
