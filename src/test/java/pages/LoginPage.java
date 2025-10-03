package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class LoginPage extends BasePage {
    private static final By USERNAME_INPUT = By.xpath("//*[@placeholder='Username']");
    private static final By PASSWORD_INPUT = By.xpath("//*[@placeholder='Password']");
    private static final By LOGIN_BTN = By.xpath("//*[@id='login-button']");
    private static final By ERROR_MSG = By.xpath("//*[@data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие браузера")
    public void open() {
        driver.get(BASE_URL);
    }

    @Step("Переход на страницу")
    public void open(String endPoint) {
        driver.get(BASE_URL + endPoint);
    }

    @Step("Логин под кредами пользователя: логин = {login}, пароль = '******'")
    public void inputLoginPassword(String login, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(login);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BTN).click();
    }

    @Step("Проверка сообщения об ошибке")
    public void checkErrorMsg(String errorMsg) {
        assertEquals(driver.findElement(ERROR_MSG).getText(), errorMsg);
    }
}
