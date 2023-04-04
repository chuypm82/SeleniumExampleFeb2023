package objRepSample;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SampleTests {

	private RespositoryParser parser;
	private WebDriver driver;

	@BeforeClass
	public void setUp() throws IOException
	{
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/automation-practice-form");
		parser = new RespositoryParser("src/objRepSample/ObjectRepo.properties");
	}

	@Test
	public void EnterValue()
	{
		//Lets see how we can find the first name field
		WebElement FirstName = driver.findElement(parser.getbjectLocator("FirstName"));
		WebElement LastName = driver.findElement(parser.getbjectLocator("LastName"));
		FirstName.sendKeys("Jesus");
		LastName.sendKeys("Perez");
	}

	@Test
	public void FindPartialLink()
	{
		WebElement link = driver.findElement(parser.getbjectLocator("PartialLink"));
		link.click();
	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}