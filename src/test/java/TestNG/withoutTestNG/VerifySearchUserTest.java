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

public class VerifySearchUserTest {
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
        driver.quit();

    }
}
