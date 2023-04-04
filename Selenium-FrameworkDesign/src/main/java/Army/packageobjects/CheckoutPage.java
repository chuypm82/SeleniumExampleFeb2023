package Army.packageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Army.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent{
	
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver) { // gives life to driver
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this); // Initialize Page Factory elements
	}
	
	By results= By.cssSelector(".ta-results");
	
	
	@FindBy(css=".action__submit") 
	WebElement  submit;
	
	@FindBy(css="[placeholder='Select Country']") 
	WebElement  country;
	
	@FindBy(css=".ta-item:nth-of-type(2)") 
	WebElement  selectCountry;
	
	public void selectCountry(String countryName)
	{
		Actions a = new Actions(driver);
		a.sendKeys(country,countryName).build().perform();
		waitForElementToAppear(results);
		selectCountry.click();
	}

	public ConfirmationPage submitOrder()
	{
		submit.click();
		return new ConfirmationPage(driver);
	}
	
	
}
