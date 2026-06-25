package TestNG.withTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class OrangeHRMLoginTests {

    private String BASE_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
        //setup browsers,Initiate Reports, browser binaries
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
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }
    @BeforeGroups
    public void beforeGroup(){
        System.out.println("Before Group");
    }
    @AfterGroups
    public void afterGroup(){
        System.out.println("After Group");
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
    public void tearDown(){
        System.out.println("After Method");
        driver.quit();
    }

    @Test(description = "Verify valid login test")
    public void testValidLogin(){
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
        softAssert.assertEquals(ActualLabel,ExpectedLabel);

        //Assert.assertEquals(ActualLabel,ExpectedLabel,"Verify Dashboard is displayed"); // Hard Assertion
        WebElement userName = driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']"));
        String ActualuserName = userName.getText();
        String ExpecteduserName = "AdminAuto Users";
        //Assert.assertEquals(ActualLabel,ExpectedLabel,"Verify UserName is Matched");  // Hard Assertion
        softAssert.assertEquals(ActualuserName,ExpecteduserName);
        System.out.println("testCompleted");
        softAssert.assertAll();


    }
    @Test(enabled = false)
    public void testInValidLogin(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("InvalidUser");
        driver.findElement(By.name("password")).sendKeys("invalid123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebElement errorAlert = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".oxd-alert-content-text")));
        String errorMessage = errorAlert.getText();
        if (!errorMessage.equals("Invalid credentials")) {
            throw new AssertionError("Expected error message 'Invalid credentials' but got: " + errorMessage);
        }
    }
    @Test(dependsOnMethods = "testValidLogin",alwaysRun = true )
    public void testLogout(){
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

    @Test(enabled = false)
    public void testSearchUser(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // Navigate to Admin Module
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, 'viewAdminModule')]")))
                .click();

        // Enter search term
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//label[text()='Username']/parent::div/following-sibling::div/input"))).sendKeys("Admin");

        // Click Search
        driver.findElement(By.xpath("//button[@type='submit'][contains(., 'Search')]")).click();

        // Sleep to let results load
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Validate table results
        List<WebElement> rows = driver.findElements(By.cssSelector(".oxd-table-row"));
        boolean userFound = false;
        for (WebElement row : rows) {
            String rowText = row.getText();
            if (rowText.contains("Admin") && !rowText.contains("User Role")) {
                userFound = true;
                break;
            }
        }
        if (!userFound) {
            throw new AssertionError("User 'Admin' was not found in the search results.");
        }
    }

}
