package webdriver.commands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementCommand {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\625337\\OneDrive - BOOZ ALLEN HAMILTON\\Documents\\Personal\\Trainings\\Selenium\\Drivers\\chromedriver.exe");
		
		//Creating webDriver instance
		WebDriver driver= new ChromeDriver();
		
		String url="https://rahulshettyacademy.com/angularpractice/";
		driver.get(url);
		
		driver.manage().window().maximize();
		
		
		WebElement uName = driver.findElement(By.xpath("//div/input[@name='name']"));
		WebElement submitBtn= driver.findElement(By.xpath("//input[@type='submit']"));
		WebElement checkBox1 = driver.findElement(By.xpath("//label[@for='exampleCheck1']"));
		
		System.out.println("Result of getText: " +checkBox1.getText());
		System.out.println("Result of tagName: " +checkBox1.getTagName());
		System.out.println("Result of cssValue-Fontsize: " + checkBox1.getCssValue("font-size"));
		System.out.println("Result of Atribute-Class: " + checkBox1.getAttribute("class"));
		System.out.println("Result of getSize: " + checkBox1.getSize());
		System.out.println("Result of getLocation: " + checkBox1.getLocation());
		
		
		boolean statusDisplayed= uName.isDisplayed();
		boolean statusEnabled= uName.isEnabled();
		boolean statusSelected= checkBox1.isSelected();
		
		if(statusEnabled) {
			uName.clear();
			uName.sendKeys("example");
			Thread.sleep(1000);
			uName.clear();
			uName.sendKeys("Jesus");			
		}		
		
		if(!statusSelected)
			checkBox1.click();
		
		Thread.sleep(1000);
			
		//submitBtn.click();
		submitBtn.submit();
			
				
		Thread.sleep(1000);
		driver.quit();
		
		System.out.println("End of Exercise - WebElemt commands");

	}

}
