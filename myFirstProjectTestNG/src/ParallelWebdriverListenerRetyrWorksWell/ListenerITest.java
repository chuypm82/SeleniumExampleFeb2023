package ParallelWebdriverListenerRetyrWorksWell;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ListenerITest extends LandingPageTest implements ITestListener {
	
	ExtentTest test; //holds entry into report
	ExtentReports extent= ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest= new ThreadLocal<ExtentTest>();
	String filePath=null;
	
	// When Test case get Started, this method is called.
	@Override
	public void onTestStart(ITestResult Result) {
		//System.out.println(Result.getName() + " test case started");
		test = extent.createTest(Result.getMethod().getMethodName());//create entry for a test
		extentTest.set(test);// assign unique thread id (ErrorValidationTest->test)
	}

	// When Test case get passed, this method is called.
	@Override
	public void onTestSuccess(ITestResult Result) {
		//System.out.println("The name of the testcase passed is :" + Result.getName());
		extentTest.get().pass(Result.getMethod().getMethodName()+" test Passed");
		filePath=null;
		try {
			filePath = getScreenshot(Result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(filePath, Result.getMethod().getMethodName());
	}

	// When Test case get failed, this method is called.
	@Override
	public void onTestFailure(ITestResult Result) {
		//System.out.println("The name of the testcase failed is :" + Result.getName());
		extentTest.get().fail(Result.getThrowable());
		filePath=null;
		try {
			filePath = getScreenshot(Result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(filePath, Result.getMethod().getMethodName());
	}
	
	// When Test case get Skipped, this method is called.
	@Override
	public void onTestSkipped(ITestResult Result) {
		System.out.println("The name of the testcase Skipped is :" + Result.getName());
		
		extentTest.get().skip(Result.getMethod().getMethodName()+" test Skipped, to be retested... Reason -->" + Result.getThrowable());
		filePath=null;
		try {
			filePath = getScreenshot(Result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(filePath, Result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}
