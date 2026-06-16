package Assignments.Q1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SwagLabs_Application_1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        System.out.println("Title of the Page is:" + driver.getTitle());

        //To get the Url of the Page
        String URL1=driver.getCurrentUrl();
        System.out.println("Page Url is:"+URL1);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(5000);
        System.out.println("Title of the Page after login is:" + driver.getTitle());

        //To Find the Number of links in the Page
        List<WebElement> link = driver.findElements(By.tagName("a"));
        System.out.println("Number of links are:" + link.size());
        Thread.sleep(2000);

        //To find the number of products in the page
        List<WebElement> NumberOfProducts=driver.findElements(By.className("inventory_item_name"));
        System.out.println("Product links are:"+NumberOfProducts.size());

        //Click on Menu
        driver.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(2000);

        //All Links
        WebElement MenuItem1=driver.findElement(By.id("inventory_sidebar_link"));
        System.out.println(MenuItem1.getText());
        //About
        WebElement MenuItem2=driver.findElement(By.id("about_sidebar_link"));
        System.out.println(MenuItem2.getText());
        //Logout
        WebElement MenuItem3=driver.findElement(By.id("logout_sidebar_link"));
        System.out.println(MenuItem3.getText());
        //Reset
        WebElement MenuItem4=driver.findElement(By.id("reset_sidebar_link"));
        System.out.println(MenuItem4.getText());
        Thread.sleep(2000);

        //logout click
        MenuItem3.click();
        String URL2= driver.getCurrentUrl();
        System.out.println("URL after logout is:"+URL2);

        if(URL2.equals(URL1)){
            System.out.println("Logout Successful");
        }else{
            System.out.println("Logout Unsuccessful");
        }








        driver.quit();

    }
}
