package FactorySamples;

import org.testng.annotations.Factory;

public class SimpleTestFactory2 {
	@Factory
	public Object[] factoryMethod() {
		return new Object[] { new SimpleTest2(0), new SimpleTest2(1) };
	}
}
