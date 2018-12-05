package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.rmi.Remote;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

abstract public class ArticlePageObject extends MainPageObject {

    protected static String
        TITLE,
        OPTIONS_BUTTON,
        OPTIONS_ADD_TO_MY_LIST_BUTTON,
        ADD_TO_MY_LIST_OVERLAY,
        MY_LIST_NAME_INPUT,
        MY_LIST_OK_BUTTON,
        PLACE_AUTH_CLOSE,
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
        CLOSE_ARTICLE_BUTTON;




    public ArticlePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

    /* TEMPLATES METODS */

    /* TEMPLATES METODS */


    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(TITLE,"Отсуствует заголовок", 5);
    }



    public void existingArticleByLabel(String article_title)
    {
        java.util.List<WebElement> textboxes = driver.findElements(By.xpath("//XCUIElementTypeLink"));
        for (int i = 0; i<textboxes.size(); i++)
        {
            String text_textbox = textboxes.get(i).getAttribute("label");
            assertTrue("В списке статей не найдена статья"+ article_title ,text_textbox.contains(article_title));
        }
    }



    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        if(Platform.getInstance().isAndroid()){
            return title_element.getAttribute("text");
        } else if (Platform.getInstance().isIOS()){
            return title_element.getAttribute("name");
        }else{
            return title_element.getText();
        }

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

    public void closePlacesAuthClose()
    {
        this.waitForElementAndClick(
                PLACE_AUTH_CLOSE,
                "Не нашел Крестик закрытия окна авторизации ",
                5
        );
    }




    public void existTitleInArticle()
    {
        this.assertElementPresent(
                TITLE
        );
    }

    public void existButtonDeleteArticleFromPageList()
    {
        this.assertElementPresent(
                OPTIONS_REMOVE_FROM_MY_LIST_BUTTON
        );
    }


    public void addArticleInMyiOSList()
    {
        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON, "Не нашел кнопку добавления статьи в избранное на iOS", 5);
    }


    public void addArticleToMyList()
    {
        if(Platform.getInstance().isMw()){
            this.removeArticleFromSavedIfAdded();
        }
        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON, "Не нашел кнопку добавления статьи в избранное ", 5);
    }


    public void remoteArticleToMyList()
    {
        this.waitForElementAndClick(
                OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
                "не нажал на кнопку удаления статьи из сохраненных ранее",
                5
        );
    }



    public void removeArticleFromSavedIfAdded()
    {
       if(this.isElementPresent(OPTIONS_REMOVE_FROM_MY_LIST_BUTTON)){
           this.waitForElementAndClick(
                   OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
                   "не нажал на кнопку удаления статьи из сохраненных ранее",
                   2
           );
           this.waitForElementNotPresent(
                   OPTIONS_ADD_TO_MY_LIST_BUTTON,
                   "не появилась кнопка добавления статьи после удаления",
                   2
           );
       }
    }
}
