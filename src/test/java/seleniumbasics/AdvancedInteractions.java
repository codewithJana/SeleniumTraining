package seleniumbasics;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class AdvancedInteractions {

    static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver(); //driver object created for Chrome browser
        Actions action =new Actions(driver);
        /*
        driver.navigate().to("https://the-internet.herokuapp.com/hovers"); //Launch App
        driver.manage().window().maximize(); //Maximize the browser

        Thread.sleep(5000);
        //Mouse hover the user image
        String userNumber = "user1";
        WebElement user = driver.findElement(By.xpath("//h5[text()='name: "+userNumber+"']//parent::div//preceding-sibling::img"));



        action.moveToElement(user).perform();

        Thread.sleep(5000);
        //rightclick (context click)
        driver.navigate().to("https://the-internet.herokuapp.com/context_menu");
        WebElement box = driver.findElement(By.id("hot-spot"));

        action.contextClick(box).perform();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        Thread.sleep(3000);


        //drag and drop the element from source to target
        driver.navigate().to("https://the-internet.herokuapp.com/drag_and_drop");
        Thread.sleep(3000);
        WebElement source = driver.findElement(By.id("column-a"));
        WebElement target = driver.findElement(By.id("column-b"));
        //option-1
        action.dragAndDrop(source,target).perform();
        Thread.sleep(3000);
        //option-2
        action.clickAndHold(source).
                moveToElement(target).
                release().perform();

        //wait for some action to perform
        driver.navigate().to("https://the-internet.herokuapp.com/jqueryui/menu");
        Thread.sleep(3000);
        WebElement Enabledlink = driver.findElement(By.xpath("//a[text()='Enabled']"));
        WebElement Downloadlink = driver.findElement(By.xpath("//a[text()='Downloads']"));
        WebElement Excellink = driver.findElement(By.xpath("//a[text()='Excel']"));
        action.moveToElement(Enabledlink).
                pause(Duration.ofSeconds(2)).
                moveToElement(Downloadlink).
                pause(Duration.ofSeconds(2)).
               click(Excellink).perform();



        //movebyoffset(x,y) --> movebyoffset(100,20)
        //action.doubleClick()


        //Keyboard interactions
        driver.navigate().to("https://the-internet.herokuapp.com/key_presses?");
        Thread.sleep(3000);
        action.sendKeys(Keys.BACK_SPACE).perform();
        System.out.println(driver.findElement(By.id("result")).getText());

        action.keyDown(Keys.CONTROL).
                sendKeys("a").
                keyUp(Keys.CONTROL).
                perform();

        System.out.println(driver.findElement(By.id("result")).getText());
         */

        driver.navigate().to("https://www.amazon.in/");
        Thread.sleep(3000);
        WebElement searchfield = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        action.moveToElement(searchfield).
                click(searchfield).pause(Duration.ofSeconds(2)).
                sendKeys(searchfield,"laptops").pause(Duration.ofSeconds(2)).
                sendKeys(Keys.ENTER).
                perform();
        Thread.sleep(3000);
        driver.quit();



    }

}
