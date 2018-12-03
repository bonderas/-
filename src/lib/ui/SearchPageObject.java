package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

abstract public class SearchPageObject extends MainPageObject {

     protected static  String

                SEARCH_INIT_ELEMENT,
                SEARCH_INPUT,
                SEARCH_CANCEL_BUTTON ,
                SEARCH_RESULT_BY_SUBSTRING_TPL,
                TITLE_SEARCH_STRING,
                BACKGROUND_TEXT_WIKI_SEARCH,
                HIST_WORD_IN_SEARCH;


    public SearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }


    /* TEMPLATES METODS */

    private static String getResultSearchElement(String substring)
    {
      return  SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}",substring);
    }

    private static String getHistSearchElement(String hist_word)
    {
        return  HIST_WORD_IN_SEARCH.replace("{HIST_WORD}",hist_word);
    }
    /* TEMPLATES METODS */


    public WebElement waitForSearchElement()
    {
        return this.waitForElementPresent(TITLE_SEARCH_STRING, "Не найдена строка поиска в Вики", 5);
    }

    public String getTitleSearch()
    {
        WebElement search_title_element = waitForSearchElement();
        return search_title_element.getAttribute("text");
    }



    public void waitForCancelButtonToAppiear()
    {
        this.waitForElementPresent(SEARCH_CANCEL_BUTTON, "Не нашел кнопку удаления текста в поиске ",5);
    }
    public void waitForCancelButtonToDisappiear()
    {
        this.waitForElementNotPresent(SEARCH_CANCEL_BUTTON, "Не нашел кнопку удаления текста в поиске ",5);
    }
    public void clickCancelSearch()
    {
        this.waitForElementAndClick(SEARCH_CANCEL_BUTTON, "Не нашел и не кликнул на кнопку отмены поика", 5);
        this.waitForElementPresent(BACKGROUND_TEXT_WIKI_SEARCH, "Присутствуют результаты поиска в Вики после отмены",15);
    }




    public void initSearchInput()
    {
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT, "Не найдена переменная SEARCH_INIT_ELEMENT", 5);
        this.waitForElementPresent(SEARCH_INIT_ELEMENT, "Не найдена переменная SEARCH_INIT_ELEMENT после кликв", 5);
    }

    public void typeSearchLine(String search_line)
    {
        this.waitForElementAndSendKeys(SEARCH_INPUT, search_line,"Не найдена переменная SEARCH_INPUT" ,15);
    }

    public void  waitForSearchResult(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(search_result_xpath,"Не найден результат поиска" + substring , 15);
    }
    public void  clickByArticleWithSubstring(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(search_result_xpath,"Не найдена статья в поиске по заголовку"+ substring , 15);
    }
    public void  clickHistResultSearchSubstring(String hist_word)
    {
        String search_hist_result_xpath = getHistSearchElement(hist_word);
        this.waitForElementAndClick(search_hist_result_xpath, "Не найден сохраненный поиск в вики по слову" + hist_word, 5);

    }
}
