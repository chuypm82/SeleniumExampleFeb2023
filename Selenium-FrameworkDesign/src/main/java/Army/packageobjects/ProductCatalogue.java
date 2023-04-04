package Army.packageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Army.AbstractComponents.AbstractComponent;

import org.testng.Assert;
//import dev.failsafe.internal.util.Assert;
import org.testng.AssertJUnit;

public class ProductCatalogue extends AbstractComponent{
	
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver)// constructor, this code is the first one to get executed
	{
		//Initialization
		super(driver);
		this.driver=driver; // this.driver is local
		PageFactory.initElements(driver, this); // Initialize Page Factory elements
	}
	
	By productsBy = By.cssSelector(".mb-3");
	By addToCart= By.cssSelector(".card-body button:last-of-type");
	By toastMessage= By.cssSelector("#toast-container");
	
	
	@FindBy(css=".mb-3") 
	List<WebElement>  products;
	
	@FindBy(css=".ng-animating") 
	WebElement spinner;


	
	public List<WebElement> getProductList()// List products in page
	{
		waitForElementToAppear(productsBy);
		return products; 
	}
	
	public WebElement getProductByName(String productName)
	{
		WebElement prod=products.stream().filter(p->
		p.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);		
		return prod;
	}
	
	public void addProductToCart(String productName) throws InterruptedException
	{
		WebElement prod=getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);
	}
	
	public List<WebElement> getCheoutList()// List products in page
	{
		waitForElementToAppear(productsBy);
		return products; 
	}
}
