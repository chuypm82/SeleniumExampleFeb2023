package Integrated;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;

public class ListenersTestNGTSafe extends SSListenerParallelTSafe implements ITestListener {

	WebDriver driver, driver2;
	ExtentTest test; //holds entry into report
	ExtentReports extent= ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest= new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		// System.out.println("********New Test Started: " + result.getName());
		test = extent.createTest(result.getMethod().getMethodName());//create entry for a test
		extentTest.set(test);// assign unique thread id (ErrorValidationTest->test)
	}
	
	
	public void onTestSuccess(ITestResult result) {
		// System.out.println("********onTestSuccess Method: " + result.getName());
		//test.log(LogStatus.PASS, "Test Case: " + result.getName() + " ---> Status: PASSED");
		//test.log(Status.PASS, "Test Pass");// if we dont add this it does not matter
		//extentTest.get().log(Status.PASS, "Test Pass");// if we dont add this it does not matter
	}
	
	public void onTestFailure(ITestResult result) {
		// System.out.println("********onTestFailure Method: " + result.getName());
		// System.out.println("I am in onTestFailure method " + result.getName() + "
		// failed");
		//driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		//test.fail(result.getThrowable());// provides info about the failure
		extentTest.get().fail(result.getThrowable());
		try {
			driver= (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String filePath=null;
		try {
			filePath = getScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
		
		/*	test.log(LogStatus.FAIL, test.addScreenCapture(capture(result.getName(), driver)) 
					+ "Test Case: " + result.getName() + " ---> Status: FAILED"
					+ " ---> Reason: ---> "
					+ result.getThrowable()); */
	}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("********onTestSkipped Method: " + result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("********onTestFailedButWithinSuccessPercentage: " + result.getName());
	}


	public void onStart(ITestContext context) {
		// System.out.println("********onStart method started: " + context.getName());

	}

	public void onFinish(ITestContext context) {
		// System.out.println("********onFinish method started: ");
		extent.flush();
	}

	
}
