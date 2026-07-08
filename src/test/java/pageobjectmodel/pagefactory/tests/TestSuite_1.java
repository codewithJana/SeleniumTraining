package pageobjectmodel.pagefactory.tests;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import pageobjectmodel.pagefactory.pages.LoginPage_a;
import pageobjectmodel.pagefactory.pages.ProductsPage_a;
import pageobjectmodel.withoutPageFactory.pages.LoginPage;
import pageobjectmodel.withoutPageFactory.pages.ProductsPage;

@Slf4j
public class TestSuite_1 {

    WebDriver driver;
    LoginPage_a login = new LoginPage_a(driver);
    ProductsPage_a product =  new ProductsPage_a(driver);

    @Test
    public void validLoginTest() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        //Launch App
        driver = new ChromeDriver(options);
        driver.navigate().to("https://www.saucedemo.com/");

        //Login Application
        login.loginApplication("standard_user","secret_sauce");
        System.out.println(product.getSwagLabsTitle());

        driver.quit();
    }

    @Test
    public void InvalidLoginTest() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        //Launch App
        driver = new ChromeDriver(options);
        driver.navigate().to("https://www.saucedemo.com/");

        //Login Application
        login.loginApplication("InvalidUser","secret_sauce");
        System.out.println(product.getSwagLabsTitle());

        driver.quit();
    }

}
