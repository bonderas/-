package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObjects;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSMyListsPageObjects extends MyListsPageObjects {

    static {
        ARTICLE_BY_TITLE_TPL = "xpath://XCUIElementTypeLink[contains(@name,'{TITLE}')]";
    }
    public iOSMyListsPageObjects(RemoteWebDriver driver)
    {
        super(driver);
    }
}
