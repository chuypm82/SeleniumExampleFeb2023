package army.TestComponents;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import Army.resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener {
	
	ExtentTest test; //holds entry into report
	ExtentReports extent= ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest= new ThreadLocal<ExtentTest>();
	
	
	@Override
	public void onTestStart(ITestResult result) // when test starts control of execution comes into this block
	{	
		test = extent.createTest(result.getMethod().getMethodName());//create entry for a test
		extentTest.set(test);// assign unique thread id (ErrorValidationTest->test)
	}
	
	@Override
	public void onTestSuccess(ITestResult result) // when test success control of execution comes into this block
	{
		//test.log(Status.PASS, "Test Pass");// if we dont add this it does not matter
		//extentTest.get().log(Status.PASS, "Test Pass");// if we dont add this it does not matter
	}
	
	@Override
	public void onTestFailure(ITestResult result) // when test fails control of execution comes into this block
	{
		//test.fail(result.getThrowable());// provides info about the failure
		extentTest.get().fail(result.getThrowable());
		//Screenshot, Attach to report
		//try catch if screenshot does not exist, the system will indicate there is no path present. This code was autosuggested by eclipse
		try {
			driver= (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		String filePath=null;
		try {
			filePath = getScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestSkipped(ITestResult result) // when test fails control of execution comes into this block
	{
		
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) // when test fails control of execution comes into this block
	{
		
	}
	
	@Override
	public void onStart(ITestContext context) // when test success control of execution comes into this block
	{
		
	}
	
	@Override
	public void onFinish(ITestContext context) // when test success control of execution comes into this block
	{
		extent.flush();
	}

}
