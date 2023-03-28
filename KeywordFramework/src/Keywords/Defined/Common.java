package Keywords.Defined;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class Common {
	
	String path = System.getProperty("user.dir");
	
	int timeSec(String TestData) {
		int timeInSec=Integer.parseInt(TestData);  
		return timeInSec;		
	}
	
	int getMiliSec(String TestData) {
		int timeInMiliSec=Integer.parseInt(TestData)*1000;  
		return timeInMiliSec;		
	}
	
	By getObject(String ObjectName, String locatorType) throws IOException {

		File file = new File(path + "\\Externals\\ObjectRepository.properties");
		FileInputStream fileInput = new FileInputStream(file);

		Properties prop = new Properties();
		prop.load(fileInput);
		// find by xpath
		if (locatorType.equalsIgnoreCase("XPATH")) {

			return By.xpath(prop.getProperty(ObjectName));
		}
		// find by class
		else if (locatorType.equalsIgnoreCase("CLASSNAME")) {

			return By.className(prop.getProperty(ObjectName));

		}
		// find by name
		else if (locatorType.equalsIgnoreCase("NAME")) {

			return By.name(prop.getProperty(ObjectName));

		}
		// Find by css
		else if (locatorType.equalsIgnoreCase("CSS")) {

			return By.cssSelector(prop.getProperty(ObjectName));

		}
		// find by link
		else if (locatorType.equalsIgnoreCase("LINK")) {

			return By.linkText(prop.getProperty(ObjectName));

		}
		// find by partial link
		else if (locatorType.equalsIgnoreCase("PARTIALLINK")) {

			return By.partialLinkText(prop.getProperty(ObjectName));

		}
		return null;
	}

}
