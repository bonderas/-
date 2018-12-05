package lib.ui.mobile_web;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWSearchPageObject extends SearchPageObject {
    static {
        TITLE_1 ="xpath://XCUIElementTypeLink[contains(@name,'Ford Motor Company')]";
        TITLE_2 ="xpath://XCUIElementTypeLink[contains(@name,'Ford F-Series')]";

        TITLE_SEARCH_STRING = "xpath://*XCUIElementTypeSearchField[contains(@value,'Search Wikipedia'])";
        SEARCH_INIT_ELEMENT = "css:button#searchIcon";
        SEARCH_INPUT = "css:form>input[type='search']";
        SEARCH_CANCEL_BUTTON = "css:button.cancel";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://div[contains(@class,'results-list-container view-border-box')]//a[contains(@data-title,'{SUBSTRING}')]";
        BACKGROUND_TEXT_WIKI_SEARCH = "xpath://*[@text='Search and read the free encyclopedia in your language']";
    }

    public MWSearchPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}


