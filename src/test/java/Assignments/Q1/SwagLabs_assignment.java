package Assignments.Q1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwagLabs_assignment {
    static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);
        driver.manage().window().maximize();
        Thread.sleep(2000);

        //for capturing username
        WebElement username = driver.findElement(By.id("user-name")) ;
        username.sendKeys("standard_user");
        Thread.sleep(2000);

        //for capturing password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        Thread.sleep(2000);

        //For login
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);
        // print the title on page
        String title = driver.findElement(By.className("app_logo")).getText();
        System.out.println(title);

        String Product = driver.findElement(By.className("title")).getText();
        System.out.println(Product);

        //For clicking on menu
        driver.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(2000);

// printing all menu items
        String Firstoption = driver.findElement(By.id("inventory_sidebar_link")).getText();
        System.out.println(Firstoption);

        String Secondoption = driver.findElement(By.id("about_sidebar_link")).getText();
        System.out.println(Secondoption);
        Thread.sleep(2000);

        String Thirdoption = driver.findElement(By.id("logout_sidebar_link")).getText();
        System.out.println(Thirdoption);
        Thread.sleep(2000);

        String Fourthoption = driver.findElement(By.id("reset_sidebar_link")).getText();
        System.out.println(Fourthoption);
        Thread.sleep(2000);

        // clicking on logout
        WebElement Logout = driver.findElement(By.id("logout_sidebar_link"));
        Thread.sleep(2000);
        System.out.println("Current URL: "+ driver.getCurrentUrl()); //return the current page URL

        driver.quit();
    }
}
