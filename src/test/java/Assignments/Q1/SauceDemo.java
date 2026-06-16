package Assignments.Q1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemo {
    static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        String pageUrl = "https://www.saucedemo.com/";
        driver.get(pageUrl);
        driver.manage().window().maximize();
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        Thread.sleep(1000);

        String Usernames = driver.findElement(By.id("login_credentials")).getText();

        String[] User = Usernames.split("\n");
        String uname = User[1];

        String password = driver.findElement(By.className("login_password")).getText();
        String[] pwd = password.split("\n");
        String login_password = pwd[1];
        //System.out.println(login_password);
        driver.findElement(By.id("user-name")).sendKeys(uname);
        driver.findElement(By.id("password")).sendKeys(login_password);
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(5000);
        String appName =  driver.findElement(By.className("app_logo")).getText();
        System.out.println(appName);
        String name = driver.findElement(By.className("title")).getText();
        System.out.println(name);
        driver.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(2000);
        String menus = driver.findElement(By.className("bm-item-list")).getText();
        System.out.println(menus);
        driver.findElement(By.id("logout_sidebar_link")).click();
        String getUrl = driver.getCurrentUrl();
        if(getUrl.equals(pageUrl))
        {
            System.out.println("user Logged out successfully");
        }
        else
        {
            System.out.println("Mismatch with login page URL");
        }

        driver.quit();

    }


}
