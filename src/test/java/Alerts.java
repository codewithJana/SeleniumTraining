import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

    static void main(String[] args) throws InterruptedException {



        WebDriver driver = new ChromeDriver(); //driver object created for Chrome browser
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts"); //Launch App
        driver.manage().window().maximize(); //Maximize the browser

        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        //Alert alert = driver.switchTo().alert();
        System.out.println(driver.switchTo().alert().getText());
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        //alert.dismiss();
        //driver.switchTo().alert().accept();
        driver.switchTo().alert().accept();
        System.out.println(driver.findElement(By.id("result")).getText());

        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("Hi, I am Jana");
        driver.switchTo().alert().accept();

        System.out.println(driver.findElement(By.id("result")).getText());
        driver.quit();

    }

}
