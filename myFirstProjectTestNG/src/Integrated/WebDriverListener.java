package Integrated;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
 
public class WebDriverListener implements IInvokedMethodListener {
 
  /*  @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            //String browserName = method.getTestMethod().getXmlTest().getLocalParameters().get("browserName");      
    		ChromeOptions options = new ChromeOptions();
    		options.addArguments("--remote-allow-origins=*");
    		WebDriver driver = new ChromeDriver(options);
            ThreadDriverManager.setWebDriver(driver);
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            WebDriver driver = ThreadDriverManager.getDriver();
            if (driver != null) {
            	try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                driver.quit();
            }
        }
    }*/
}
