package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class MyListsPageObjects extends MainPageObject {

    protected static String
            FOLDER_BY_NAME_TPL,
            REMOVE_FROM_SAVE_BUTTON,
            ARTICLE_BY_TITLE_TPL;


    public static String getFolderXpathByName(String name_of_folder)
    {
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}",name_of_folder);
    }


    public static String getSaveXpathArticleByTitle(String article_title)
    {
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}",article_title);
    }

    public static String getRemoveButtonByTottle(String article_title)
    {
        return REMOVE_FROM_SAVE_BUTTON.replace("{TITLE}",article_title);
    }




    public MyListsPageObjects(RemoteWebDriver driver)

    {
        super(driver);
    }

    public void clickByFolderWithSubstring(String name_of_folder)
    {
        String folder_name_xpath = getFolderXpathByName(name_of_folder);
        this.waitForElementAndClick(
                folder_name_xpath,
            "Не нашел папку состатьями"+ name_of_folder,
            5
        );
    }



    public void clickForArticleSavedByTitle(String article_title)
    {
        String article_xpath = getSaveXpathArticleByTitle(article_title);
        this.waitForElementPresent(article_xpath, "Не найдена сохраненная статья"+ article_title,15);
        this.waitForElementAndClick(article_xpath, "Не кликнул по сохраненной статье"+ article_title,15);
    }


    public void waitForArticleToAppearByTitle(String article_title)
    {
        String article_xpath = getSaveXpathArticleByTitle(article_title);
        this.waitForElementPresent(article_xpath, "Не найдена сохраненная статья"+ article_title,15);

    }
    public void waitForArticleToDisappearByTitle(String article_title)
    {
        String article_xpath = getSaveXpathArticleByTitle(article_title);
        this.waitForElementNotPresent(article_xpath, "Не удалилась статья"+ article_title,15);

    }


    public void swipeByArticleToDelete(String article_title)
    {
        this.waitForArticleToAppearByTitle(article_title);
        String article_xpath = getSaveXpathArticleByTitle(article_title);

        if(Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()){
            this.swipeElementToLeft(
                    article_xpath,
                    "Не найдена статья с первым заголовком"
            );
        }else{
          String remove_locator = getRemoveButtonByTottle(article_title);
          this.waitForElementAndClick(
                  remove_locator,
                  "не кликнул в ремуф локатор",
                  10
          );

        }



        if(Platform.getInstance().isIOS()){
           this.clickElementToTheRightUpperConner(article_xpath, "Не смог найти сохраненную статью");

        }

        if(Platform.getInstance().isMw())
        {
            driver.navigate().refresh();
        }
        this.waitForArticleToDisappearByTitle(article_title);
    }



}
