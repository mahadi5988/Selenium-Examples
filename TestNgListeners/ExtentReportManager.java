package TestNgListeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {
	
	public ExtentSparkReporter sparkReporter;       //UI of the report
	public ExtentReports extent;                    //Populate common info in the report
	public ExtentTest test;							//Creating test report entries in the report and update status of the test methods
	
	public void onStart(ITestContext context) {
		sparkReporter= new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/myReports.html");
		
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Functional Testing");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent =new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Computer Name", "Localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester Name", "Mahadi");
		extent.setSystemInfo("os", "Windows 11");
		extent.setSystemInfo("Browser Name", "Chrome"); 
		}
	
	
	 public void onTestSuccess(ITestResult result) {
		    test= extent.createTest(result.getName());             //create a new entry in the report
		    test.log(Status.PASS, "Test case PASSED is: "+result.getName());
		  }
	 
	 public void onTestFailure(ITestResult result) {
		    test= extent.createTest(result.getName());
		    test.log(Status.FAIL, "Test case FAILED is: "+result.getName());
		    test.log(Status.FAIL, "Test case FAILED cause is: "+result.getThrowable());
		  }
	 
	 public void onTestSkipped(ITestResult result) {
		    test= extent.createTest(result.getName());
		    test.log(Status.SKIP, "Test case SKIPPED is: "+result.getName());
		  }
	 
	 public void onFinish(ITestContext context) {
		   extent.flush();
	  }

}
