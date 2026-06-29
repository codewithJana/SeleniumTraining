package seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton {

    static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver(); //driver object created for Chrome browser
        driver.navigate().to("https://demoqa.com/automation-practice-form"); //Launch App
        driver.manage().window().maximize(); //Maximize the browser

        driver.findElement(By.id("gender-radio-1")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value='Female']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("gender-radio-3")).click();

        Thread.sleep(2000);

        driver.quit();


    }
}
