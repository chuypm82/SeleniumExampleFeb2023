package webdriver.inter.tricks;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CredentilasInURLwEdge {

	public static void main(String[] args) throws InterruptedException, IOException {

		// Setting the driver path
		System.out.println("Selenium WebDriver Browser Command - Practice Exercises #2");

		//Creating webDriver instance
		WebDriver driver= new EdgeDriver();
		
		String url="https://admin:admin@the-internet.herokuapp.com/basic_auth";
		driver.get(url);
		
		driver.manage().window().maximize();

				
		Thread.sleep(1000);
		driver.quit();
		System.out.println("End of Exercise - only one window closed");

	}

}
