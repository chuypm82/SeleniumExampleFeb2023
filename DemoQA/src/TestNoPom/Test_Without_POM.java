package TestNoPom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Test_Without_POM {

	public static void main(String[] args) throws InterruptedException {
		
		//Creating webDriver instance
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver= new ChromeDriver(options);
		
		
		String url = "https://rahulshettyacademy.com/client/";
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement userName = driver.findElement(By.xpath("//input[@id='userEmail']"));		
		WebElement password = driver.findElement(By.xpath("//input[@id='userPassword']"));	
		userName.sendKeys("anshika@gmail.com");
		password.sendKeys("Iamking@000");
		
		driver.findElement(By.xpath("//input[@id='login']")).click();

		WebElement logoutButton = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@class='btn btn-custom'])[4]")));
		Thread.sleep(1000);
		logoutButton.click();
		
		Thread.sleep(1000);
		driver.quit();
		System.out.println("Execution Complete on Windows");


	}

}
