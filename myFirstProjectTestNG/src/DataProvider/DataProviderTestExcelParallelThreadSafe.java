package DataProvider;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import utility.ExcelUtils;

public class DataProviderTestExcelParallelThreadSafe {
	private static WebDriver driver;
	private static ThreadLocal<WebDriver> threadLocalDriver;

	@BeforeMethod
	public void beforeMethod() throws Exception {
		threadLocalDriver = new ThreadLocal<>();
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver= new ChromeDriver(options);
		threadLocalDriver.set(driver);
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getDriver().get("https://rahulshettyacademy.com/locatorspractice/");
	}
	
    //get thread-safe driver
    public static WebDriver getDriver(){
        return threadLocalDriver.get();
    }

	// Here we are calling the Data Provider object with its Name
	
	@Test(dataProvider = "Authentication", threadPoolSize=2, timeOut=1000)
	public void test(String sUsername, String sPassword) throws InterruptedException {
		System.out.println("Thread ID Is : " + Thread.currentThread().getId());
		WebElement userName = getDriver().findElement(By.xpath("//input[@id='inputUsername']"));
		WebElement password = getDriver().findElement(By.xpath("//input[@name='inputPassword']"));
		userName.sendKeys(sUsername);
		password.sendKeys(sPassword);
		getDriver().findElement(By.xpath("//button[@class='submit signInBtn']")).click();
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(1000);
		getDriver().close();
		threadLocalDriver.remove();
	}

	@DataProvider(name = "Authentication", parallel=true)
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
