package lib.ui;

import io.appium.java_client.AppiumDriver;

abstract public class NavigationUI extends MainPageObject{

    protected static String

        MY_LISTS_BUTTON ;

    public NavigationUI(AppiumDriver driver)
    {
        super(driver);
    }

    public void clickButtonMyLists()
    {
        this.waitForElementAndClick(
                MY_LISTS_BUTTON,
                "Не нашел кнопку Избраное на главной странице Вики",
                5
        );
    }
}
