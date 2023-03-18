package Integrated;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ListenersTestNG extends SSListener implements ITestListener {

	WebDriver driver;
	ExtentReports report;
	ExtentTest test;

	public void onStart(ITestContext context) {
		// System.out.println("********onStart method started: " + context.getName());
		report = new ExtentReports(System.getProperty("user.dir") + "\\reports\\ExtentReportResults.html");
		test = report.startTest(context.getSuite().getName());

	}

	public void onFinish(ITestContext context) {
		// System.out.println("********onFinish method started: ");
		report.endTest(test);
		report.flush();
	}

	public void onTestStart(ITestResult result) {
		// System.out.println("********New Test Started: " + result.getName());

	}

	public void onTestSuccess(ITestResult result) {
		// System.out.println("********onTestSuccess Method: " + result.getName());
		test.log(LogStatus.PASS, "Test Case: " + result.getName() + " ---> Status: PASSED");
	}

	public void onTestFailure(ITestResult result) {
		// System.out.println("********onTestFailure Method: " + result.getName());
		// System.out.println("I am in onTestFailure method " + result.getName() + "
		// failed");
		try {
			// driver = (WebDriver)
			// result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());

		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}


		try {
			test.log(LogStatus.FAIL, test.addScreenCapture(capture(result.getName(), driver)) 
					+ "Test Case: " + result.getName() + " ---> Status: FAILED"
					+ " ---> Reason: ---> "
					+ result.getThrowable());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("********onTestSkipped Method: " + result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("********onTestFailedButWithinSuccessPercentage: " + result.getName());
	}
}
