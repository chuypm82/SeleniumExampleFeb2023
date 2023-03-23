package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;

	// Constructor that will be automatically called as soon as the object of the
	// class is created
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	//Locators for the page title and the logout button
	By heading = By.xpath("//div[@class='left mt-1']/p");
	By logoutBtn = By.xpath("(//button[@class='btn btn-custom'])[4]");
	By searchBox = By.xpath("//div[@class='py-2 border-bottom ml-3']/input");

	//Method to capture the page heading
	public String getHeading() {
		String head = driver.findElement(heading).getText();
		return head;
	}
	
	//Method to enter search string and display the same on console
		public void enterSearchStr(String str) {
			driver.findElement(searchBox).sendKeys(str);
			driver.findElement(searchBox).sendKeys(Keys.ENTER);
			System.out.println("The search string is : " +str);
			driver.findElement(searchBox).click();
		}
	
	//Method to click on Logout button
	public void clickLogout() {
		//WebElement logoutButton = new WebDriverWait(driver, Duration.ofSeconds(5))
			//	.until(ExpectedConditions.visibilityOfElementLocated(logoutBtn));
		//logoutButton.click();
		driver.findElement(logoutBtn).click();
	}
	
	

}
