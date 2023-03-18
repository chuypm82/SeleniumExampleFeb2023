package DataProvider;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import utility.ExcelUtils;

public class DataProviderTestExcel {
	private static WebDriver driver;

	@BeforeMethod
	public void beforeMethod() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
	}

	// Here we are calling the Data Provider object with its Name
	@Test(dataProvider = "Authentication")
	public void test(String sUsername, String sPassword) throws InterruptedException {
		WebElement userName = driver.findElement(By.xpath("//input[@id='inputUsername']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='inputPassword']"));
		userName.sendKeys(sUsername);
		password.sendKeys(sPassword);
		driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(1000);
		driver.close();
	}

	@DataProvider(name = "Authentication")
	public static Object[][] credentials() throws Exception {
		// The number of times data is repeated, test will be executed the same no. of
		// times
		// Here it will execute two times
		// return new Object[][] { { "Jesus1", "rahulshettyacademy" }, { "Jesus2",
		// "rahulshettyacademy" } };
		Object[][] testObjArray = ExcelUtils.getTableArray("testData/TestData.xlsx", "Test-Data");
		return (testObjArray);
	}
}
