package FactorySamples;

import org.testng.annotations.Factory;

public class TestNGFactory {

	@Factory()
    public Object[] getTestClass() {
        Object[] tests = new Object[2];
        tests[0] = new TestData1();
        tests[1] = new TestData2();
        return tests;
    }
}
