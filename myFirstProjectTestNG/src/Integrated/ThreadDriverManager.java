package Integrated;

import org.openqa.selenium.WebDriver;

public class ThreadDriverManager {
	private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return webDriver.get();
	}

	static void setWebDriver(WebDriver driver) {
		webDriver.set(driver);
	}
	
	static WebDriver CreateDriverThread(String browserName) {
		WebDriver driver;
		driver=LocalDriverFactory.createInstance(browserName);
		webDriver.set(driver);
        System.out.println("Thread id = " + Thread.currentThread().getId());
        System.out.println("Hashcode of webDriver instance = " + getDriver().hashCode());
		return webDriver.get();
        //return driver;
	}
	
	static void removeThread(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
        System.out.println("Thread id = " + Thread.currentThread().getId());
        System.out.println("Hashcode of webDriver instance = " + getDriver().hashCode());
        driver.quit();
		webDriver.remove();
	}
	

}