package ParallelWebdriver3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 
class BrowserSelection {
    static WebDriver createInstance(String browserName) {
        WebDriver driver = null;
        if (browserName.toLowerCase().contains("firefox")) {
            driver = new FirefoxDriver();          
            return driver;
        }
        if (browserName.toLowerCase().contains("edge")) {
        	//WebDriverManager.edgedriver().setup();
        	driver= new EdgeDriver();
            return driver;
        }
        if (browserName.toLowerCase().contains("chrome")) {
    		ChromeOptions options = new ChromeOptions();
    		options.addArguments("--remote-allow-origins=*");
    		driver = new ChromeDriver(options);
            return driver;
        }
        return driver;
    }
}
