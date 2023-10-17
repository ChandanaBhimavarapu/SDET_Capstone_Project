package com.qa.testUtility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class NewTest extends TestListenerAdapter{
	public ExtentReports xReport;
	public ExtentTest xTest;
	public ExtentSparkReporter htmlReport;

	public void onStart(ITestContext testContext)
	{
		String dataStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName= "Test-Automation-Report"+dataStamp+".html";
		htmlReport = new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/"+repName);
		htmlReport.config().setDocumentTitle("Test Automation Report");
		htmlReport.config().setReportName("Functional Report");
		htmlReport.config().setTheme(Theme.DARK);

		xReport =new ExtentReports();
		xReport.attachReporter(htmlReport);
		xReport.setSystemInfo("QA Name", "AnilKumar");
		xReport.setSystemInfo("OS","Windows11");
		xReport.setSystemInfo("hostname","localhost");
	}
	public void onFinish(ITestContext testContext)
	 {
		  xReport.flush();
	 }
	 
	public void onTestSuccess(ITestResult tr) {
		xTest=xReport.createTest(tr.getName());
		xTest.log(Status.PASS, "Test is passed");
	    xTest.log(Status.PASS,MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	    
	    String ssPath= System.getProperty("user.dir")+"/Screenshot/"+tr.getName()+".png";
	    File file = new File(ssPath);
	    
	    if(file.exists()) {
	    	try{
	    		xTest.pass("Screenshot of the test passed is: " +xTest.addScreenCaptureFromPath(ssPath));
	    	}
	    catch(Exception e){
	    	e.printStackTrace();
	    }
	    }
		
	}
	public void onTestFailure(ITestResult tr) {
		xTest=xReport.createTest(tr.getName());
		xTest.log(Status.FAIL, "Test is failed");
		xTest.log(Status.FAIL, tr.getThrowable());
	    xTest.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
	    
	    String ssPath= System.getProperty("user.dir")+"/Screenshot/"+tr.getName()+".png";
	    File file = new File(ssPath);
	    
	    if(file.exists()) {
	    	try{
	    		xTest.fail("Screenshot of the test failed is: " +xTest.addScreenCaptureFromPath(ssPath));
	    	}
	    catch(Exception e){
	    	e.printStackTrace();
	    }
	    }
	
	}
	
	public void onTestSkipped(ITestResult tr) {
		xTest=xReport.createTest(tr.getName());
		xTest.log(Status.SKIP, "Test is skipped");
		xTest.log(Status.SKIP, tr.getThrowable());
	    xTest.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(), ExtentColor.AMBER));
	}
}

