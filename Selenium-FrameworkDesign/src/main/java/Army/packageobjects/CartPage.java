package Army.packageobjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Army.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this); // Initialize Page Factory elements
	}
	
	@FindBy(css=".cartSection h3") 
	List<WebElement>  cartProducts;
	
	@FindBy(css=".totalRow button") 
	WebElement  checkoutEle;
	
	public Boolean VerifyProductDisplay(String productName) 
	{
		Boolean match=cartProducts.stream().anyMatch(cart->cart.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public CheckoutPage goToCheckout()
	{			
		checkoutEle.click();
		return new CheckoutPage(driver);
	}
}
