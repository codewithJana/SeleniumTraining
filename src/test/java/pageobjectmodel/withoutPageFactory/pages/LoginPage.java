package pageobjectmodel.withoutPageFactory.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    //Define locators
    By username_field = By.id("user-name");
    By password_field = By.id("password");
    By loginButton = By.id("login-button");

    //Define the behaviors
    public void enterUsername(String username){
        driver.findElement(username_field).sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(password_field).sendKeys(password);
    }

    public void clickButton(){
        driver.findElement(loginButton).click();
    }

    public void loginApplication(String username, String password){
       enterUsername(username);
       enterPassword(password);
       clickButton();
    }

    //Define how to get use the browser
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }


}
