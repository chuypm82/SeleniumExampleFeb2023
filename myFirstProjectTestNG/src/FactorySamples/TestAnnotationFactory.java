package FactorySamples;

import org.testng.annotations.Factory;

public class TestAnnotationFactory {
	@Factory
	public Object[]factoryMethod(){
		return new Object[] {
				new SimpleTest(),
				new SimpleTest(),
				new SimpleTest(),
				new SimpleTest(),
		};
		
	}
}
