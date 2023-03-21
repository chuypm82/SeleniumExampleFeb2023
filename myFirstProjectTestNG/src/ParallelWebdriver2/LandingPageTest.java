package ParallelWebdriver2;

import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class LandingPageTest extends SelTestCase{

	@Test(groups = {"SMOKE_TEST"})
	public void test() throws Exception {
		getDriver().get("https://www.google.com/?hl=en");
		getDriver().findElement(By.name("q")).sendKeys("test1");
		Thread.sleep(2000);
		printer();
	}

	@Test(groups = {"SMOKE_TEST"})
	public void test1() throws Exception {
		getDriver().get("https://www.google.com/?hl=en");
		getDriver().findElement(By.name("q")).sendKeys("test2");
		Thread.sleep(2000);
		printer();
	}

	@Test(groups = {"SMOKE_TEST"})
	public void test2() throws Exception {
		getDriver().get("https://www.google.com/?hl=en");
		getDriver().findElement(By.name("q")).sendKeys("test3");
		Thread.sleep(2000);
		printer();
	}

	@Test(groups = {"SMOKE_TEST"})
	public void test3() throws Exception {
		getDriver().get("https://www.google.com/?hl=en");
		getDriver().findElement(By.name("q")).sendKeys("test4");
		Thread.sleep(2000);
		printer();
	}
	
	private void printer() {
	    ITestResult result = Reporter.getCurrentTestResult();
	    String method = result.getMethod().getMethodName();
	    System.err.println(method + "() is using WebDriver instance " + getDriver().hashCode());
	  }
}
