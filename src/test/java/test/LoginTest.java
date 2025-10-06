package test;

import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.*;
import user.UserFactory;

import static enums.DepartmentNaming.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Epic("Авторизация")
@Listeners(AllureTestNg.class)
public class LoginTest extends BaseTest {
    @Epic("Модуль логин")
    @Feature("Юридическое лицо")
    @Story("Stg-123")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Nikolaeva Ann niolan007@yandex.ru")
    @TmsLink("SwagLabs")
    @Issue("Sandbox")
    @Flaky
    @Test(description = "Проверка корректной авторизации", priority = 2, invocationCount = 1, enabled = false)
    public void checkStandardUserLogin() {
        loginPage.open();
        loginPage.inputLoginPassword(login, password);
        assertTrue(productPage.isTitlePresent());
        assertEquals(productPage.getTitle(), PRODUCTS.getDisplayName());
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

    @Test(description = "Проверка авторизации с некорректными данными", dataProvider = "incorrectLoginData")
    public void checkIncorrectLogin(String login, String password, String errorMsg) {
        loginPage.open();
        loginPage.inputLoginPassword(login, password);
        loginPage.checkErrorMsg(errorMsg);
    }
}
