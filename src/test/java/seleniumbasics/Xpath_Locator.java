package seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpath_Locator {

    static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();


        driver.findElement(By.xpath("(//button[@type='button' and text()='Test Cases'])")).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
        Thread.sleep(3000);
        //New user Signup
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("testuser1101");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("testuser1101@gmail.com");
        driver.findElement(By.xpath("//button[text()='Signup']")).click();
        Thread.sleep(3000);
        String enterAccount_label = driver.findElement(By.xpath("//b[contains(text(),'Enter Account')]")).getText();
        System.out.println(enterAccount_label);

        driver.quit();
    }
}
