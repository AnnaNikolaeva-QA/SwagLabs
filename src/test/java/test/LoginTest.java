package test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    @Test(description = "Проверка корректной авторизации", priority = 2, invocationCount = 1)
    public void checkStandardUserLogin() {
        loginPage.open();
        loginPage.inputLoginPassword("standard_user", "secret_sauce");
        assertTrue(productPage.isTitlePresent());
        productPage.addToCart("sauce-labs-backpack");
    }

    @Test
    public void checkLockedOutUserLogin() {
        loginPage.open();
        loginPage.inputLoginPassword("locked_out_user", "secret_sauce");
        assertTrue(driver.findElement(By.xpath("//*[@data-test='error']")).isDisplayed());
    }

    @Test
    public void checkWithOutUserNameLogin() {
        loginPage.open();
        loginPage.inputLoginPassword("", "secret_sauce");
        assertTrue(driver.findElement(By.xpath("//*[@data-test='error']")).isDisplayed());
    }

    @Test
    public void checkWithOutPasswordLogin() {
        loginPage.open();
        loginPage.inputLoginPassword("locked_out_user", "");
        assertTrue(driver.findElement(By.xpath("//*[@data-test='error']")).isDisplayed());
    }
}
