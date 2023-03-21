package ParallelWebdriver3;

import java.lang.reflect.Method;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class SelTestCase {

	// protected WebDriver webDriver;
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	@Parameters({ "browserName" })
	@BeforeMethod(alwaysRun = true)
	public void startDriver(Method method, String browserName) throws Exception {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver.set(BrowserSelection.createInstance(browserName));
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
