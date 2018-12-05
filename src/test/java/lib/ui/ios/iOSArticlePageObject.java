package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSArticlePageObject extends ArticlePageObject {

    static {
        TITLE = "id:Ford Motor Company Automotive brand manufacturer";
        PLACE_AUTH_CLOSE = "id:places auth close";
        CLOSE_ARTICLE_BUTTON = "id:Back";

    }
    public iOSArticlePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}
