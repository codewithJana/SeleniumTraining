package TestNG;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class MyAppTest {

    @BeforeSuite
    public void setupEnvironment(){
        System.out.println("Environment setup : QA");
    }

    @AfterSuite
    public void GenerateReport(){
        System.out.println("Report Generated Successfully!!!");
    }

    @BeforeClass
    public void LaunchBrowser(){
        System.out.println("Browser Launched successfully!!!");
    }

    @AfterClass
    public void CloseBrowser(){
        System.out.println("Browser Terminated Successfully!!");
    }

    @BeforeMethod
    public void LoginApp(){
        System.out.println("Application login Successfull!!");
    }

    @AfterMethod
    public void Logout(){
        System.out.println("Application logout Successfull!!");
    }

    @Test
    public void searchProductTest(){
        System.out.println("Second testcase executed !!");
    }

    @Test
    public void creditCardpaymentTest(){
        System.out.println("First testcase executed !!");
    }

    @Test
    public void addToCartTest(){
        System.out.println("Third testcase executed !!");
    }

}
