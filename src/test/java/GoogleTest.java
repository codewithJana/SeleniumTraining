import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {

    // Browser & Navigation commands
    static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login"); //basic Navigation
//        Thread.sleep(2000);
        driver.navigate().to("https://www.saucedemo.com/"); //Advanced Navigation
//        Thread.sleep(1000);
        driver.navigate().back(); // Navigate to back page
//        Thread.sleep(1000);
        driver.navigate().forward(); // Navigate to forward page
//        Thread.sleep(1000);
        driver.navigate().refresh(); // Refresh the current page
        driver.manage().window().fullscreen(); //minimize the browser
//        Thread.sleep(1000);
        driver.manage().window().minimize(); //minimize the browser
//        Thread.sleep(1000);
        driver.manage().window().maximize(); //Maximize the browser
//        Thread.sleep(1000);
        Dimension size = driver.manage().window().getSize(); //get the dimensions of current browser window
//        System.out.println("Width of browser window: "+ size.getWidth());
//        System.out.println("Height of browser window: "+ size.getHeight());
        //driver.manage().window().setSize(new Dimension(800,600)); //custom re-size window
        Thread.sleep(2000);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://the-internet.herokuapp.com/login");
        Thread.sleep(5000);
        System.out.println("First Page title is: " + driver.getTitle()); //return the current page title
        System.out.println("Current URL: "+ driver.getCurrentUrl()); //return the current page URL
        System.out.println("Current Page Source: "+ driver.getPageSource()); //return the current page source
        driver.quit();
    }

}
