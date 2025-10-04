package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class CartPage extends BasePage {
    private static final By COUNT_ITEMS_IN_CART = By.xpath("//*[@class='inventory_item_name']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Переход на страницу корзины")
    public void openCartPage() {
        driver.findElement(ProductPage.ITEMS_COUNT_ON_BASKET).click();
    }

    @Step("Проверка количества товаров в корзине")
    public void checkGoodsCountInCart(int expectedCount) {
        assertEquals(driver.findElements(COUNT_ITEMS_IN_CART).size(), expectedCount);
    }

    @Step("Получение спсика товаров в корзине")
    public ArrayList<String> getProductsNames() {
        List<WebElement> allProductsName = driver.findElements(By.cssSelector(".inventory_item_name"));
        ArrayList<String> productNames = new ArrayList<>();
        for (WebElement product : allProductsName) {
            productNames.add(product.getText());
        }
        return productNames;
    }
}
