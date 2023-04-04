package army.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import Army.packageobjects.CartPage;
import Army.packageobjects.CheckoutPage;
import Army.packageobjects.ConfirmationPage;
import Army.packageobjects.ProductCatalogue;
import army.TestComponents.BaseTest;
import army.TestComponents.Retry;

public class ErrorValidationsTest extends BaseTest {

	@Test(groups= {"ErrorHandling"}, retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws IOException, InterruptedException
	{
		landingPage.loginApplication("chuy@bah.com", "Hello1234");		
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
	}
	
	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException
	{
		String productName= "ZARA COAT 3";	
		ProductCatalogue productCatalogue=landingPage.loginApplication("chuy@bah.com", "Hello1234!");		
		List<WebElement> products=productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		
		Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);
	}
}
