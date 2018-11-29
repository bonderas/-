package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavigationUI extends MainPageObject{

    public static final String

        MY_LISTS_BUTTON = "xpath://*[@content-desc='My lists']";

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
