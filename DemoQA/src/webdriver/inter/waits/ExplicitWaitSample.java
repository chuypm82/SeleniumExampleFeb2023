package webdriver.inter.waits;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitSample {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();// to invoke browser (launch)
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);// implicit wait
		WebDriverWait w =new WebDriverWait(driver,Duration.ofSeconds(10));
 
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot" };
		Thread.sleep(3000);
		addItemes(driver, itemsNeeded);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		 
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='promoCode']")));
		 
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		 
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
		 
		System.out.println(driver.findElement(By.xpath("//span[@class='promoInfo']")).getText());
		
		driver.quit();


	}
	
	public static void addItemes(WebDriver driver, String[] itemsNeeded) {
		 
		int j = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
 
		for (int i = 0; i < products.size(); i++)// we will add cucumber
		{
 
			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();
 
			List itemsNeededList = Arrays.asList(itemsNeeded);
 
			if (itemsNeededList.contains(formattedName)) {
				// click on add to cart
				// driver.findElements(By.xpath("//button[text()='ADD TO
				// CART']")).get(i).click();//based on text
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();// not based on
																										// text
				j++;
				if (j == itemsNeeded.length)// 3 times
					break;
			}
		}
	}
}



