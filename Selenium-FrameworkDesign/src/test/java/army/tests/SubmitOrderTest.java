package army.tests;

import Army.packageobjects.LandingPage;
import Army.packageobjects.ProductCatalogue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String productName= "ZARA COAT 3";
		String countryName= "india";
		WebDriverManager.chromedriver().setup();//
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		//Login Application
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo();
		landingPage.loginApplication("chuy@bah.com", "Hello1234!");		
		//Product Catalog
		ProductCatalogue productCatalogue= new ProductCatalogue(driver);
		List<WebElement> products=productCatalogue.getProductList();

		//Finding product based on product name
		productCatalogue.addProductToCart(productName);
		
		//Go to cart, validate if product name is added and check out
		//productCatalogue.chekOut(productName);
		
		//PlaceOrder
		//productCatalogue.placeOrder(countryName);
		
		//Validate order is placed	
		//productCatalogue.validateOrder();
		
	    //Close Browser
		driver.close();
	}
}
