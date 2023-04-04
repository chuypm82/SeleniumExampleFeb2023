package army.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Army.packageobjects.CartPage;
import Army.packageobjects.CheckoutPage;
import Army.packageobjects.ConfirmationPage;
import Army.packageobjects.OrderPage;
import Army.packageobjects.ProductCatalogue;
import army.TestComponents.BaseTest;
import army.TestComponents.Retry;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.Assert;

public class SubmitOrderTestImproved extends BaseTest {

	String productName= "ZARA COAT 3";
	
	@Test(dataProvider="getData", groups= {"Purchase"})
	public void submitOrder(HashMap<String, String> input ) throws IOException, InterruptedException
	{
		
		ProductCatalogue productCatalogue=landingPage.loginApplication(input.get("email"), input.get("password"));		
		productCatalogue.addProductToCart(input.get("product"));
		CartPage cartPage = productCatalogue.goToCartPage();
		
		Boolean match = cartPage.VerifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage=cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();		
		String confirmMessage= confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));		
	}
	
	//Verify ZARA COAT 3 is displaying in orders page
	@Test(dependsOnMethods = {"submitOrder"}, retryAnalyzer=Retry.class)
	public void OrderHistoryTest()
	{
		ProductCatalogue productCatalogue=landingPage.loginApplication("chuy@bah.com", "Hello1234!");		
		OrderPage orderPage =productCatalogue.goToOrdersPage();
		Assert.assertTrue(orderPage.VerifyOrdertDisplay(productName));
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{		
		List<HashMap<String, String>>data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\army\\data\\PurchaseOrder.json");	
		return new Object[][] {{data.get(0)}, {data.get(1)}}; // return this 2 dimensional array with 2 data sets. if you want another data set add{}
	}
}
