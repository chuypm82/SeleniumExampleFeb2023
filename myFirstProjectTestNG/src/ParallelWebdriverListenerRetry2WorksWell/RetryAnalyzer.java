package ParallelWebdriverListenerRetry2WorksWell;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer  implements IRetryAnalyzer {

	int initialCount=0;
	int macCount=1;

	public boolean retry(ITestResult result) {
		if(initialCount<macCount)
		{
			initialCount++;
			return true;
		}
		return false;
	}
}
