package Keywords.Defined;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Assertions1 extends Common {
	
	
	public void AssertURLEquals (String currentURL, String expectedValue){		
		Assert.assertEquals(currentURL, expectedValue);
		System.out.println("ActualText " + currentURL);
		System.out.println("ExpectedText " + expectedValue);
	}

	public void AssertURLContains (String currentURL, String expectedValue){		
		Assert.assertEquals(true, currentURL.contains(expectedValue));
	}
	
	public void AssetElement(WebDriver driver, String AssertionType, String ObjectName, String LocatorType) throws IOException {
		switch (AssertionType) {

		case "Displayed":
			// Assert.assertEquals(true,driver.findElement(By.xpath("").isDisplayed());
			Assert.assertEquals(true, driver.findElement(getObject(ObjectName, LocatorType)).isDisplayed());
			break;

		case "Enabled":
			Assert.assertEquals(true, driver.findElement(getObject(ObjectName, LocatorType)).isEnabled());
			break;

		case "selected":
			Assert.assertEquals(true, driver.findElement(getObject(ObjectName, LocatorType)).isSelected());
			break;
		}
	}
	
}
