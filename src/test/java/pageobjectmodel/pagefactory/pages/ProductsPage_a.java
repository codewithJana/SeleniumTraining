package pageobjectmodel.pagefactory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage_a {

    WebDriver driver;

    @FindBy(className = "app_logo")
    WebElement swagLabsTitle;

    public String getSwagLabsTitle(){
        return swagLabsTitle.getText();
    }

    //Define how to get use the browser
    public ProductsPage_a(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
