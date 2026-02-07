package HooksPackage;

import Pages.LocationSelectionPage;
import Pages.ProductsPage;
import com.google.j2objc.annotations.Weak;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hooks {
    public static WebDriver driver;
    ProductsPage productsPage;

    @Before
    public void setup(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://seoudisupermarket.com/en/select-store");
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
