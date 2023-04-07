package webdriver.inter.actions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RobotMouseDemo {

	public static void main(String[] args) throws InterruptedException, AWTException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		// Creating webDriver instance
		WebDriver driver = new ChromeDriver();

		String url = "https://www.adobe.com/acrobat/online/pdf-to-jpg.html";
		driver.get(url);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// This will click on Browse button
		//WebElement webElement = driver.findElement(By.xpath("//button[starts-with(@id,'life')]"));
		// click Browse button
		//webElement.sendKeys(Keys.ENTER);
		//Thread.sleep(2000);

		// Create object of Robot class
		Robot robot = new Robot();
		Dimension i = driver.manage().window().getSize();
		System.out.println("Dimension x and y :" + i.getWidth() + " " + i.getHeight());
		// 3. Get the height and width of the screen
		int x = 800;
		int y = 600;

		robot.mouseMove(x, y);
		Thread.sleep(1000);
		
		// Clicks Left mouse button
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		System.out.println("Browse button clicked");
		Thread.sleep(1000);
		
		x = 600;
		y = 400;
		//Select any file
		robot.mouseMove(x, y);
		// Clicks Left mouse button
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		System.out.println("File clicked");
		Thread.sleep(1000);
		
		x = 800;
		y = 500;
		//Click on Open button
		robot.mouseMove(x, y);
		// Clicks Left mouse button
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		System.out.println("Open Button clicked");
		Thread.sleep(1000);
		
		//Thread.sleep(2000);
		driver.quit();
		System.out.println("End of Exercise");

	}

}
