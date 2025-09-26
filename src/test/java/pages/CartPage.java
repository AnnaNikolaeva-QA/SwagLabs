package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.assertEquals;

public class CartPage extends BasePage {
    private static final By COUNT_ITEMS_IN_CART = By.xpath("//*[@class='inventory_item_name']");
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void checkGoodsCountInCart(int expectedCount) {
        assertEquals(driver.findElements(COUNT_ITEMS_IN_CART).size(), expectedCount);
    }
}
