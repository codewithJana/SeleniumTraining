import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AdvancedInteractions {

    static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver(); //driver object created for Chrome browser
        driver.navigate().to("https://the-internet.herokuapp.com/hovers"); //Launch App
        driver.manage().window().maximize(); //Maximize the browser

        Thread.sleep(5000);

        String userNumber = "user1";
        WebElement user = driver.findElement(By.xpath("//h5[text()='name: "+userNumber+"']//parent::div//preceding-sibling::img"));

        Actions action =new Actions(driver);

        action.moveToElement(user).perform();

        Thread.sleep(5000);

        driver.navigate().to("https://the-internet.herokuapp.com/context_menu");
        WebElement box = driver.findElement(By.id("hot-spot"));

        action.contextClick(box).perform();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        Thread.sleep(3000);


        driver.quit();

    }

}
