package Asserts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAssertion {
	String message = "Manisha";
	MessageUtil messageUtil = new MessageUtil(message);

	@Test
	public void testPrintMessage() {
		Assert.assertEquals("Tutorialspoint", messageUtil.printMessage());
	}
}