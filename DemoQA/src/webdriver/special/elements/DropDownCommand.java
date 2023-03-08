package webdriver.special.elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownCommand {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		//Creating webDriver instance
		WebDriver driver= new ChromeDriver();
		
		//driver.manage().window().maximize();
		
		String url="https://demoqa.com/select-menu";
		driver.get(url);
		
		Select se = new Select(driver.findElement(By.xpath("//select[@id='oldSelectMenu']")));
		
		se.selectByIndex(3);
		Thread.sleep(1000);
		se.selectByValue("1");
		Thread.sleep(1000);
		se.selectByVisibleText("Magenta");
		
		WebElement firstOption =  se.getFirstSelectedOption();
		System.out.println(" The first selected options was: " +firstOption.getText());
		
		List<WebElement> allOptions = se.getAllSelectedOptions();
		
		System.out.println("The number of objects select is: " + allOptions.size());
		
		for(WebElement option : allOptions) {
			System.out.println(option.getText());		
		}
	
		
		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise - only one window closed");
	}

}
