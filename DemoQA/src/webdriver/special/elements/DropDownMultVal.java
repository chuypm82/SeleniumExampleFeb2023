package webdriver.special.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownMultVal {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		//Creating webDriver instance
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		String url="https://demoqa.com/select-menu";
		driver.get(url);
		
		Select se = new Select(driver.findElement(By.xpath("//select[@id='cars']")));
		boolean seStatus=se.isMultiple();
		
		if(seStatus) {
			se.selectByIndex(1);
			Thread.sleep(1000);
			se.selectByValue("audi");
			Thread.sleep(1000);
			se.selectByVisibleText("Volvo");		
		}
		
		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise - only one window closed");

	}

}
