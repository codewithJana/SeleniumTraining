package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumAssignment1 {
    static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        String Users = driver.findElement(By.id("login_credentials")).getText();
        // System.out.println(driver.getTitle());
        String[] userList =Users.split("\n");
        String username = userList[1];
        driver.findElement(By.id("user-name")).sendKeys(username);
        String password = driver.findElement(By.id("password")).getText();
        //System.out.println(driver.getTitle());
        String[] passwordList = password.split("\n");
        String password1 = passwordList[0];
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        System.out.println(driver.getTitle());
        driver.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(2000);
        String Web1 =  driver.findElement(By.id("inventory_sidebar_link")).getText();
        System.out.println(Web1);
        String Web2 =  driver.findElement(By.id("about_sidebar_link")).getText();
        System.out.println(Web2);
        String Web3 =  driver.findElement(By.id("reset_sidebar_link")).getText();
        System.out.println(Web3);
        String Web4 = driver.findElement(By.id("logout_sidebar_link")).getText();
        System.out.println(Web4);

        driver.findElement(By.id("logout_sidebar_link")).click();

        Thread.sleep(2000);
        driver.quit();

    }
}
