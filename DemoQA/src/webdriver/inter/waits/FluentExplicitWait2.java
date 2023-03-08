package webdriver.inter.waits;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class FluentExplicitWait2 {

	public static void main(String[] args) throws InterruptedException {

		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();// to invoke browser (launch). Chrome driver implementing webDriver
												// interface
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.cssSelector("[id='start'] button")).click();

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver) // FluentWait implements Wait interface
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class); // this method is optional ignoring. This mean, if you come
															// across this exception, just ignore them

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver driver) {
				if (driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed()) {// waiting for an element to
					System.out.println("FluentWait found element"); // appear
					return driver.findElement(By.cssSelector("[id='finish'] h4"));
				} else {
					System.out.println("FluentWait Failed");
					return null;
				}
			}
		});

		System.out.println(driver.findElement(By.xpath("//div[@id='finish']/h4")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText());

		driver.quit();

	}

}
