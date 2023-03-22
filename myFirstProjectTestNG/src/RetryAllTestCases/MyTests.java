package RetryAllTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTests {

	//@Test(retryAnalyzer=RetryAnalyzerDemo.class)
	@Test
	public void test1() 	{
		Assert.assertEquals(true, false);
	}
	@Test
	public void test2()	{
		Assert.assertEquals(true, false);
	}
	@Test(enabled=false)
	public void test3()
	{
		Assert.assertEquals(true, false);
	}
}