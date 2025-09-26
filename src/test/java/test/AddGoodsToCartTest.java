package test;

import org.testng.annotations.Test;

public class AddGoodsToCartTest extends BaseTest {
    @Test
    public void addToCartItems() {
        loginPage.open();
        loginPage.inputLoginPassword("standard_user", "secret_sauce");
        productPage.addToCart("sauce-labs-backpack");
        productPage.addToCart(3);
        productPage.checkGoodsCount("2");
        loginPage.open("cart.html");
        cartPage.checkGoodsCountInCart(2);
    }
}
