package myProjectInTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class OrangeHRMLoginTest extends BaseTest {

    /*
     {"Admin","wrongpassword"},
     {"invalidUser","wrongpassword2"},
     {"baseUser","wrongpassword3"},
     int[][] num = new int[][] {
     {1,2,3},
     {1,2,3},
     {1,2,4}
     */

    /*
    Excel:
     1. Define excel path
     2. utility of excel and get the row and column count
     3. object[row][column]
     4. get the value from excel
     5. retrun from getInvalidLoginData method
     */
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

/*
Data Provider --> it supplies multiple rows of data to one test method
DataProvider --> Object[][] -->TestNG -->Test Method --> Execute Multiple times

excel for testdata --> download excel libraries(maven repo),create excel object(utility clasS), return the row vaue

Feature                 |       @Parameter      |       @DataProviders
Data source             |       testng.xml      |           Java Method
Multiple Rows           |       No              |           Yes
Execution Count         |       Once            |           Multiple execution
Best use                |       Browser,URL,Env |           all testdata needed for testcases
Framework usage         |       Configuration   |           testdata
Can read external Data Source|  No              |           Yes (excel, xml, csv, Database, API...)
Return Type             |       Direct param    |           object[][]

 */
