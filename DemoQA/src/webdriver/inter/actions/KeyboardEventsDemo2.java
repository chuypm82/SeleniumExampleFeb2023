package webdriver.inter.actions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardEventsDemo2 {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		//Creating webDriver instance
		WebDriver driver= new ChromeDriver();
		
		String url="https://demoqa.com/text-box";
		driver.get(url);
		
		driver.manage().window().maximize();
		
		Actions actions= new Actions(driver);
		
		WebElement fullName = driver.findElement(By.xpath("//input[@id='userName']"));
		fullName.sendKeys("Mr.Peter Haynes");
		String press= Keys.chord(Keys.CONTROL,"a");
		fullName.sendKeys(press);
		System.out.println("press value: " + press);
		Thread.sleep(2000);
		
		WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));
		email.sendKeys("PeterHaynes@toolsqa.com");
		
		WebElement currentAddress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
		currentAddress.sendKeys("43 School Lane London EC71 9GO");
				
		actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
		actions.sendKeys(Keys.TAB).perform();
		actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
		
		WebElement permanentAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
		assertEquals(currentAddress.getAttribute("value"),permanentAddress.getAttribute("value"));		
				
		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise");

	}

}
