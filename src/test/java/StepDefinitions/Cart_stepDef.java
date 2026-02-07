package StepDefinitions;


import HooksPackage.Hooks;
import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.LocationSelectionPage;
import Pages.ProductsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import static HooksPackage.Hooks.driver;

public class Cart_stepDef {
    LocationSelectionPage locationSelectionPage=new LocationSelectionPage(driver);
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;



    @Given("user removes one item")
    public void userRemovesOneItem(){
        cartPage.removeProductFromCart();
    }

    @And("user increments an item quantity by 1")
    public void userIncrementsAnItemBy1() throws InterruptedException {
        Thread.sleep(2000);
        cartPage.increaseItemQuantity();
    }

    @When("user is on the cart page")
    public void userIsOnTheCartPage() throws InterruptedException {
        Thread.sleep(2500);
        cartPage=productsPage.clickCartIcon();
    }

    @Given("user has an item selected from products page")
    public void hasAnItemSelected() {
        productsPage.selectProductFromProductsPage();
    }

    @Then("the item count should be 2")
    public void theItemCountShouldBe2() {
        Assert.assertTrue(cartPage.getActualQuantity().contains(cartPage.expectedQuantityAfterAdding()));
    }

    @And("user decrements an item quantity by 1")
    public void userDecrementsAnItemBy1() {
        cartPage.decreaseItemQuantity();
    }

    @Then("the item count should be 1")
    public void theItemCountShouldBe1() {
        Assert.assertTrue(cartPage.getActualQuantity().contains(cartPage.expectedQuantityAfterDeleting()));
    }

    @And("user removes the last item")
    public void userRemovesTheLastItem() {
        cartPage.removeProductFromCart();
    }

    @Then("a message \"Your Cart is Empty\" is displayed")
    public void aMessageIsDisplayedYourCartIsEmpty() {
        Assert.assertTrue(cartPage.getEmptyCartText().contains("Your Cart is Empty"));
    }

    @Then("the other item is not removed")
    public void theOtherItemIsNotRemoved() {
        Assert.assertFalse(cartPage.getProductCount().contains("Your Cart is Empty"));
    }

    @Given("user adds an item to the cart")
    public void userAddsAnItemToTheCart() {
        productsPage.selectProductFromProductsPage();
    }

    @Then("subtotal and total contain \"EGP\"")
    public void subtotalAndTotalContainEGP() {
        Assert.assertTrue(cartPage.getSubtotal().contains("EGP"));
        Assert.assertTrue(cartPage.getTotal().contains("EGP"));
    }

    @And("user clicks on \"Checkout\" button")
    public void userClicksOnButtonCheckout() {
        checkoutPage=cartPage.clickCheckoutButton();
    }

    @Then("user is redirected to checkout page")
    public void userIsRedirectedToCheckoutPage() {
        Assert.assertTrue(checkoutPage.getActualText().contains(checkoutPage.getExpectedText()));
    }

    @And("user clicks on \"Continue Shopping\" button")
    public void userClicksOnButtonContinueShopping() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 300);");
        productsPage=cartPage.clickContinueShopping();
    }

    @Then("user is redirected to products page")
    public void userIsRedirectedToProductsPage() {
        Assert.assertTrue(productsPage.getProductsPageText().contains(productsPage.getActualTextAfterBackToProducts()));
    }

    @And("user enters an invalid Promo code")
    public void userEntersAnInvalidPromoCode() throws InterruptedException {
        Thread.sleep(1000);
        cartPage.enterInvalidPromoCode();
    }

    @Then("an error message is displayed")
    public void anErrorMessageIsDisplayed() {
        Assert.assertTrue(cartPage.getActualErrorPromoTextLocator().contains("The promo code isn't valid. Verify the code and try again."));
    }

    @Given("user has selected their location")
    public void userHasSelectedTheirLocation() {
        locationSelectionPage = new LocationSelectionPage(driver);
        productsPage = locationSelectionPage.chooseLocation();
    }

    @When("user increments an item quantity by 1 while on the cart page")
    public void userIncrementsAnItemQuantityBy1WhileOnTheCartPage() throws InterruptedException {
        cartPage=productsPage.clickCartIcon();
        Thread.sleep(3000);
        cartPage.increaseItemQuantity();
    }

    @Given("user has 2 items selected from products page")
    public void userHas2ItemsSelectedFromProductsPage() throws InterruptedException {
        productsPage.selectProductFromProductsPage();
        Thread.sleep(3000);
        productsPage.select2ndProductFromProductsPage();
    }
}

