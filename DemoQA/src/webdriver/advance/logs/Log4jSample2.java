package webdriver.advance.logs;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jSample2 {

	static Logger log = Logger.getLogger(Log4jSample2.class);
	//static Logger mainLogger = LogManager.getLogger(LogSampleEntry3.class.getName());
	
	public static void main(String[] args) {
		
	String path= "C:\\Users\\625337\\OneDrive - BOOZ ALLEN HAMILTON\\Documents\\Personal\\Trainings\\Selenium\\Workspaces\\Feb2023\\DemoQA\\log4j.properties";
	PropertyConfigurator.configure(path);
	//System.setProperty("webdriver.chrome.driver", "Path\\to\\chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
	WebDriver driver = new ChromeDriver(options);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	driver.get("https://www.browserstack.com/users/sign_in");
	log.info("Open browserstack");
	driver.manage().window().maximize();
	log.info("Maximize window size");
	js.executeScript("document.getElementById('user_email_login').value='rbc@xyz.com';");
	log.info("enter username");
	js.executeScript("document.getElementById('user_password').value='password';");
	log.info("enter password");
	js.executeScript("document.getElementById('user_submit').click();");
	log.info("click on login");
	driver.close();

	}

}
