package FactorySamples;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;


public class DependencyFactory
{
	@Factory
	public Object[] factoryMethod()
	{
		return new Object[] { new DependencyFactoryClass(1), new DependencyFactoryClass(2) };
	}
}

class DependencyFactoryClass {
	private int param;
	
	public DependencyFactoryClass(int param) {
		this.param = param;
	}

	@Test(dependsOnMethods= {"testMethodTwo"})
	public void testMethodOne() {
		System.out.println("Test method one output: " + param);
	}

	@Test
	public void testMethodTwo() {
		System.out.println("Test method two output: " + param);
	}
}