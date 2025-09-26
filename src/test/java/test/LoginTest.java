package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    @Test(description = "Проверка корректной авторизации", priority = 2, invocationCount = 1)
    public void checkStandardUserLogin() {
        loginPage.open();
        loginPage.inputLoginPassword("standard_user", "secret_sauce");
        assertTrue(productPage.isTitlePresent());
    }

    @DataProvider()
    public Object[][] incorrectLoginData() {
        return new Object[][]{
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"}
        };
    }

    @Test(dataProvider = "incorrectLoginData")
    public void checkIncorrectLogin(String login, String password, String errorMsg) {
        loginPage.open();
        loginPage.inputLoginPassword(login, password);
        loginPage.checkErrorMsg(errorMsg);
    }
}
