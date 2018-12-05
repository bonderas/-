package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {
    static {
        TITLE = "css:#content h1";
        PLACE_AUTH_CLOSE = "id:places auth close";
        CLOSE_ARTICLE_BUTTON = "id:Back";
        OPTIONS_ADD_TO_MY_LIST_BUTTON ="xpath://li[contains(@class,'watch-this-article')][contains(@title,'Watch this page')]";
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON = "xpath://li[contains(@class,'watch-this-article')][contains(@title,'Stop watching')]";



    }

    public MWArticlePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}
