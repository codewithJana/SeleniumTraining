import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class WindowHandles {

    static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        System.out.println(driver.getWindowHandle());
        String parentTab = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://sauce-demo.myshopify.com/");
        System.out.println(driver.getWindowHandle());
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://google.com");
        System.out.println(driver.getWindowHandle());
        Set<String> windows = driver.getWindowHandles();
        for (String win : windows) {
            driver.switchTo().window(win);
            System.out.println(driver.getTitle());
        }
        driver.switchTo().window(parentTab);
        System.out.println(driver.getTitle());
        driver.quit();

    }

}
