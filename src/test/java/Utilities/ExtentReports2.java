package Utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Base.BaseClass;

public class ExtentReports2 implements ITestListener{
public ExtentSparkReporter sparkreporter;
public ExtentReports reports;
public ExtentTest test;


public void onStart(ITestContext context) {
	
	String TimeStamp=new SimpleDateFormat("yy.mm.dd.hh.mm.ss").format(new Date());
	
	
	
 sparkreporter=new ExtentSparkReporter(System.getProperty("user.dir")+"\\ExtentReports\\"+TimeStamp+"Report1.html");
 sparkreporter.config().setDocumentTitle("Automation Testing");
 sparkreporter.config().setReportName("Smoke Testing");
 sparkreporter.config().setTheme(Theme.STANDARD);
 reports=new ExtentReports();
 reports.attachReporter(sparkreporter);
 
 reports.setSystemInfo("Environment","QA");
 reports.setSystemInfo("TesterName", "Sandeep");
 reports.setSystemInfo("OS","Windows");
 
 
  
  }
public void onTestSuccess(ITestResult result) {
    test=reports.createTest(result.getName());
    test.log(Status.PASS,"Test is passed");
  }

public void onTestFailure(ITestResult result) {
    test=reports.createTest(result.getName());
    test.log(Status.FAIL, "Test is Failed - "+result.getName());
    test.log(Status.FAIL, result.getThrowable());
    
    try {
		String imagepath=new BaseClass().screenshot(result.getName());
		test.addScreenCaptureFromPath(imagepath);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.getMessage();
		e.printStackTrace();
	}
    
  }

public void onTestSkipped(ITestResult result) {
    test=reports.createTest(result.getName());
    test.log(Status.SKIP, "Test is skipped - "+result.getName());
    test.log(Status.SKIP, result.getThrowable());
  }

public void onFinish(ITestContext context) {
    reports.flush();
  }

}
