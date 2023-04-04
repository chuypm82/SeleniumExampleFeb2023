package Army.packageobjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Army.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent {
	
	WebDriver driver;
	
	public OrderPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this); // Initialize Page Factory elements
	}
	
	@FindBy(css="tr td:nth-child(3)") 
	List<WebElement>  productNames;

	public Boolean VerifyOrdertDisplay(String productName) 
	{
		Boolean match=productNames.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
		return match;
	}
}

