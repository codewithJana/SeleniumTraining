package pageobjectmodel.withoutPageFactory.tests;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import pageobjectmodel.withoutPageFactory.pages.LoginPage;
import pageobjectmodel.withoutPageFactory.pages.ProductsPage;

@Slf4j
public class TestSuite_1 {

    WebDriver driver;
    LoginPage login = new LoginPage(driver);
    ProductsPage product =  new ProductsPage(driver);

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
