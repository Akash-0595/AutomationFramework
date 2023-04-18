package vtiger.GenericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/**
 * This class is an implementation class for ITestListener interface of testNg
 * @author akash kumar bhanja
 *
 */
public class ListenerImplementation implements ITestListener {
 
	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName=result.getMethod().getMethodName();
	    //System.out.println(methodName+"=== test script execution started");
		test=report.createTest(methodName);
		test.log(Status.INFO,methodName+" == Test script Executed");
 	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName=result.getMethod().getMethodName();
		//System.out.println(methodName+"=== test script passed");
 		test.log(Status.PASS, methodName+"== Test script passed");
 	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName=result.getMethod().getMethodName();
		//System.out.println(methodName+"=== test script failed");
		//System.out.println(result.getThrowable;
		test.log(Status.FAIL,methodName+" == Test Script failed ==");
		test.log(Status.INFO,result.getThrowable());
		
		WebDriverUtility wUtil=new WebDriverUtility();
		String screenShotName=methodName+"-"+new JavaUtility().getSystemDateInFormat();
		try {
			String path=wUtil.takeScreenShot(BaseClass.sDriver, screenShotName);
			test.addScreenCaptureFromPath(path);//Go to the Screenshot location
			                                     //attached to the report
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
 	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName=result.getMethod().getMethodName();
		//System.out.println(methodName+"=== test script skipped");
		//System.out.println(result.getThrowable());
		test.log(Status.SKIP, methodName+" == Test script skipped ==");
		test.log(Status.INFO,result.getThrowable());
 	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
 	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
 	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		 System.out.println("=== execution started=== ");
		 //Extent report configuration
		 ExtentSparkReporter htmlReporter=new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDateInFormat()+".html");
 	     htmlReporter.config().setDocumentTitle("vTiger execution report");
 	     htmlReporter.config().setTheme(Theme.DARK);
 	     htmlReporter.config().setReportName("Automation Execution Report");
 	     
 	     report=new ExtentReports(); 
 	     report.attachReporter(htmlReporter);
 	     report.setSystemInfo("Base URL", "http://localhost:8888");
 	     report.setSystemInfo("Base Browser", "Firefox");
 	     report.setSystemInfo("Base platform", "Windows");
 	     report.setSystemInfo("Reporter-Name", "Akash");
 	     
    }

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		 System.out.println("=== execution finished===");
		 report.flush(); //Generate the report
 	}
	

}
