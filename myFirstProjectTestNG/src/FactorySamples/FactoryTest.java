package FactorySamples;

import org.testng.annotations.Factory;

import FactorySamples.FactorySample;

public class FactoryTest {
	@Factory()
	public Object[] testFact() {
		FactorySample[] fs = new FactorySample[2];
		fs[0] = new googleTest();
		fs[1] = new gmailLogin();
		return fs;
	}
}