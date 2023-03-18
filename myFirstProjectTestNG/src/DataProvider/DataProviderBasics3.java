package DataProvider;

import org.testng.annotations.Test;
  
public class DataProviderBasics3 extends DataProviderClass {
       
    @Test (dataProvider = "data-provider")
    public void myTest (String val) {
        System.out.println("Passed Parameter Is : " + val);
    }    
}
