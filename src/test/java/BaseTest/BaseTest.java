package BaseTest;

import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.LocationSelectionPage;
import Pages.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.Locale;

public class BaseTest {
    protected WebDriver driver;
    protected LocationSelectionPage locationSelectionPage;
    protected ProductsPage productsPage;
    protected CartPage cartPage;
    protected CheckoutPage checkoutPage;


    @BeforeClass
    public void setup(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        locationSelectionPage = new LocationSelectionPage(driver);
    }

    @BeforeMethod
    public void goToHomePage() throws InterruptedException {
        Thread.sleep(3000);
        driver.get("https://seoudisupermarket.com/en/select-store");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
