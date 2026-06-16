package Assignments.Q1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

//import static jdk.internal.agent.Agent.getText;

public class InternetTest
{
    static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/");
        //driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        //String loginLogo = "login_logo";
        String pageText=driver.findElement(By.xpath("//*[@id='root']/div/div[1]")).getText();
        System.out.println(pageText);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("login-button")).click();

        String pageText2=driver.findElement(By.xpath("//*[@id='header_container']/div[1]/div[2]/div")).getText();
        System.out.println(pageText2);

        driver.findElement(By.id("react-burger-menu-btn")).click();

        String pageText3=driver.findElement(By.id("inventory_sidebar_link")).getText();
        System.out.println(pageText3);

        String pageText4=driver.findElement(By.id("about_sidebar_link")).getText();
        System.out.println(pageText4);

        String pageText5=driver.findElement(By.id("logout_sidebar_link")).getText();
        System.out.println(pageText5);

        String pageText6=driver.findElement(By.id("reset_sidebar_link")).getText();
        System.out.println(pageText6);

        driver.findElement(By.id("logout_sidebar_link")).click();




        driver.quit();






    }
}