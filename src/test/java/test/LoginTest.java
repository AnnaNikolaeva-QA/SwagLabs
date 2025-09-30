package test;

import io.qameta.allure.Epic;
import org.testng.annotations.*;
import user.UserFactory;

import static org.testng.Assert.assertTrue;
@Epic("Авторизация")

public class LoginTest extends BaseTest {
    @Test(description = "Проверка корректной авторизации", priority = 2, invocationCount = 1)
    public void checkStandardUserLogin() {
        loginPage.open();
        loginPage.inputLoginPassword(login, password);
        assertTrue(productPage.isTitlePresent());
    }

    @DataProvider()
    public Object[][] incorrectLoginData() {
        return new Object[][]{
                {UserFactory.blockedUser().getEmail(), UserFactory.blockedUser().getPassword(),
                        "Epic sadface: Sorry, this user has been locked out."},
                {UserFactory.withOutLogin().getEmail(), UserFactory.withOutLogin().getPassword(),
                        "Epic sadface: Username is required"},
                {UserFactory.withOutPassword().getEmail(), UserFactory.withOutPassword().getPassword(),
                        "Epic sadface: Password is required"}
        };
    }

    @Test(dataProvider = "incorrectLoginData")
    public void checkIncorrectLogin(String login, String password, String errorMsg) {
        loginPage.open();
        loginPage.inputLoginPassword(login, password);
        loginPage.checkErrorMsg(errorMsg);
    }
}
