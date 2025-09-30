package test;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AddGoodsToCartTest extends BaseTest {
    @Test
    public void addToCartItems() {
        loginPage.open();
        loginPage.inputLoginPassword(login, password);
        productPage.addToCart("sauce-labs-backpack");
        productPage.addToCart(3);
        productPage.checkGoodsCount("2");
        loginPage.open("cart.html");
        cartPage.checkGoodsCountInCart(2);
    }

    @Test
    public void checkAddToCartItemsAfterLesson() {
        loginPage.open();
        loginPage.inputLoginPassword(login, password);
        productPage.addToCart("sauce-labs-backpack");
        productPage.addToCart(3);
        productPage.checkGoodsCount("2");
        cartPage.openCartPage();
        assertTrue(cartPage.getProductsNames().contains("Sauce Labs Backpack"));
        assertEquals(cartPage.getProductsNames().size(), 2);
        assertFalse(cartPage.getProductsNames().isEmpty());
    }
}
