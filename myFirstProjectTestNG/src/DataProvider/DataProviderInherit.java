package DataProvider;

import org.testng.annotations.Test;
  
public class DataProviderInherit extends DataProviderClass {
       
    @Test(dataProvider = "getData")
    public void myTest2(int val) {
    	System.out.println("Passed Parameter is: " + val);
    }
}
