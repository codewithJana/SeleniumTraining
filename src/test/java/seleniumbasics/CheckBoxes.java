package seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxes {
    static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver(); //driver object created for Chrome browser
        driver.navigate().to("https://the-internet.herokuapp.com/checkboxes"); //Launch App
        driver.manage().window().maximize(); //Maximize the browser

        //(//input[@type='checkbox'])[1]

        List<WebElement> checkboxes = driver.findElements(By.xpath("//input"));

        System.out.println(checkboxes.size());

        WebElement checkBox1 = checkboxes.get(0);
        if(!checkBox1.isSelected()){
                checkBox1.click();
        }

        WebElement checkBox2 = checkboxes.get(1);
        if(!checkBox2.isSelected()){
            checkBox2.click();
        }

        checkBox1.click();

        Thread.sleep(5000);

        driver.navigate().to("https://www.qa-practice.com/elements/checkbox/mult_checkbox");

        driver.findElement(By.id("id_checkboxes_0")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("id_checkboxes_1")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("id_checkboxes_2")).click();
        Thread.sleep(1000);

        Thread.sleep(5000);
        driver.quit();
    }
}
