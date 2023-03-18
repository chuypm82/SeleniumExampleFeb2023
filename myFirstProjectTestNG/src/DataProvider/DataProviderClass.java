package DataProvider;

import org.testng.annotations.DataProvider;
  
public class DataProviderClass {
       
	 @DataProvider (name = "data-provider")
     public Object[][] dpMethod(){
	 return new Object[][] {{"First-Value"}, {"Second-Value"}};
     }
	 
	 @DataProvider (name= "getData")
	 public Object[][] getData(){
		return new Object[][] {{1},{2},{3}}; 
	 };
}
