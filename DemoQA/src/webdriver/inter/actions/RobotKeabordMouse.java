package webdriver.inter.actions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RobotKeabordMouse {

	public void seleniumwithjava() throws AWTException, InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		// Creating webDriver instance
		WebDriver driver = new ChromeDriver();

		String url = "https://www.tinymce.com";
		driver.get(url);

		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		WebElement element= driver.findElement(By.xpath("//iframe[contains(@id,'tiny')]"));
		driver.switchTo().frame(element);

		driver.findElement(By.xpath("//body[contains(@id,'tiny')]")).click();
		Thread.sleep(1000);

		Robot r = new Robot();
		String text = "Welcome to the world of automation.";
		StringSelection stringSelection = new StringSelection(text);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, stringSelection);

		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_DELETE);
		r.keyRelease(KeyEvent.VK_DELETE);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);		
		Thread.sleep(1000);
		
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		driver.switchTo().defaultContent(); // go back to the default content
		driver.findElement(By.xpath("//button[contains(@*,'Bold')]")).click();
		Thread.sleep(1000);
		
		int x = 1200;
		int y = 600;
		r.mouseMove(x, y);
		// Clicks Left mouse button
		r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		System.out.println("Browse button clicked");	

		Thread.sleep(2000);
		driver.quit();
		System.out.println("End of Exercise");

	}

	public static void main(String[] args) throws InterruptedException, AWTException {

		RobotKeabordMouse j1 = new RobotKeabordMouse();
		j1.seleniumwithjava();

	}

}
