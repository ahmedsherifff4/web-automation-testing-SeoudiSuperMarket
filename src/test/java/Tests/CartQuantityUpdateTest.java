package Tests;

import BaseTest.BaseTest;
import Pages.LocationSelectionPage;
import com.beust.ah.A;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartQuantityUpdateTest extends BaseTest {

    @Test
    public void checkCartQuantityAfterIncreasing() throws InterruptedException {
        productsPage= locationSelectionPage.chooseLocation();
        productsPage.selectProductFromProductsPage();
        cartPage=productsPage.clickCartIcon();
        Thread.sleep(4000);
        cartPage.increaseItemQuantity();
        Thread.sleep(4000);
        Assert.assertTrue(cartPage.getActualQuantity().contains(cartPage.expectedQuantityAfterAdding()));
    }

    @Test
    public void checkCartQuantityAfterDecreasing() throws InterruptedException {
        productsPage= locationSelectionPage.chooseLocation();
        productsPage.selectProductFromProductsPage();
        cartPage=productsPage.clickCartIcon();
        Thread.sleep(4000);
        cartPage.increaseItemQuantity();
        Thread.sleep(4000);
        cartPage.decreaseItemQuantity();
        Thread.sleep(4000);
        Assert.assertTrue(cartPage.getActualQuantity().contains(cartPage.expectedQuantityAfterDeleting()));
    }

    @Test
    public void checkCartIsEmpty()  {
        productsPage= locationSelectionPage.chooseLocation();
        productsPage.selectProductFromProductsPage();
        cartPage=productsPage.clickCartIcon();
        cartPage.removeProductFromCart();
        Assert.assertTrue(cartPage.getEmptyCartText().contains("Your Cart is Empty"));
    }

    @Test
    public void removeOneItemFromCart() throws InterruptedException {
        productsPage= locationSelectionPage.chooseLocation();
        productsPage.selectProductFromProductsPage();
        Thread.sleep(3000);
        productsPage.select2ndProductFromProductsPage();
        Thread.sleep(3000);
        cartPage=productsPage.clickCartIcon();
        cartPage.removeProductFromCart();
        Assert.assertFalse(cartPage.getProductCount().contains("Your Cart is Empty"));
    }

    @Test
    public void checkSubtotalAndTotal(){
        productsPage= locationSelectionPage.chooseLocation();
        productsPage.selectProductFromProductsPage();
        cartPage=productsPage.clickCartIcon();
        Assert.assertTrue(cartPage.getSubtotal().contains("EGP"));
        Assert.assertTrue(cartPage.getTotal().contains("EGP"));
    }

    @Test
    public void checkCheckoutButton(){
        productsPage= locationSelectionPage.chooseLocation();
        productsPage.selectProductFromProductsPage();
        cartPage=productsPage.clickCartIcon();
        checkoutPage=cartPage.clickCheckoutButton();
        Assert.assertTrue(checkoutPage.getActualText().contains(checkoutPage.getExpectedText()));
    }

    @Test
    public void checkContinueShoppingButton() throws InterruptedException {
        productsPage= locationSelectionPage.chooseLocation();
        productsPage.selectProductFromProductsPage();
        cartPage=productsPage.clickCartIcon();
        Thread.sleep(5000);
        productsPage=cartPage.clickContinueShopping();
        Assert.assertTrue(productsPage.getProductsPageText().contains(productsPage.getActualTextAfterBackToProducts()));
    }

    @Test
    public void checkInvalidPromoCode() throws InterruptedException {
        productsPage= locationSelectionPage.chooseLocation();
        productsPage.selectProductFromProductsPage();
        cartPage=productsPage.clickCartIcon();
        Thread.sleep(3000);
        cartPage.enterInvalidPromoCode();
        Assert.assertTrue(cartPage.getActualErrorPromoTextLocator().contains("The promo code isn't valid. Verify the code and try again."));
    }
}
