import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locator_2 {

    static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();


        driver.get("https://the-internet.herokuapp.com");

        driver.manage().window().maximize();

        //driver.findElement(By.linkText("File Download")).click();
        System.out.println(driver.findElement(By.partialLinkText("Floating")).getText());
        driver.findElement(By.partialLinkText("Floating")).click();

        Thread.sleep(5000);
        String input_label = driver.findElement(By.tagName("h3")).getText();
        System.out.println(input_label);

        driver.quit();

    }

}
