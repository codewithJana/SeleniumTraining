package testNGListeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.time.Duration;

public class LoginTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    @Parameters({"browser","url"})
    public void setUp(@Optional("chrome") String browser, @Optional("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login") String url){
        System.out.println("Before Method");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");

        if(browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }else {
            driver = new ChromeDriver();  //default
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
    }
    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {

        System.out.println("After Method");
        driver.quit();
    }
    @DataProvider(name = "invalidLoginData")
    public Object[][] getInvalidLoginData() {
        return new Object[][]{
                {"Admin", "wrongpassword"},
                {"invalidUser", "wrongpassword2"},
                {"baseUser", "wrongpassword3"},
                {"testuser","wrongpwd"},
        };
    }


    @Test(priority = 1 )
    public void testValidLogin() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        /* --Without Assertion-------------
                    if(ActualLabel.equals(ExpectedLabel)){
                        System.out.println("Pass");
                    }else{
                System.out.println("Fail");
            }
         */

        SoftAssert softAssert = new SoftAssert();

        WebElement dashboardLabel = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
        String ActualLabel = dashboardLabel.getText();
        String ExpectedLabel = "Dashboard";
        softAssert.assertEquals(ActualLabel, ExpectedLabel);

        //Assert.assertEquals(ActualLabel,ExpectedLabel,"Verify Dashboard is displayed"); // Hard Assertion
        WebElement userName = driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']"));
        String ActualuserName = userName.getText();
        String ExpecteduserName = "AdminAuto User";
        //Assert.assertEquals(ActualLabel,ExpectedLabel,"Verify UserName is Matched");  // Hard Assertion
        softAssert.assertEquals(ActualuserName, ExpecteduserName);
        System.out.println("testCompleted");
        softAssert.assertAll();
    }

    @Test(priority = 2 , dataProvider = "invalidLoginData")
    public void testInValidLogin(String username, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebElement errorAlert = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".oxd-alert-content-text")));
        String errorMessage = errorAlert.getText();
        if (!errorMessage.equals("Fail testacse to capture screenshot")) {
            throw new AssertionError("Expected error message 'Invalid credentials' but got: " + errorMessage);
        }
    }

    @Test(priority = 3)
    public void testLogout() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // Click profile dropdown
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".oxd-userdropdown-tab"))).click();

        // Click Logout
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Logout']"))).click();

        // Wait for login page redirection URL
        wait.until(ExpectedConditions.urlContains("auth/login"));
        if (!driver.getCurrentUrl().contains("auth/login")) {
            throw new AssertionError("User was not redirected back to the login page after logging out.");
        }
    }

}

