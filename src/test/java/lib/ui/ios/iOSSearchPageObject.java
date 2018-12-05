package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSSearchPageObject extends SearchPageObject
{

    static {
        TITLE_1 ="xpath://XCUIElementTypeLink[contains(@name,'Ford Motor Company')]";
        TITLE_2 ="xpath://XCUIElementTypeLink[contains(@name,'Ford F-Series')]";

        TITLE_SEARCH_STRING = "xpath://*XCUIElementTypeSearchField[contains(@value,'Search Wikipedia'])";
        SEARCH_INIT_ELEMENT = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia']";
        SEARCH_INPUT = "xpath://XCUIElementTypeSearchField[@value='Search Wikipedia']";
        SEARCH_CANCEL_BUTTON = "id:Close";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://XCUIElementTypeLink[contains(@name,'{SUBSTRING}')]";
        BACKGROUND_TEXT_WIKI_SEARCH = "xpath://*[@text='Search and read the free encyclopedia in your language']";
    }

    public iOSSearchPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}
