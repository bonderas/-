package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class NavigationUI extends MainPageObject{

    protected static String

        MY_LISTS_BUTTON,
        OPEN_NAVIGATION;

    public NavigationUI(RemoteWebDriver driver)
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


    public void openNavigation()
    {
        if(Platform.getInstance().isMw()){
            this.waitForElementAndClick(OPEN_NAVIGATION, "не нашел кнопку открыть навигацию", 5);
        }
    }

    public void clickMyLists()
    {
        if (Platform.getInstance().isMw()) {
            this.tryClickElementWithFewAttempts(
                    MY_LISTS_BUTTON,
                    "Cannot find navigation button to My list",
                    5
            );
        } else {
            this.waitForElementAndClick(
                    MY_LISTS_BUTTON,
                    "Cannot find navigation button to My list",
                    5
            );
        }
    }


}
