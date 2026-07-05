package testNGListeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentManager implements ITestListener {

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;

    public void onStart(ITestContext context) {
            sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/myReport.html");
            sparkReporter.config().setDocumentTitle("Test Automation report");
            sparkReporter.config().setReportName("Web tetsing");
            sparkReporter.config().setTheme(Theme.DARK);

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

            extent.setSystemInfo("computerName","JanaMachine");
            extent.setSystemInfo("Env","QA");
            extent.setSystemInfo("SuiteName",context.getName());
            extent.setSystemInfo("TesterName","Jana");
            extent.setSystemInfo("Browser","Chrome");

    }

    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.PASS,"Test: " + result.getName() +" is Passed ");
    }

    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.FAIL,"Test: " + result.getName() +" is Failed ");
        test.log(Status.FAIL,"Cause of failue is " + result.getThrowable());
    }

    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.SKIP,"Test: " + result.getName() +" is Skipped ");
    }

    public void onFinish(ITestContext context) {
        extent.flush();
    }


}
