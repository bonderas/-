package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

public class AuthorizationPageObject extends MainPageObject{

    private static String

    LOGIN_BUTTON = "xpath://div//a[contains(@class,'mw-ui-button mw-ui-progressive')]",
    LOGIN_INPUT = "css:input[name='wpName']",
    PASSWORD_INPUT = "css:input[name='wpPassword']",
    SUBMIT_BUTTON = "css:button#wpLoginAttempt";

    public AuthorizationPageObject(RemoteWebDriver driver){
        super(driver);
    }

    public void clickAuthButton()
    {
        this.waitForElementPresent(LOGIN_BUTTON, "нет кнопки авторизации", 5);
        this.waitForElementAndClick(LOGIN_BUTTON, "не найден клик по кнопке авторизации", 10);
    }

    public void enterLoginData(String login, String password){
        this.waitForElementAndSendKeys(LOGIN_INPUT, login,"не найдена строка для ввода логина", 5);
        this.waitForElementAndSendKeys(PASSWORD_INPUT, password,"не найдена строка для ввода пароля", 5);
    }

    public void submithForm(){
      this.waitForElementAndClick(SUBMIT_BUTTON, "не найдена кнопка логона", 5);
    }

}
