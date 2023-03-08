package webdriver.advance.grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class Grid_SetUpFirefox {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");
		
		String URL = "http://google.com";
		String Node = "http://192.168.0.19:4444";

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName("firefox");
		caps.setPlatform(Platform.WIN10);
		WebDriver driver = new RemoteWebDriver(new URL(Node), caps);
		driver.get(URL);
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("Jesus");
		Thread.sleep(1000);
		driver.close();
		System.out.println("End of Exercise - only one window closed");

	}

}
