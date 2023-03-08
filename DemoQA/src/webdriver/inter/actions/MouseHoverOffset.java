package webdriver.inter.actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverOffset {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		//Creating webDriver instance
		WebDriver driver= new ChromeDriver();
		
		String url="https://demoqa.com/slider/";
		driver.get(url);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Actions actions= new Actions(driver);
		
		WebElement slider = driver.findElement(By.xpath("//*[contains(@type,'range')]"));
		
		int xOffset= slider.getLocation().getX();
		int yOffset= slider.getLocation().getY();
		System.out.println("xOffset--->"+xOffset+" yOffset--->"+ yOffset);
				
		//actions.moveToElement(slider,30,0).perform();
		actions.moveToElement(slider, 100, 0).click().perform();
		
		xOffset= slider.getLocation().getX();
		yOffset= slider.getLocation().getY();
		System.out.println("xOffset--->"+xOffset+" yOffset--->"+ yOffset);
		
		System.out.println("Moved Slider in horizontal direction");
				
		Thread.sleep(3000);
		driver.quit();
		System.out.println("End of Exercise");

	}

}
