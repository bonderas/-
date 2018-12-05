package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WelcomePageObject extends MainPageObject
{

    private static final String

    SKIP = "id:Skip";

    public WelcomePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

    public void clickSkip()
    {
        this.waitForElementAndClick(SKIP, "Не нашел кнопку 'Skip'", 5);
    }
}
