package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    WebDriver driver;

    By checkoutPageLocator = By.xpath("//h1[contains(text(),'Checkout')]");
    String expectedText="Checkout";

    public CheckoutPage(WebDriver driver){
        this.driver=driver;
    }

    public String getActualText(){
        return driver.findElement(checkoutPageLocator).getText();
    }

    public String getExpectedText() {
        return expectedText;
    }
}
