package webdriver.advance.grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Browser {
	
	public static RemoteWebDriver getDriver(String browser) throws MalformedURLException {
		return new RemoteWebDriver(new URL("http://192.168.0.19:4444/wd/hub"), getBrowserCapabilities(browser));
	}
	
	private static DesiredCapabilities getBrowserCapabilities(String browserType) {
		DesiredCapabilities caps= new DesiredCapabilities();
		switch (browserType) {
		case "firefox":
			System.out.println("Opening firefox driver");
			caps.setBrowserName("firefox");
			return caps;
		case "chrome":
			System.out.println("Opening chrome driver");;
			caps.setBrowserName("chrome");
			return caps;
		case "edge":
			System.out.println("Opening IE driver");
			caps.setBrowserName("MicrosoftEdge");
			return caps;
		default:
			System.out.println("browser : " + browserType + " is invalid, Launching Firefox as browser of choice..");
			caps.setBrowserName("firefox");
			return caps;
		}
	}

}
