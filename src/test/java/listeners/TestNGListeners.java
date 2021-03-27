package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import utility.Screenshot;

public class TestNGListeners extends Screenshot implements ITestListener {
	
	@Override
	//This method will be executed before the test Suite execution starts
	public void onStart(ITestContext context) {
		Reporter.log(context.getName()+ " Test suite EXECUTION STARTED",true);
	}
	@Override
	//This method will be executed after the test Suite is executed
	public void onFinish(ITestContext context) {
		Reporter.log(context.getName()+ " Test suite is EXECUTED",true);
	}
	
	//This will be executed before the test case(@Test) execution starts
	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log(result.getName()+ " Test case EXECUTION STARTED",true);
	}
	
	@Override
	//This will be executed if the test case(@Test) execution skips
	public void onTestSkipped(ITestResult result){
		Reporter.log(result.getName()+ " Test case EXECUTION SKIPPED",true);
	}
	
	@Override
	//This will be executed if the test case(@Test) execution is successful
		public void onTestSuccess(ITestResult result) {
		Reporter.log(result.getName()+" Test case PASSED",true);
	}
	
	@Override
	//This will be executed if the test case(@Test) execution is failed
	public void onTestFailure(ITestResult result) {
		Reporter.log(result.getName() + " Test case FAILED",true);
		//captureScreenshot(driver, result.getName());
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	// it is not required to implement this method
	}
	
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// it is not required to implement this method
	}
}
