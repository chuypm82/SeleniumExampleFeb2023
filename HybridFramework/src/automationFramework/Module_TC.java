package automationFramework;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import appModule.SignIn_Action;
import pageObjects.Home_Page;
import utility.Constant;

public class Module_TC {

	private static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {

		// Creating webDriver instance
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client/");

		// Use your Module SignIn now
		SignIn_Action.Execute(driver,Constant.Username,Constant.Password);
		Thread.sleep(1000);
		System.out.println("Login Successfully, now it is the time to Log Off buddy.");
		Home_Page.buttonLogout(driver).click();
		Thread.sleep(1000);
		driver.quit();

	}
}
