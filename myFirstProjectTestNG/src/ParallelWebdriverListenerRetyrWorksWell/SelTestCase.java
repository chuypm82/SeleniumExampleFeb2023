package ParallelWebdriverListenerRetyrWorksWell;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SelTestCase {

	// protected WebDriver webDriver;
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	@BeforeMethod(alwaysRun = true)
	public void startDriver(Method method) throws Exception {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver.set(new ChromeDriver(options));
		System.out.println(method.getName() + "() will use WebDriver instance " + driver.get().hashCode());
	}

	@AfterMethod(alwaysRun = true)
	public void stopDriver() {
		driver.get().quit();
		driver.remove();
	}
	public static WebDriver getDriver() {
	    return driver.get();
	  }
}
