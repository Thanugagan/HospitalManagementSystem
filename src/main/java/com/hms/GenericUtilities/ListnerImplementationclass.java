package com.hms.GenericUtilities;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Log;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementationclass implements ITestListener {
	
	ExtentReports report;
	ExtentTest test;
	

	public void onTestStart(ITestResult result) {
		//Execution starts from here
		String MethodName = result.getMethod().getMethodName();
		test=report.createTest(MethodName);
		Reporter.log(MethodName+"---->TestScriptExecution Started");
	}

	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName+"---->TestScript Execution Successfull");
	}

	public void onTestFailure(ITestResult result) {
		String FailedScript = result.getMethod().getMethodName();
		String FS="FailedScript"+new JavaUtility().getSystemDateandTimeFormat();
		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		File path = new File("./Screenshot/"+FS+".png");
		String filepath = path.getAbsolutePath();
		try {
			FileUtils.copyFile(src, path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//		WebDriverUtility wlib = new WebDriverUtility();
		//		try {
		//			wlib.getScreenShot(BaseClass.sdriver, "a");
		//		} catch (Throwable e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}
		//
		test.addScreenCaptureFromPath(filepath);
		test.log(Status.FAIL, result.getThrowable());
		Reporter.log("--TestScript Execution Failed----");
	}

	public void onTestSkipped(ITestResult result) {
		String Methodname = result.getMethod().getMethodName();
		test.log(Status.SKIP, Methodname+"---Skipped");
		Reporter.log("---TestSCRIPT Execution skipped---");

	}

	public void onStart(ITestContext context) {
		//configure to the report
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./ExtentReport/report.html");
		htmlreport.config().setDocumentTitle("SDET-45 Extent report");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("Hospital Management Report");
		
	 report=new ExtentReports();
	 report.attachReporter(htmlreport);
	 report.setSystemInfo("Base Browser", "Chrome");
	 report.setSystemInfo("OS", "Windows");
	 report.setSystemInfo("Base-URL", "http://localhost:8888");
	 report.setSystemInfo("Reporter Name", "ThanujaB K");
		
 	} 

	public void onFinish(ITestContext context) {
		//CONSOLIDATE THE UUREPORT
		
		report.flush();
		

	}


}
