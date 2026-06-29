package myProjectInTestNG;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

/*
 Why to use BaseTest class?
 1. DRY principle (Don't Repeat Yourself)
 2. Seperation of concerns --> testclasses are responsible for "what to test", BaseTest is responsible fir how the environment is
                                prepared and clean-up
 3. Centralized Maintenance
 4. Automated Hooking
 */
public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    String BASE_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
        //clear old screenshots
        File screenshotDir = new File(System.getProperty("user.dir") +"/screenshots/");
        if(screenshotDir.exists()){
            File[] files =  screenshotDir.listFiles();
            for(File file : files){
                file.delete();
            }
        }

    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
        //cleanup resources, generate Reports
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
        //prepare the parameters, test run env, database connection
    }
    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
        //prepare the clean-up test data, terminate database connection
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before class" + this.getClass().getSimpleName());
    }
    @BeforeMethod
    public void setUp(){
        System.out.println("Before Method");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicit wait
        driver.get(BASE_URL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //explicit wait
    }
    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        //capture screenshot
        if(ITestResult.FAILURE == result.getStatus()){
            takeScreenshot(result.getName());
        }
        System.out.println("After Method");
        driver.quit();
    }

    private void takeScreenshot(String testName) throws IOException {
        TakesScreenshot ss = (TakesScreenshot) driver;
        File screenshot = ss.getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyymmdd_HHmmss").format(new Date());
        String destinationPath = System.getProperty("user.dir") +"/screenshots/" + testName + "_"+ timestamp +".png";
        File destinationFile = new File(destinationPath);

        FileHandler.copy(screenshot,destinationFile);
    }
}
