package ParallelWebdriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ThreadLocalDemo {
	WebDriver driver;
    @Test
    public void testMethod1() {
    	String url = "https://rahulshettyacademy.com/locatorspractice/";
    	driver=invokeBrowser(url);

		WebElement userName = driver.findElement(By.xpath("//input[@id='inputUsername']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='inputPassword']"));
		userName.sendKeys("Jesus");
		password.sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
	
		WebElement textElement = new WebDriverWait(driver,Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='login-container']/h1")));
		
		String textExp = "Welcome to Rahul Shetty Academy";
		String actText=textElement.getText();
		Assert.assertEquals(textExp, actText);
    }
 
    @Test (enabled=true)
    public void testMethod2() {
        invokeBrowser("http://www.facebook.com");
 
    }
 
    private WebDriver invokeBrowser(String url) {
        System.out.println("Thread id = " + Thread.currentThread().getId());
        System.out.println("Hashcode of webDriver instance = " + LocalDriverManager.getDriver().hashCode());
        LocalDriverManager.getDriver().get(url);
        return  LocalDriverManager.getDriver(); 
    }
}