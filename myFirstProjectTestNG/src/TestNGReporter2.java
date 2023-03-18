import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestNGReporter2 {
	WebDriver driver = new ChromeDriver();

	@Test(priority=0)
	public void CloseBrowser() {
		driver.close();
		//System.out.println("Closing Google Chrome browser");
		Reporter.log("Driver Closed After Testing");
	}

	@Test (priority = -1)
	public void OpenBrowser() {
		Reporter.log("This test verifies the current selenium compatibility with TestNG by launching the chrome driver");
        Reporter.log("Launching Google Chrome Driver for this test"); 
		//System.out.println("Launching Google Chrome browser"); 	        
		driver.get("https://www.demoqa.com");
		Reporter.log("The website used was DemoQA for this test");
	}

}