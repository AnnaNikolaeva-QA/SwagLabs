package test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    @Test
    public void checkStandardUserLogin() {
        loginPage.open();
        loginPage.inputLoginPassword("standard_user", "secret_sauce");
        assertTrue(browser.getCurrentUrl().contains("/inventory"));
    }

    @Test
    public void checkLockedOutUserLogin() {
        loginPage.open();
        loginPage.inputLoginPassword("locked_out_user", "secret_sauce");
        assertTrue(browser.findElement(By.xpath("//*[@data-test='error']")).isDisplayed());
    }
}
