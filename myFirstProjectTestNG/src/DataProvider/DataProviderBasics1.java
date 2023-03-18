package DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
  
public class DataProviderBasics1 {
    
	// A data provider which will provide single value to a test method thrice.
    @DataProvider(name="DataContainer")
    public Object[] myDataProvider() {
         
        // Passing 3 set of data and each set contains single value
        Object data[]=  new Object[3];
        data[0]= "Make"; 
        data[1]= "Selenium";
        data[2]= "Easy";
        return data;
    }
	
	// You must need to mention data provider method name in Test method
    @Test(dataProvider="DataContainer")
    public void methodWithSingleAttribute(String a) {
        System.out.println(a);
    }
}
