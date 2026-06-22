package TestNG.withoutTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InvalidLoginTest {
    static void main(String[] args) {
        String BASE_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(options);
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("InvalidUser");
        driver.findElement(By.name("password")).sendKeys("invalid123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebElement errorAlert = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".oxd-alert-content-text")));
        String errorMessage = errorAlert.getText();
        if (!errorMessage.equals("Invalid credentials")) {
            throw new AssertionError("Expected error message 'Invalid credentials' but got: " + errorMessage);
        }
        driver.quit();

    }
}
