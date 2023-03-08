package webdriver.inter.actions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RobotKeyboardDemo3 {

	public static void main(String[] args) throws InterruptedException, AWTException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		// Creating webDriver instance
		WebDriver driver = new ChromeDriver();

		String url = "https://www.adobe.com/acrobat/online/pdf-to-jpg.html";
		driver.get(url);

		driver.manage().window().maximize();

		// This will click on Browse button
		WebElement webElement = driver.findElement(By.xpath("//button[starts-with(@id,'life')]"));
		// click Browse button
		webElement.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		// Create object of Robot class
		Robot robot = new Robot();
		// Code to Enter D1.txt
		// Press Shify key
		robot.keyPress(KeyEvent.VK_SHIFT);
		// Press d , it gets typed as upper case D as Shift key is pressed
		robot.keyPress(KeyEvent.VK_D);
		// Release SHIFT key to release upper case effect
		robot.keyRelease(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_O);
		robot.keyPress(KeyEvent.VK_C);
		robot.keyPress(KeyEvent.VK_PERIOD);
		robot.keyPress(KeyEvent.VK_P);
		robot.keyPress(KeyEvent.VK_D);
		robot.keyPress(KeyEvent.VK_F);
		Thread.sleep(2000);

		// Press ENTER to close the popup
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);

		// This is just a verification part, accept alert
		webElement = driver.findElement(By.xpath("//button[starts-with(@*,'convert')]"));
		webElement.click();
		Thread.sleep(4000);

		WebElement resultText = driver.findElement(By.xpath("//h1"));
		String strText = resultText.getText();
		System.out.println("Result: " + strText);

		assertEquals(strText, "Your file is ready");
		driver.quit();

		/*
		 * 
		 * //This is just a verification part, accept alert webElement =
		 * driver.findElement(By.id("uploadButton"));
		 * 
		 * webElement.click(); WebDriverWait wait = new WebDriverWait(driver, 10); Alert
		 * myAlert = wait.until(ExpectedConditions.alertIsPresent()); //Accept the Alert
		 * myAlert.accept();
		 * 
		 */

		// driver.quit();
		System.out.println("End of Exercise");

	}

}
