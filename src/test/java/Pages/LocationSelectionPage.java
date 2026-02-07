package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LocationSelectionPage {
    WebDriver driver;
    WebDriverWait wait;

    By closeButtonLocator = By.cssSelector("button[aria-label='close']");
    By cityElementLocator = By.id("city");
    By cairoOptionLocator = By.xpath("//option[contains(text(),'Cairo')]");
    By selectAreaLocator = By.id("area");
    By firstAreaOptionLocator = By.xpath("//select[@id='area']/option[2]");
    By selectDistrictLocator = By.id("district");
    By firstDistrictOptionLocator =  By.xpath("//select[@id='district']/option[2]");
    By continueButtonLocator =  By.xpath("//button[contains(text(),'Continue to shop')]");

    public LocationSelectionPage(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public ProductsPage chooseLocation(){
        driver.findElement(closeButtonLocator).click();

        driver.findElement(cityElementLocator).click();
        wait.until(ExpectedConditions.elementToBeClickable(cairoOptionLocator)).click();

        driver.findElement(selectAreaLocator).click();
        wait.until(ExpectedConditions.elementToBeClickable(firstAreaOptionLocator)).click();

        driver.findElement(selectDistrictLocator).click();
        wait.until(ExpectedConditions.elementToBeClickable(firstDistrictOptionLocator)).click();

        wait.until(ExpectedConditions.elementToBeClickable(continueButtonLocator)).click();

        return new ProductsPage(driver);
    }
}
