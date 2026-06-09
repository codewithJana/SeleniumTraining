package Assignments;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AssignmentSwagLab {
    static void main(String[] args) throws InterruptedException {

        WebDriver driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        Thread.sleep(1000);

        WebElement userNameField=driver.findElement(By.id("user-name"));
        userNameField.sendKeys("standard_user");
        Thread.sleep(1000);

        WebElement passwordField=driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");
        Thread.sleep(2000);

/*
       String Username= "standard_user";
       String Password = "secret_sauce";

       WebElement userNameField=driver.findElement(By.id("user_name"));
       userNameField.sendKeys(Username);
       WebElement passwordField=driver.findElement(By.id("password"));
       passwordField.sendKeys(Password);
*/

        driver.findElement(By.name("login-button")).click();
        Thread.sleep(2000);

        System.out.println("Page title is: " + driver.getTitle());

        String PageText=driver.findElement(By.className("title")).getText();
        System.out.println("Page Sub-title is: " + PageText);

        driver.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(2000);

        String PageText2=driver.findElement(By.id("inventory_sidebar_link")).getText();
        System.out.println("1st Menu: " + PageText2);

        String PageText3=driver.findElement(By.id("about_sidebar_link")).getText();
        System.out.println("2nd Menu: " + PageText3);

        String PageText4=driver.findElement(By.id("logout_sidebar_link")).getText();
        System.out.println("3rd Menu: " + PageText4);

        String PageText5=driver.findElement(By.id("reset_sidebar_link")).getText();
        System.out.println("4th Menu: " + PageText5);

        driver.findElement(By.id("logout_sidebar_link")).click();
        Thread.sleep(2000);

        String currentUrl=driver.getCurrentUrl();
        System.out.println("Log out successful & the current url is: " + currentUrl);

        driver.quit();



    }
}
