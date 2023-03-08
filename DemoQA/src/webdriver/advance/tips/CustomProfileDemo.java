package webdriver.advance.tips;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;


public class CustomProfileDemo {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		//Creating webDriver instance
		FirefoxProfile profile =new FirefoxProfile(new File("C:\\Users\\625337\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\fz6fv6yu.profileToolsQA"));
		FirefoxOptions option=new FirefoxOptions();
		option.setProfile(profile);
        WebDriver driver = new FirefoxDriver(option);
		
		String url="https://rahulshettyacademy.com/locatorspractice/";
		driver.get(url);
				
		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise - only one window closed");

	}

}
