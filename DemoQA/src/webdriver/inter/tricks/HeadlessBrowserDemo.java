package webdriver.inter.tricks;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HeadlessBrowserDemo {

	public static void main(String[] args) throws InterruptedException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command");

		//Creating Driver instance				
		HtmlUnitDriver unitDriver= new HtmlUnitDriver();
		
		String url="https://demoqa.com/";
		unitDriver.get(url);
		
		System.out.println("Tittle of the page is -> "+unitDriver.getTitle());
				
		Thread.sleep(1000);
		System.out.println("End of Exercise - only one window closed");

	}

}
