package support;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReportClass implements ITestListener, Constants {
	ExtentReports report = new ExtentReports();
	ExtentSparkReporter htmlReporter = new ExtentSparkReporter("reports/myReport.html");
	ExtentTest extentTest;
	
	public void onTestStart(ITestResult result) {
		extentTest = report.createTest(result.getMethod().getMethodName());
		report.attachReporter(htmlReporter);
		extentTest.log(Status.INFO, "The Test Start!");
	}

	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, "The Test Pass");
	}

	public void onTestFailure(ITestResult result) {
		extentTest.log(Status.FAIL, "The Test Fail");
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + File.separator + "Screenshots" + File.separator + result.getName() + ".png";
		File finalDestination = new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		extentTest.log(Status.FAIL, "Test is Failed, U Can See The Screenshot").addScreenCaptureFromPath(destination);
	}
	
	public void onFinish(ITestContext context) {
		extentTest.log(Status.INFO, "The Test Finish!");
		report.flush();
	}
}
