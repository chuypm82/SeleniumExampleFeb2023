package ParallelWebdriverListenerSimpleWorksWell;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class LandingPageTest extends SelTestCase{

	@Test(groups = {"SMOKE_TEST"})
	public void test() throws Exception {
		getDriver().get("https://www.google.com/?hl=en");
		getDriver().findElement(By.name("q")).sendKeys("test1");
		printer();
		Thread.sleep(2000);
	}

	@Test(groups = {"SMOKE_TEST"})
	public void test1() throws Exception {
		getDriver().get("https://www.google.com/?hl=en");
		getDriver().findElement(By.name("q")).sendKeys("test2");
		printer();
		Thread.sleep(2000);
	}
	
	private void printer() throws IOException {
	    ITestResult result = Reporter.getCurrentTestResult();
	    String method = result.getMethod().getMethodName();
	    System.out.println(method + "() is using WebDriver instance " + getDriver().hashCode());
	  }
	
	public String getScreenshot(String testCaseName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) getDriver();
		File source = ts.getScreenshotAs(OutputType.FILE); // this takes screenshot
		// store screenshot
		File file = new File(System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
	}
}
