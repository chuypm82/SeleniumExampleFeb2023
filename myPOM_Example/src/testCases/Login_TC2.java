package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pages.HomePage;
import pages.LoginPage;

public class Login_TC2 {

	public static void main(String[] args) throws InterruptedException {

		// Creating webDriver instance
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);

		String url = "https://rahulshettyacademy.com/client/";
		driver.get(url);

		// Creating object of home page
		HomePage home = new HomePage(driver);

		// Creating object of Login page
		LoginPage login = new LoginPage(driver);

		// Enter username & password
		login.enterUsername("anshika@gmail.com");
		login.enterPassword("Iamking@000");

		// Click on Login button
		login.clickLogin();
		Thread.sleep(1000);

		// Capture the page heading and print on console
		System.out.println("The page heading is --- " + home.getHeading());
		
		home.enterSearchStr("adidas");
		Thread.sleep(2000);

		// Click on Logout button
		home.clickLogout();
		Thread.sleep(1000);

		// Close browser instance
		driver.quit();
	}

}