package TestNG.withoutTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VerifyLogoutTest {
    static void main(String[] args) {
        String BASE_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(options);
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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
        driver.quit();

    }
}
