package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import pages.Login;
import pages.Profile;

public class Login_TC {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://demoqa.com/login");
		driver.manage().window().maximize();

		// Instantiating Login & Profile page using initElements()
		Login loginPg = PageFactory.initElements(driver, Login.class);
		Profile profilePg = PageFactory.initElements(driver, Profile.class);

		// Using the methods created in pages class to perform actions
		loginPg.LogIn_Action("chuyp", "Pas1234$");
		Thread.sleep(2000);
		profilePg.verifyUser("chuyp");
		profilePg.logout_Action();
		Thread.sleep(2000);
		driver.quit();
	}

}
