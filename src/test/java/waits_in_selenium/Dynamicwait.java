package waits_in_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Dynamicwait {

    /*
    1. Implicit wait --> apply globally, handle dynamic wait
    2. Explicit wait --> check specific conditions , apply on individual element level
     */
    static void main(String[] args) {

        WebDriver driver = new ChromeDriver(); //driver object created for Chrome browser

        //***************** Implicit wait***********************************************
        /*
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.navigate().to("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//button[text()='Start']")).click();
        String finalmessage = driver.findElement(By.xpath("//div[@id='finish' and @style='']/h4")).getText();
        System.out.println(finalmessage);
        driver.quit();*/

        //***************** Explicit wait***********************************************
       /* driver.navigate().to("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("start")));
        driver.findElement(By.xpath("//button[text()='Start']")).click();
        WebElement helloworldText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
        System.out.println(helloworldText.getText());
        WebElement Example1Text = driver.findElement(By.tagName("h3"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h3")));
        System.out.println(Example1Text.getText());
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        driver.quit();*/

        //***********************Fluent wait***************************************
        driver.navigate().to("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//button[text()='Start']")).click();
        FluentWait<WebDriver> wait = new FluentWait<>(driver).
                                                    withTimeout(Duration.ofSeconds(20)).
                                                    pollingEvery(Duration.ofMillis(1000));
        WebElement element = wait.until(driver1 -> {WebElement element1 = driver1.findElement(By.id("finish"));
                                                                                       return element1.isSelected() ? element1 : null; });
        System.out.println(element.getText());
        driver.quit();





    }
}
