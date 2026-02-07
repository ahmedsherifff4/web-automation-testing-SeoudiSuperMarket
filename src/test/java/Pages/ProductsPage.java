package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {
    WebDriver driver;
    WebDriverWait wait;

    By addToCartLocator = By.xpath("//button[@aria-label='Add to quantity']");
    By cartButtonLocator = By.cssSelector("div.Header__Lower ul.UserActions a[aria-label='cart']");
    By add2ndProductToCartLocator = By.xpath("(//button[@class='Increment'])[position()=2]");
    By backToProductsPageLocator = By.xpath("//button[contains(text(),'All categories')]");

    public String getActualTextAfterBackToProducts() {
        return actualTextAfterBackToProducts;
    }

    String actualTextAfterBackToProducts = "All categories";

    public ProductsPage(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public void selectProductFromProductsPage(){
        wait.until(ExpectedConditions.elementToBeClickable(addToCartLocator)).click();
    }

    public void select2ndProductFromProductsPage(){
        wait.until(ExpectedConditions.elementToBeClickable(add2ndProductToCartLocator)).click();
    }

    public CartPage clickCartIcon(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(cartButtonLocator)).click();
        return new CartPage(driver);
    }

    public String getProductsPageText(){
        return driver.findElement(backToProductsPageLocator).getText();
    }
}
