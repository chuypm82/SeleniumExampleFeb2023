package webdriver.other.examples;

import org.testng.Assert;

public class AssertDemo {

	public static void main(String[] args) throws InterruptedException {

		String expUserName="Jesus";
		String actUserName="Jesu";
		
		try{

			Assert.assertEquals(expUserName, actUserName);
			System.out.println("name is Valid");

			}catch(Exception e){

			System.out.println("name is invalid");

			}

	}

}
