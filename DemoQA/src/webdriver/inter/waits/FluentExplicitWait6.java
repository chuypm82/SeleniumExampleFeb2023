package webdriver.inter.waits;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;


public class FluentExplicitWait6 {
	
	public static WebElement applyFluentWaitXpath (WebDriver driver, String xapthStr, int timeout, int polling) {		
		FluentWait wait = new FluentWait(driver);
		wait.withTimeout(Duration.ofSeconds(timeout));
		wait.pollingEvery(Duration.ofMillis(polling));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xapthStr)));		
		WebElement element=driver.findElement(By.xpath(xapthStr));		
		return element;		
	}

	public static void main(String[] args) throws InterruptedException {

		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();// to invoke browser (launch). Chrome driver implementing webDriver
												// interface
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.cssSelector("[id='start'] button")).click();
		
		//WebElement foo = new WebDriverWait(driver,Duration.ofSeconds(5))
			//	.until(dr -> driver.findElement(By.xpath("//button[@id='visibleAfter']")));


		WebElement foo= applyFluentWaitXpath(driver, "//div[@id='finish']/h4",7,250);
		
		//WebElement foo= (WebElement)wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']/h4")));

		System.out.println(foo.isDisplayed());
		System.out.println(foo.getText());

		driver.quit();

	}

}
