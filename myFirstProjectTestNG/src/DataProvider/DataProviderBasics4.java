package DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
  
public class DataProviderBasics4 {
    
	@DataProvider
	 public Object[][] message(){
	 return new Object [][]{{"Mihir" , new Integer (145632)}, {"Kumar", new Integer (28242)}};
	 }
	
	@Test (dataProvider="message")
	public void PrintMsg(String name, Integer id){
	System.out.println("Names are: "+name+" "+id);
	 }
}
