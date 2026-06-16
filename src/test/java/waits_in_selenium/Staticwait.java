package waits_in_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Staticwait {

    static void main(String[] args) throws InterruptedException {

        /* ----- without wait anonomously
        WebDriver driver = new ChromeDriver(); //driver object created for Chrome browser
        driver.navigate().to("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//button[text()='Start']")).click();
        Thread.sleep(10000);
        String finalmessage = driver.findElement(By.xpath("//h4[text()='Hello World!']")).getText();
        System.out.println(finalmessage);
        driver.quit();
         */



    }

}
