package webdriver.inter.waits;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FluentExplicitWait5 {

	public static void main(String[] args) throws InterruptedException {

		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();// to invoke browser (launch). Chrome driver implementing webDriver
												// interface
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.cssSelector("[id='start'] button")).click();
		
		//WebElement foo = new WebDriverWait(driver,Duration.ofSeconds(5))
			//	.until(dr -> driver.findElement(By.xpath("//button[@id='visibleAfter']")));

		FluentWait wait = new FluentWait(driver);
		wait.withTimeout(Duration.ofSeconds(7));
		wait.pollingEvery(Duration.ofMillis(250));
		wait.ignoring(NoSuchElementException.class);
		
		WebElement foo= (WebElement)wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']/h4")));

		System.out.println(foo.isDisplayed());
		System.out.println(foo.getText());

		driver.quit();

	}

}
