package com.fw.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsListenersUtils implements ITestListener{
	
	
	ExtentSparkReporter reporter;
	ExtentReports reports;
	ExtentTest test;
	
	
	public void configureReport() {
		
		reports = new ExtentReports();
		
		String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String reportName = "PetStoreReport" + timestamp + ".html";
		reporter = new ExtentSparkReporter(System.getProperty("user.dir")+ "//reports//" + reportName);
		
		reports.attachReporter(reporter);
		
		//add system configuration
		reports.setSystemInfo("Machine", "testuser1");
		reports.setSystemInfo("OS", "Windows");
		reports.setSystemInfo("tester", "tester1");
		
		//configure report
		reporter.config().setDocumentTitle("PSA-REPORT");
		reporter.config().setReportName("PSA TestReport-tester1");
		reporter.config().setTheme(Theme.DARK);
		
	
		
	}
	
	@Override
	public void onStart(ITestContext context) {
		configureReport();
		System.out.println("On Start method invoked...");
	}



	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Name of the test started:" + result.getName());
	}


	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Name of the test passed:" + result.getName());
		
		test = reports.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Passed Test: "+result.getName(), ExtentColor.GREEN));
	}


	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Name of the test failed:" + result.getName());
		test = reports.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Failed Test: "+result.getName(), ExtentColor.RED));
		
		String screenshot = System.getProperty("user.dir") + "\\screenshots\\" + result.getName() + ".png";
		File screenshotFile = new File(screenshot);
		
		if (screenshotFile.exists()){
			test.fail("Captured screenshot:" + test.addScreenCaptureFromPath(screenshot));
		}
		
		
	}


	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Name of the test skipped:" + result.getName());
		
		test = reports.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Skipped Test: "+result.getName(), ExtentColor.YELLOW));
	}


	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}


	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}




	@Override
	public void onFinish(ITestContext context) {
		System.out.println("On Finish method invoked...");
		reports.flush();
	}

}
