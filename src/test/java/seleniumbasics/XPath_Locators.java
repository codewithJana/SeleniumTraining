package seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

 /*
    restructure needed to use methods for handling the repetitive code
 */

public class XPath_Locators {

    /*
    XPATH LOCATORS:
    1. relative XPATH: //tagname[@attribute='value']
        a. //tagname
        b. //tagname[@attribute='value']
        c. //tagname[text()='value'] --> function based XPATH
        d. //tagname[contains(@attribute,'value')] --> function based XPATH
        e. //tagname[contains(text(),'value')] --> function based XPATH
        f. //tagname[contains(text(),'value') or @attribute='value'] --> function based XPATH
        g. //tagname[normalize-space(text())='value'] --> function based XPATH
    2. Absolute XPATH: /html/body/div[2]/div/div/form/div
     */
    static void main(String[] args) throws InterruptedException {

        //Launch App
        WebDriver driver = new ChromeDriver(); //driver object created for Chrome browser
        driver.navigate().to("https://the-internet.herokuapp.com/"); //Launch App
        driver.manage().window().maximize(); //Maximize the browser

        //print welcome to internet text
        String welcomeText =  driver.findElement(By.xpath("//h1")).getText();
        System.out.println(welcomeText);

        //click on dropdown link using href attribute
        driver.findElement(By.xpath("//a[@href='/dropdown']")).click();
        Thread.sleep(2000);
        String dropdownText = driver.findElement(By.xpath("//h3")).getText();
        System.out.println("print text using href attribute: " + dropdownText);

        //go back to home page
        driver.navigate().back();

        //click on dropdown link using link text
        driver.findElement(By.xpath("//a[text()='Dropdown']")).click();
        Thread.sleep(2000);
        String dropdownText2 = driver.findElement(By.xpath("//h3")).getText();
        System.out.println("print text using link text: " + dropdownText2);

        //go back to home page
        driver.navigate().back();

        //click on file download link using function based XPATH
        driver.findElement(By.xpath("//a[contains(text(),'Download') and @href='/download']")).click();
        Thread.sleep(2000);
        String filedownloadText = driver.findElement(By.xpath("//h3")).getText();
        System.out.println("print text using function based XPATH: " + filedownloadText);

        //go back to home page
        driver.navigate().back();

        //click on dynamicControl link using function based XPATH
        driver.findElement(By.xpath("//a[contains(@href,'controls')]")).click();
        Thread.sleep(2000);
        String dynamicControlText = driver.findElement(By.xpath("//h4")).getText();
        System.out.println("print text using attribute based XPATH: " + dynamicControlText);

        driver.navigate().to("https://automationexercise.com/");
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
        Thread.sleep(2000);

        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();


        Thread.sleep(2000);
        driver.quit();//Kill browser & driver


    }
}
