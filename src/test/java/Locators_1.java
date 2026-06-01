import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators_1 {

    static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/login");

        driver.manage().window().maximize();

        /*
        Locators in Selenium
        1. Id
        2. Name
        3. TagName
        4. ClassName
        5. LinkText
        6. Partial linktext
        7. Xpath
        8. CSS Selector
         */

        String PageText = driver.findElement(By.tagName("h2")).getText();
        System.out.println(PageText);

        WebElement userNameField = driver.findElement(By.id("username"));
        userNameField.click();
        userNameField.sendKeys("khjh");
        userNameField.clear();
        userNameField.sendKeys("tomsmith");

        //another way of writing
//        driver.findElement(By.id("username")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.id("username")).sendKeys("jana");
//        Thread.sleep(2000);
//        driver.findElement(By.id("username")).clear();
//        Thread.sleep(2000);
//        driver.findElement(By.id("username")).sendKeys("tomsmith");
        Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        Thread.sleep(2000);
        driver.findElement(By.className("radius")).click();

        Thread.sleep(5000);
        driver.quit();


    }

}
