package pageobjectmodel.pagefactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_a {

    WebDriver driver;

    //Define locator and find element
    @FindBy(id = "user-name")
    WebElement username_field;
    //WebElement username_field = driver.findElement(By.id("user-name"))

    @FindBy(id = "password")
    WebElement password_field;

    @FindBy(id = "login-button")
    WebElement login_button;


    //Design business flow
    public void loginApplication(String username, String password){
        username_field.sendKeys(username);
        password_field.sendKeys(password);
        login_button.click();
    }


    //Define how to get use the browser
    public LoginPage_a(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
