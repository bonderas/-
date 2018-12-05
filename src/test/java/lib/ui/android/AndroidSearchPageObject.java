package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidSearchPageObject extends SearchPageObject
{

    static {

        SEARCH_INIT_ELEMENT = "xpath://*[contains(@text,'Search Wikipedia')]";
        SEARCH_INPUT = "xpath://*[contains(@text,'Search…')]";
        SEARCH_CANCEL_BUTTON = "id:org.wikipedia:id/search_close_btn";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@class='android.widget.LinearLayout']//*[@text='{SUBSTRING}']";
        TITLE_SEARCH_STRING = "id:org.wikipedia:id/search_src_text";
        BACKGROUND_TEXT_WIKI_SEARCH = "xpath://*[@text='Search and read the free encyclopedia in your language']";
        HIST_WORD_IN_SEARCH = "xpath://*[@text='{HIST_WORD}']";
    }

    public AndroidSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}

