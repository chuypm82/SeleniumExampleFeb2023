package webdriver.inter.actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToolTipsDemo {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		// Creating webDriver instance
		WebDriver driver = new ChromeDriver();

		String url = "https://demo.guru99.com/test/social-icon.html";
		driver.get(url);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Actions actions = new Actions(driver);

		// Retrieve WebElement
		WebElement element = driver.findElement(By.xpath("//a[contains(@class,'fa-google')]"));

		// Use action class to mouse hover
		actions.moveToElement(element).perform();


		// To get the tool tip text and assert
		String toolTipText = element.getText();
		System.out.println("toolTipText-->" + toolTipText);

		// Verification if tooltip text is matching expected value
		if (toolTipText.equalsIgnoreCase("Google+")) {
			System.out.println("Pass* : Tooltip matching expected value");
		} else {
			System.out.println("Fail : Tooltip NOT matching expected value");
		}

		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise");

	}

}
