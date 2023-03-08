package webdriver.inter.actions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RobotKeyboardDemo {

	public static void main(String[] args) throws InterruptedException, AWTException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		// Creating webDriver instance
		WebDriver driver = new ChromeDriver();

		String url = "https://www.facebook.com/";
		driver.get(url);

		driver.manage().window().maximize();

		// Enter username
		driver.findElement(By.name("email")).sendKeys("Selenium123@gmail.com");

		// create object of Robot class
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_SHIFT);

		// Enter password
		driver.findElement(By.name("pass")).sendKeys("Selenium123");

		// Hit Enter of keyboard using Robot Class
		r.keyPress(KeyEvent.VK_ENTER);

		// Release Enter
		//r.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(3000);
		driver.quit();
		System.out.println("End of Exercise");

	}

}
