package testNGListeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListeners implements ITestListener {

    public void onStart(ITestContext context) {
        System.out.println("On start...");
    }

    public void onFinish(ITestContext context) {
        System.out.println("On Finish...");
    }
    public void onTestStart(ITestResult result) {
        System.out.println("Testcase execution is started.");

    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Testcase is Passsed");

    }

    public void onTestFailure(ITestResult result) {
        System.out.println("Testcase is failed");
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("Testcase is Skipped");
    }

}
