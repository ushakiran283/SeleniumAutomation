package selenium;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.ExtentReporter;

public class Listeners extends Base implements ITestListener {
	ExtentTest test;
	ExtentReports extent = ExtentReporter.getreportObject();

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {

		test.log(Status.PASS, "Test Passed");

	}

	public void onTestFailure(ITestResult result) {
		WebDriver driver = null;
		test.fail(result.getThrowable());
		String testMethodName = result.getMethod().getMethodName();
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		try {
			getscreenshot(testMethodName, driver);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
