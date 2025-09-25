package test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AddGoodsToCartTest extends BaseTest {
    @Test
    public void addToCartItems() {
        loginPage.open();
        loginPage.inputLoginPassword("standard_user", "secret_sauce");
        productPage.addToCart("sauce-labs-backpack");
        productPage.addToCart(3);
        assertEquals(driver.findElement(By.xpath("//*[@data-test='shopping-cart-badge']")).getText(), "2");
        loginPage.open("cart.html");
        assertEquals(driver.findElements(By.xpath("//*[@class='inventory_item_name']")).size(), 2);
    }
}
