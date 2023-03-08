package webdriver.inter.alertsandwindows;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchBacktoParentWindow {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Alerts and Windows");

		// Creating webDriver instance
		WebDriver driver = new ChromeDriver();

		String url = "https://demoqa.com/browser-windows";
		driver.get(url);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Open new window by clicking the button
		//driver.findElement(By.xpath("//button[@id='tabButton']")).click();
		//driver.findElement(By.xpath("//button[@id='windowButton']")).click();
		driver.findElement(By.xpath("//button[@id='messageWindowButton']")).click();
		
		String mainWindow= driver.getWindowHandle();
		System.out.println("Main window handle is: " +mainWindow);
		
		Set<String> s1= driver.getWindowHandles();
		System.out.println("Child Window handle is: " +s1);
		Iterator<String> i1= s1.iterator();
		
		List<String> childWindowList= new ArrayList<String>();
		
		while(i1.hasNext()) {			
			String childWindow=i1.next();
			if(!mainWindow.equals(childWindow)) {
				childWindowList.add(childWindow);			
			}
		}
		System.out.println("Child Window List: " +childWindowList);
		
		String text;
		

		

		driver.switchTo().window(childWindowList.get(0));		
		Thread.sleep(1000);		
		System.out.println("Text on Child Window 1: " + driver.getTitle());
		//text=driver.findElement(By.xpath("//body")).getText();
		//System.out.println("Text on Child Window 1: " + text);
		driver.switchTo().window(mainWindow);
		Thread.sleep(1000);
	

		
		/*
		
		driver.switchTo().window(childWindowList.get(0));		
		Thread.sleep(1000);
		text=driver.findElement(By.xpath("//body")).getText();
		System.out.println("Text on Child Window 1: " + text);
		driver.switchTo().window(mainWindow);
		Thread.sleep(1000);
		
		driver.switchTo().window(childWindowList.get(1));		
		Thread.sleep(1000);
		text=driver.findElement(By.xpath("//h1")).getText();
		System.out.println("Text on Child Window 1: " + text);
		driver.switchTo().window(mainWindow);
		Thread.sleep(1000); 
		 
		driver.switchTo().window(childWindowList.get(1));		
		Thread.sleep(1000);
		text=driver.findElement(By.xpath("//h1")).getText();
		System.out.println("Text on Child Window 2: " + text);
		driver.switchTo().window(mainWindow);
		Thread.sleep(1000);*/
		


		
		//driver.switchTo().window(childWindow);
		//driver.switchTo().window(mainWindow);
		//System.out.println("Switched back to parent window");

		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise");
	}

}
