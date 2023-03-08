package webdriver.special.elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownMultOptions {

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
			se.selectByValue("audi");
			Thread.sleep(1000);
			se.selectByIndex(1);
			Thread.sleep(1000);			
			se.selectByVisibleText("Volvo");		
		}
		
		List<WebElement> options = se.getOptions();
		
		for(WebElement option : options) {
			System.out.println(option.getText());
			System.out.println(option.getAttribute("value"));			
		}
		
		System.out.println("The Dropdown size is: " + options.size());
		
		WebElement firstOption =  se.getFirstSelectedOption();
		System.out.println(" The first selected options was: " +firstOption.getText());
		
		List<WebElement> allOptions = se.getAllSelectedOptions();
		
		System.out.println("The number of objects select is: " + allOptions.size());
		
		for(WebElement option : allOptions) {
			System.out.println(option.getText());		
		}
		
		
		se.deselectByIndex(0);
		allOptions = se.getAllSelectedOptions();
		System.out.println("The number of objects select is now : " + allOptions.size());
		for(WebElement option : allOptions) {
			System.out.println(option.getText());		
		}
		
		se.deselectByValue("audi");
		allOptions = se.getAllSelectedOptions();
		System.out.println("The number of objects select is now : " + allOptions.size());
		for(WebElement option : allOptions) {
			System.out.println(option.getText());		
		}
		
		se.deselectByVisibleText("Saab");
		allOptions = se.getAllSelectedOptions();
		System.out.println("The number of objects select is now : " + allOptions.size());
		for(WebElement option : allOptions) {
			System.out.println(option.getText());		
		}
		
		if(seStatus) {
			se.selectByValue("audi");
			Thread.sleep(1000);
			se.selectByIndex(1);
			Thread.sleep(1000);			
			se.selectByVisibleText("Volvo");		
		}
		allOptions = se.getAllSelectedOptions();
		System.out.println("The number of objects select is now : " + allOptions.size());
		for(WebElement option : allOptions) {
			System.out.println(option.getText());		
		}
		
		se.deselectAll();
		allOptions = se.getAllSelectedOptions();
		System.out.println("The number of objects select is now : " + allOptions.size());
		

		
		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise - only one window closed");

	}

}
