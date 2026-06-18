package Assignments.Q2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class Automation_Practise {
    static void main(String[] args) throws InterruptedException {

        //Launch URl
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://automationexercise.com/");
        driver.manage().window().maximize();

        System.out.println("Launched Application");

        //Locator for signup/login
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        System.out.println("Signup/Login successfully");

        //Locator for New user signup
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("Rahul");

        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("mosami20@gmail.com");
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        System.out.println("New User Signin done");

        //Selecting Radio button
        driver.findElement(By.xpath("//input[@value='Mr']")).click();
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("success");
        System.out.println("Selected radio button Mr");

        //Selecting Date
        WebElement dropdown_date = driver.findElement(By.id("days"));
        Select select_date = new Select(dropdown_date);
        select_date.selectByVisibleText("15");

        //Selecting Month
        WebElement dropdown_month=driver.findElement(By.id("months"));
        Select select_month= new Select(dropdown_month);
        select_month.selectByVisibleText("March");

        //Selecting Year
        WebElement dropdown_year=driver.findElement(By.id("years"));
        Select select_year= new Select(dropdown_year);
        select_year.selectByValue("2000");
        System.out.println("Selected DOB");


        //Entering Address
        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Rahul");
        driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Patil");
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys("TCS");
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Hinjewadi");
        driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("Pune");
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Maharashtra");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Pune");
        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("411001");
        driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("9999999999");
        System.out.println("Address details entered");
        // driver.findElement(By.xpath("//button[@class='btn btn-default' and @data-qa='create-account']")).click();

        //CLick on create button
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement createAccount =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                By.xpath("//button[@class='btn btn-default' and @data-qa='create-account']")
                        )
                );
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                createAccount);

        createAccount.click();

        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

        //Check if logged in as Rahul
        String first_name="Rahul";
        String actualText = driver.findElement(By.xpath("//li/a/b")).getText();

        if(actualText.equals(first_name)){
            System.out.println("Welcome "+first_name+", You have Successfully logged in");
        }

        driver.quit();
    }
}