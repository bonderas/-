package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject {

    private static final String
        TITLE = "org.wikipedia:id/view_page_title_text",
        OPTIONS_BUTTON = "//*[@content-desc='Add this article to a reading list']",
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "//*[@text='Got it']",
        ADD_TO_MY_LIST_OVERLAY = "org.wikipedia:id/text_input",
        MY_LIST_NAME_INPUT = "org.wikipedia:id/text_input",
        MY_LIST_OK_BUTTON = "//*[@text='OK']",
        CLOSE_ARTICLE_BUTTON = "//*[@content-desc='Navigate up']";




    public ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(By.id(TITLE),"Отсуствует заголовок", 5);
    }
    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("text");
    }

    public void addArticleInMyList(String name_of_folder)
    {
        this.waitForElementAndClick(
                By.xpath(OPTIONS_BUTTON),
                "Не нашел кнопку добавления статьи в Избранное ",
                5
        );
        this.waitForElementAndClick(
                By.xpath(OPTIONS_ADD_TO_MY_LIST_BUTTON),
                "Не нашел кнопку 'Got It' ",
                5
        );
        this.waitForElementAndClear(
                By.id(ADD_TO_MY_LIST_OVERLAY),
                "не нашел строку для заголовка",
                5
        );
        this.waitForElementAndSendKeys(
                By.id(MY_LIST_NAME_INPUT),
                name_of_folder,
                "Не найдена строка заголовка для ввода заголовка папки",
                15
        );
        this.waitForElementAndClick(
                By.xpath(MY_LIST_OK_BUTTON),
                "Не нашел кнопку 'OK' ",
                5
        );
    }

    public void clickButtonAddArticleInMyList()
    {
        this.waitForElementAndClick(
                By.xpath(OPTIONS_BUTTON),
                "Не нашел кнопку добавления статьи в Избранное ",
                5
        );

    }

    public void closeArticle()
    {
        this.waitForElementAndClick(
                By.xpath(CLOSE_ARTICLE_BUTTON),
                "Не нашел Крестик закрытия статьи ",
                5
        );
    }

    public void existTitleInArticle()
    {
        this.assertElementPresent(
                By.id(TITLE)
        );
    }




}
