package Work;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import resources.ExtentManager;

public class ExtentReportsListeners  implements ITestListener{

	private static ExtentReports extent = ExtentManager.createInstance(".//test-output//ReportHTML.html");
	private static ThreadLocal parentTest = new ThreadLocal();
	private static ThreadLocal test = new ThreadLocal();
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentTest child = ((ExtentTest) parentTest.get()).createNode(result.getMethod().getMethodName());
        test.set(child);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		((ExtentTest) test.get()).pass("Test passed");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		((ExtentTest) test.get()).fail(result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		((ExtentTest) test.get()).skip(result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ExtentTest parent = extent.createTest(context.getName());
	    System.out.println(context.getName());
	        parentTest.set(parent);
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}
