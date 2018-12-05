package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidArticlePageObject extends ArticlePageObject {

     static {
            TITLE = "id:org.wikipedia:id/view_page_title_text";
            OPTIONS_BUTTON = "xpath://*[@content-desc='Add this article to a reading list']";
            OPTIONS_ADD_TO_MY_LIST_BUTTON = "xpath://*[@text='Got it']";
            ADD_TO_MY_LIST_OVERLAY = "id:org.wikipedia:id/text_input";
            MY_LIST_NAME_INPUT = "id:org.wikipedia:id/text_input";
            MY_LIST_OK_BUTTON = "xpath://*[@text='OK']";
            CLOSE_ARTICLE_BUTTON = "xpath://*[@content-desc='Navigate up']";

     }

     public AndroidArticlePageObject(RemoteWebDriver driver)
     {
         super(driver);
     }
}