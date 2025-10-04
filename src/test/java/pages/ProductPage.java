package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.assertEquals;

public class ProductPage extends BasePage {
    final By title = By.xpath("//span[@data-test='title']");
    final By titleProducts = By.xpath("//*[text()='Products']");
    private static final By ALL_ADD_TO_CART_BTN = By.xpath("//*[text()='Add to cart']");
    private static final String ADD_TO_CART_BTN_PATTERN = "//*[@data-test='add-to-cart-%s']";
    public static final By ITEMS_COUNT_ON_BASKET = By.xpath("//*[@data-test='shopping-cart-badge']");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Step("Получение названия")
    public String getTitle() {
        return driver.findElement(title).getText();
    }

    @Step("Проверка отображения названия 'Products'")
    public boolean isTitlePresent() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(titleProducts)).isDisplayed();
    }

    @Step("Добавление твоара в корзину по названию")
    public void addToCart(String goodsName) {
        By addToCart = By.xpath(ADD_TO_CART_BTN_PATTERN.formatted(goodsName));
        driver.findElement(addToCart).click();
    }

    @Step("Добавление твоара в корзину по индексу")
    public void addToCart(int goodsIndex) {
        driver.findElements(ALL_ADD_TO_CART_BTN).get(goodsIndex).click();
    }

    @Step("Проверка количества товаров в корзине (счётчик на значке корзина")
    public void checkGoodsCount(String expectedCount) {
        assertEquals(driver.findElement(ITEMS_COUNT_ON_BASKET).getText(), expectedCount);
    }
}
