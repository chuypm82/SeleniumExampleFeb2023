package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

	// Constructor that will be automatically called as soon as the object of the
	// class is created
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Locator for username field
	By uName = By.xpath("//input[@id='userEmail']");

	// Locator for password field
	By pswd = By.xpath("//input[@id='userPassword']");

	// Locators for login button
	By LoginBtn = By.xpath("//input[@id='login']");

	// Method to enter username
	public void enterUsername(String user) {
		driver.findElement(uName).sendKeys(user);
	}

	// Method to enter password
	public void enterPassword(String pass) {
		driver.findElement(pswd).sendKeys(pass);
	}

	// Method to click login button
	public void clickLogin() {
		driver.findElement(LoginBtn).click();
	}

}
