package lib.ui;

import io.appium.java_client.AppiumDriver;

public class WelcomePageObject extends MainPageObject
{

    private static final String

    SKIP = "id:Skip";

    public WelcomePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public void clickSkip()
    {
        this.waitForElementAndClick(SKIP, "Не нашел кнопку 'Skip'", 5);
    }
}
