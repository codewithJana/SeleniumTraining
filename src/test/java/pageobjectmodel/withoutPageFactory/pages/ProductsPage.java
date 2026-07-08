package pageobjectmodel.withoutPageFactory.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    WebDriver driver;

    //Define locator
    By swagLabsTitle = By.className("app_logo");

    //Define Behavior
    public String getSwagLabsTitle(){
        String swagLabs_title = driver.findElement(swagLabsTitle).getText();
        return swagLabs_title;
    }

    //Define how to get use the browser
    public ProductsPage(WebDriver driver){
        this.driver = driver;
    }


}
