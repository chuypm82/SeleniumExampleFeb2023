package webdriver.advance.tips;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class PracticeFormPageObject {
	
	@FindBy(id="firstName") 
	public WebElement firsName;
	
	@FindBy(id="firstName")
	@CacheLookup
	public WebElement firsNameCached;

	@FindBy(xpath="//input[@id='lastName']") 
	public WebElement lastName;

}
