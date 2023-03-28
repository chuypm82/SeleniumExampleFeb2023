package Example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoOr {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// Create WebDriver Instance
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:\\Users\\625337\\Documents\\Personal\\Trainings\\Selenium\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/guru99home/");
		driver.manage().window().maximize();
		// Load the properties File
		Properties obj = new Properties();
		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") + "\\Externals\\Application.properties");
		obj.load(objfile);
		// Nagigate to link Mobile Testing and Back
		driver.findElement(By.xpath(obj.getProperty("MobileTesting"))).click();
		driver.navigate().back();
		// Enter Data into Form
		driver.findElement(By.id(obj.getProperty("EmailTextBox"))).sendKeys("testguru99@gmail.com");
		driver.findElement(By.id(obj.getProperty("SignUpButton"))).click();

	}

}
