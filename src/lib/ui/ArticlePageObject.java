package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject {

    private static final String
        TITLE = "id:org.wikipedia:id/view_page_title_text",
        OPTIONS_BUTTON = "xpath://*[@content-desc='Add this article to a reading list']",
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "xpath://*[@text='Got it']",
        ADD_TO_MY_LIST_OVERLAY = "id:org.wikipedia:id/text_input",
        MY_LIST_NAME_INPUT = "id:org.wikipedia:id/text_input",
        MY_LIST_OK_BUTTON = "xpath://*[@text='OK']",
        CLOSE_ARTICLE_BUTTON = "xpath://*[@content-desc='Navigate up']";




    public ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(TITLE,"Отсуствует заголовок", 5);
    }
    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("text");
    }

    public void addArticleInMyList(String name_of_folder)
    {
        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Не нашел кнопку добавления статьи в Избранное ",
                5
        );
        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Не нашел кнопку 'Got It' ",
                5
        );
        this.waitForElementAndClear(
                ADD_TO_MY_LIST_OVERLAY,
                "не нашел строку для заголовка",
                5
        );
        this.waitForElementAndSendKeys(
                MY_LIST_NAME_INPUT,
                name_of_folder,
                "Не найдена строка заголовка для ввода заголовка папки",
                15
        );
        this.waitForElementAndClick(
                MY_LIST_OK_BUTTON,
                "Не нашел кнопку 'OK' ",
                5
        );
    }

    public void clickButtonAddArticleInMyList()
    {
        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Не нашел кнопку добавления статьи в Избранное ",
                5
        );

    }

    public void closeArticle()
    {
        this.waitForElementAndClick(
                CLOSE_ARTICLE_BUTTON,
                "Не нашел Крестик закрытия статьи ",
                5
        );
    }

    public void existTitleInArticle()
    {
        this.assertElementPresent(
                TITLE
        );
    }

}
