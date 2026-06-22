package TestNG.withoutTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class VerifyAddNewEmployeeTest {
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

        // Navigate to PIM Module
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, 'viewPimModule')]"))).click();

        // Click Add Employee tab
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Add Employee']"))).click();

        // Input details
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName"))).sendKeys("John");
        driver.findElement(By.name("lastName")).sendKeys("Doe");

        // Click Save
        driver.findElement(By.xpath("//button[@type='submit'][contains(., 'Save')]")).click();

        // Wait for page redirection to details page
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Verify save
        List<WebElement> headings = driver.findElements(By.cssSelector("h6"));
        boolean detailsSaved = false;
        for (WebElement heading : headings) {
            if (heading.getText().trim().equals("John Doe")) {
                detailsSaved = true;
                break;
            }
        }
        if (!detailsSaved) {
            throw new AssertionError("Employee profile page did not display saved name 'John Doe'.");
        }
        driver.quit();

    }
}
