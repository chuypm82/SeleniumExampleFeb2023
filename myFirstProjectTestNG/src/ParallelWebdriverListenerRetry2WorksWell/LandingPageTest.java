package ParallelWebdriverListenerRetry2WorksWell;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.ExcelUtils;

public class LandingPageTest extends SelTestCase{

	@Test(enabled=true, priority = 1, groups = {"SMOKE_TEST"})
	public void OpenBrowser() throws Exception {
		
		String url = "https://rahulshettyacademy.com/client/";
		getDriver().get(url);
		//getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String expectedTitle = "Let's Shop";
		String originalTitle = getDriver().getTitle();
		System.out.println("Title: " + originalTitle);
		
		WebElement emailElement = new WebDriverWait(getDriver(), Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='form-group']/input")));		
		emailElement.sendKeys("OpenBrowserShop");
		
		Assert.assertEquals(originalTitle, expectedTitle, "Titles of the website do not match");
		Thread.sleep(1000);
	}

	@Test(enabled=true, priority = 2, groups = {"SMOKE_TEST"})
	public void OpenBrowserNegative() throws Exception {
		
		String url = "https://rahulshettyacademy.com/client/";
		getDriver().get(url);
		String expectedTitle = "Let's Shoop";
		String originalTitle = getDriver().getTitle();
		System.out.println("Title: " + originalTitle);
		
		WebElement emailElement = new WebDriverWait(getDriver(), Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='form-group']/input")));		
		emailElement.sendKeys("OpenBrowserShopNegatvie");
		
		Assert.assertEquals(originalTitle, expectedTitle, "Titles of the website do not match");
		Thread.sleep(1000);
	}
	
	@Test(enabled = true, priority = 3, groups = {"SMOKE_TEST"}) // Positive Test
	public void Login() throws InterruptedException {
		String url = "https://rahulshettyacademy.com/client/";
		getDriver().get(url);
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement userName = new WebDriverWait(getDriver(), Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='userEmail']")));		
		WebElement password = new WebDriverWait(getDriver(), Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='userPassword']")));	
		userName.sendKeys("anshika@gmail.com");
		password.sendKeys("Iamking@000");
		/*getDriver().findElement(By.xpath("//input[@id='login']")).click();

		WebElement textElement = new WebDriverWait(getDriver(), Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='left mt-1']/p")));

		String textExp = "Automation Practice";
		String actText = textElement.getText();
		Assert.assertEquals(textExp, actText);*/
	}
	
	private void printer() throws IOException {
	    ITestResult result = Reporter.getCurrentTestResult();
	    String method = result.getMethod().getMethodName();
	    System.out.println(method + "() is using WebDriver instance " + getDriver().hashCode());
	  }
	
	@Test(enabled = true, priority = 3, groups = {"SMOKE_TEST"}, dataProvider="Authentication") // Positive Test
	public void LoginDP(String sUser, String sPass) throws InterruptedException {
		String url = "https://rahulshettyacademy.com/client/";
		getDriver().get(url);
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement userName = new WebDriverWait(getDriver(), Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='userEmail']")));		
		WebElement password = new WebDriverWait(getDriver(), Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='userPassword']")));	
		userName.sendKeys(sUser);
		password.sendKeys(sPass);
		/*getDriver().findElement(By.xpath("//input[@id='login']")).click();

		WebElement textElement = new WebDriverWait(getDriver(), Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='left mt-1']/p")));

		String textExp = "Automation Practice";
		String actText = textElement.getText();
		Assert.assertEquals(textExp, actText);*/
	}
	
	@DataProvider(name = "Authentication", parallel = true)
	public static Object[][] credentials() throws Exception {
		Object[][] testObjArray = ExcelUtils.getTableArray("testData/TestData.xlsx", "Test-Data");
		return (testObjArray);
	}
}
