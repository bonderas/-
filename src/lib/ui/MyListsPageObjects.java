package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MyListsPageObjects extends MainPageObject {

    public static final String
            FOLDER_BY_NAME_TPL = "//*[@text='{FOLDER_NAME}']",
            ARTICLE_BY_TITLE_TPL = "//*[@text='{TITLE}']";


    public static String getFolderXpathByName(String name_of_folder)
    {
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}",name_of_folder);
    }


    public static String getSaveXpathArticleByTitle(String article_title)
    {
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}",article_title);
    }



    public MyListsPageObjects(AppiumDriver driver)

    {
        super(driver);
    }

    public void clickByFolderWithSubstring(String name_of_folder)
    {
        String folder_name_xpath = getFolderXpathByName(name_of_folder);
        this.waitForElementAndClick(
                By.xpath(folder_name_xpath),
            "Не нашел папку состатьями"+ name_of_folder,
            5
        );
    }

    public void waitForArticleToAppearByTitle(String article_title)
    {
        String article_xpath = getSaveXpathArticleByTitle(article_title);
        this.waitForElementPresent(By.xpath(article_xpath), "Не найдена сохраненная статья"+ article_title,15);

    }
    public void waitForArticleToDisappearByTitle(String article_title)
    {
        String article_xpath = getSaveXpathArticleByTitle(article_title);
        this.waitForElementNotPresent(By.xpath(article_xpath), "Не удалилась статья"+ article_title,15);

    }


    public void swipeByArticleToDelete(String article_title)
    {
        this.waitForArticleToAppearByTitle(article_title);
        String article_xpath = getSaveXpathArticleByTitle(article_title);
        this.swipeElementToLeft(
                By.xpath(article_xpath),
                "Не найдена статья с первым заголовком"
        );
        this.waitForArticleToDisappearByTitle(article_title);
    }



}
