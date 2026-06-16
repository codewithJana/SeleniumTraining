package Assignments.Q1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class SwagLabs_Application {

    static void main(String[] args) throws InterruptedException {

        WebDriver driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);

        // Enter username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        // Enter password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // Now click login button
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

        System.out.println("Page title is: " + driver.getTitle());

        String PageText = driver.findElement(By.className("title")).getText();
        System.out.println("Page Sub-title is: " + PageText);

        driver.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(2000);
        String PageText2 = driver.findElement(By.id("inventory_sidebar_link")).getText();
        System.out.println("1st Menu: " + PageText2);

        String PageText3 = driver.findElement(By.id("about_sidebar_link")).getText();
        System.out.println("2nd Menu: " + PageText3);

        String PageText4 = driver.findElement(By.id("logout_sidebar_link")).getText();
        System.out.println("3rd Menu: " + PageText4);

        String PageText5 = driver.findElement(By.id("reset_sidebar_link")).getText();
        System.out.println("4th Menu: " + PageText5);

        driver.findElement(By.id("logout_sidebar_link")).click();
        Thread.sleep(2000);

        String currentUrl = driver.getCurrentUrl();
        System.out.println("Log out successful & the current url is: " + currentUrl);

        driver.quit();

    }
}