package objRepJson;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JsonSampleTests {

	private JsonRespositoryParser parser;
	private WebDriver driver;

	@BeforeClass
	public void setUp() throws IOException
	{
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/automation-practice-form");
		parser = new JsonRespositoryParser("src/objRepJson/ObjectRepository.json");
	}

	@Test
	public void EnterValue() throws IOException, InterruptedException
	{
		//Lets see how we can find the first name field
		WebElement FirstName = driver.findElement(parser.getbjectLocator("FirstName"));
		WebElement LastName = driver.findElement(parser.getbjectLocator("LastName"));
		FirstName.sendKeys("Jesus");
		LastName.sendKeys("Perez");
		Thread.sleep(1000);
	}

	@Test(enabled=true)
	public void FindPartialLink() throws IOException, InterruptedException
	{
		WebElement link = driver.findElement(parser.getbjectLocator("PartialLink"));
		link.click();
		Thread.sleep(1000);
	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}