package testNGListeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportManager implements ITestListener {

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;

    public void onStart(ITestContext context){
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/mrReport.html");

        sparkReporter.config().setDocumentTitle("Automation Report");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("computerName","localhost");
        extent.setSystemInfo("Environment","QA");

    }

    public void onTestSuccess(ITestResult result){
        test = extent.createTest(result.getName());
        test.log(Status.PASS,"Testcase PASSED is "+ result.getName());
    }

    public void onTestFailure(ITestResult result){
        test = extent.createTest(result.getName());
        test.log(Status.PASS,"Testcase FAILED is "+ result.getName());
        test.log(Status.PASS,"Testcase FAILED cause is "+ result.getThrowable());
    }

    public void onFinish(ITestContext context){
        extent.flush();
    }


}
