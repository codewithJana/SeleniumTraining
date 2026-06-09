import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDowns {

    static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver(); //driver object created for Chrome browser
        driver.navigate().to("https://the-internet.herokuapp.com/dropdown"); //Launch App
        driver.manage().window().maximize(); //Maximize the browser

        WebElement dropdown = driver.findElement(By.id("dropdown"));

        Select options = new Select(dropdown);
        options.selectByIndex(1);
//        Thread.sleep(2000);
        options.selectByValue("2");
//        Thread.sleep(2000);
        options.selectByVisibleText("Option 1");
//        Thread.sleep(2000);

        driver.navigate().to("https://www.qa-practice.com/elements/select/single_select");

        WebElement lang_dropdown = driver.findElement(By.name("choose_language"));
        Select lang_options = new Select(lang_dropdown);

        lang_options.selectByIndex(1);
        Thread.sleep(2000);
        lang_options.selectByValue("2");
        Thread.sleep(2000);
        lang_options.selectByVisibleText("JavaScript");
        Thread.sleep(2000);
        lang_options.selectByVisibleText("Java");
        Thread.sleep(2000);
        lang_options.selectByValue("5");

        Thread.sleep(2000);

       driver.navigate().to("https://demoqa.com/select-menu");

       WebElement cars_dropdown = driver.findElement(By.id("cars"));
       Select car_options = new Select(cars_dropdown);
        car_options.selectByIndex(0);
        Thread.sleep(2000);
        car_options.selectByValue("audi");
        Thread.sleep(2000);
        car_options.selectByVisibleText("Opel");
        Thread.sleep(2000);

        car_options.deselectByIndex(0);
        Thread.sleep(1000);
        car_options.deselectByValue("audi");
        Thread.sleep(1000);
        car_options.deselectByVisibleText("Opel");

        car_options.selectByIndex(0);
        Thread.sleep(2000);
        car_options.selectByValue("audi");
        Thread.sleep(2000);
        car_options.selectByVisibleText("Opel");
        Thread.sleep(2000);

        car_options.deselectAll();






        driver.quit();


    }

}
