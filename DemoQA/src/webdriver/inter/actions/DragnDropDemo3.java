package webdriver.inter.actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragnDropDemo3 {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		//Creating webDriver instance
		WebDriver driver= new ChromeDriver();
		
		String url="https://demoqa.com/droppable/";
		driver.get(url);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Actions actions= new Actions(driver);
		
		WebElement from = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement to = driver.findElement(By.xpath("//div[@id='droppable']"));
		
		int xOffset1= from.getLocation().getX();
		int yOffset1= from.getLocation().getY();
		System.out.println("xOffset1--->"+xOffset1+" yOffset1--->"+ yOffset1);
		
		int xOffset2= to.getLocation().getX();
		int yOffset2= to.getLocation().getY();
		System.out.println("xOffset2--->"+xOffset2+" yOffset2--->"+ yOffset2);
		
		int xOffset =(xOffset2-xOffset1)+10;
		int yOffset=(yOffset2-yOffset1)+20;
		System.out.println("xOffset--->"+xOffset+" yOffset--->"+ yOffset);


		actions.dragAndDropBy(from, 170, 0).perform();
		
		WebElement msgElement= driver.findElement(By.xpath("//div[@id='droppable']/p"));
		String textTo= msgElement.getText();
		
		if(textTo.equals("Dropped!"))
			System.out.println("PASS: source is dropped to target as expeted");
		else
			System.out.println("FAIL: source couldn't be dropped to target as expeted");
		
				
		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise");

	}

}
