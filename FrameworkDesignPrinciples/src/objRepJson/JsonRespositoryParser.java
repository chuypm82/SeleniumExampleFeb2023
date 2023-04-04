package objRepJson;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;

import com.jayway.jsonpath.JsonPath;

public class JsonRespositoryParser {

	private File jsonFile;
	private String RepositoryFile;

	public JsonRespositoryParser(String fileName) throws IOException {
		this.RepositoryFile = fileName;
		jsonFile = new File(RepositoryFile);
	}

	public By getbjectLocator(String locatorName) throws IOException {
		
		String locatorProperty = JsonPath.read(jsonFile,"$."+locatorName);
		System.out.println(locatorProperty.toString());
		String locatorType = locatorProperty.split(";")[0];
		String locatorValue = locatorProperty.split(";")[1];

		By locator = null;
		switch (locatorType) {
		case "Id":
			locator = By.id(locatorValue);
			break;
		case "Name":
			locator = By.name(locatorValue);
			break;
		case "CssSelector":
			locator = By.cssSelector(locatorValue);
			break;
		case "LinkText":
			locator = By.linkText(locatorValue);
			break;
		case "PartialLinkText":
			locator = By.partialLinkText(locatorValue);
			break;
		case "TagName":
			locator = By.tagName(locatorValue);
			break;
		case "Xpath":
			locator = By.xpath(locatorValue);
			break;
		}
		return locator;
	}
}