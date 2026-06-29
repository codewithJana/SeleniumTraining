package seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SauceLoginTest {

    static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--guest");
        //options.addArguments("--start-maximized");
        //options.addArguments("--incognito");
        //options.addArguments("--headless");

        //Launch App
        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("https://www.saucedemo.com/");
        //Login Application
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        //Print Title
        String swagLabs_title = driver.findElement(By.className("app_logo")).getText();
        System.out.println(swagLabs_title);
        Thread.sleep(5000);
        //Kill browser & driver
        driver.quit();

    }

}
