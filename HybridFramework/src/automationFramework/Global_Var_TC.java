package automationFramework;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import appModule.SignIn_Action;
import pageObjects.Home_Page;
import utility.Constant;

public class Global_Var_TC {

	private static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {

		// Creating webDriver instance
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(Constant.URL);

		// Pass Constant Variables as arguments to Execute method
		SignIn_Action.Execute(driver, Constant.Username, Constant.Password);
		Thread.sleep(1000);
		System.out.println("Login Successfully, now it is the time to Log Off buddy.");
		Home_Page.buttonLogout(driver).click();
		Thread.sleep(1000);
		driver.quit();
	}

}
