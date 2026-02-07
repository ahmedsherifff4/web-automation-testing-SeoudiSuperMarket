package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static HooksPackage.Hooks.driver;
import static javax.swing.text.html.CSS.getAttribute;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait;

    By addQuantityLocator = By.xpath("//button[@aria-label='Add to quantity']");
    By removeFromQuantity = By.xpath("//button[@aria-label='Remove from quantity']");
    By quantityLocator= By.xpath("//input[@class='text-primary-700 font-bold bg-transparent py-1 w-full text-center text-lg']");
    By removeProductLocator = By.xpath("//button[contains(@class,'right-4')]");
    By emptyCartLocator = By.xpath("//p[normalize-space()='Your Cart is Empty']");
    By subtotalOfCartLocator = By.xpath("(//span[contains(text(),'EGP')])[position() =3]");
    By totalOfCartLocator = By.xpath("(//span[contains(text(),'EGP')])[position() =4]");
    By checkoutButtonLocator = By.xpath("//button[@class='AppButton mt-11 block w-full font-bold with-icon']");
    By continueShoppingLocator = By.xpath("//span[@class='ml-2']");
    By promoCodeDropdownButtonLocator = By.xpath("(//button[@type='button'])[position()=4]");
    By promoCodeInputLocator = By.xpath("//input[@id='promoCode']");
    By submitPromoCodeLocator = By.xpath("//button[@class='bg-secondary-700 absolute right-0 z-10']");
    By actualErrorPromoTextLocator = By.xpath("//label[@class='TextInput__error']");
    By productCountLocator = By.xpath("//p[contains(text(),'You have 1 product in your cart')]");
    String expectedQuantityAfterAdding="2";
    String expectedQuantityAfterDeleting="1";

    public CartPage(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getActualQuantity(){
        return driver.findElement(quantityLocator).getAttribute("value");
    }

    public String expectedQuantityAfterAdding(){
        return expectedQuantityAfterAdding;
    }

    public String expectedQuantityAfterDeleting(){
        return expectedQuantityAfterDeleting;
    }

    public void increaseItemQuantity()  {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addQuantityLocator)).click();
    }

    public void decreaseItemQuantity()  {
        wait.until(ExpectedConditions.elementToBeClickable(removeFromQuantity)).click();
    }

    public void removeProductFromCart(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".Alert.Alert--success")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".Alert.Alert--success")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".Alert.Alert--success")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".Alert.Alert--success")));
        wait.until(ExpectedConditions.elementToBeClickable(removeProductLocator)).click();
    }

    public String getEmptyCartText(){
        return driver.findElement(emptyCartLocator).getText();
    }

    public String getSubtotal(){
        return driver.findElement(subtotalOfCartLocator).getText();
    }

    public String getTotal(){
        return driver.findElement(totalOfCartLocator).getText();
    }

    public CheckoutPage clickCheckoutButton(){
        driver.findElement(checkoutButtonLocator).click();
        return new CheckoutPage(driver);
    }

    public ProductsPage clickContinueShopping(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 300);");
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingLocator)).click();
        return new ProductsPage(driver);
    }

    public void enterInvalidPromoCode(){
        driver.findElement(promoCodeDropdownButtonLocator).click();
        driver.findElement(promoCodeInputLocator).sendKeys("Te$t");
        driver.findElement(submitPromoCodeLocator).click();
    }

    public String getActualErrorPromoTextLocator() {
        return driver.findElement(actualErrorPromoTextLocator).getText();
    }

    public String getProductCount(){
        return driver.findElement(productCountLocator).getText();
    }
}
