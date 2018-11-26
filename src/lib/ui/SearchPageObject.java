package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchPageObject extends MainPageObject {

    private static final String

                SEARCH_INIT_ELEMENT = "//*[contains(@text,'Search Wikipedia')]",
                SEARCH_INPUT = "//*[contains(@text,'Search…')]",
                SEARCH_CANCEL_BUTTON = "org.wikipedia:id/search_close_btn",
                SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[@class='android.widget.LinearLayout']//*[@text='{SUBSTRING}']",
                TITLE_SEARCH_STRING = "org.wikipedia:id/search_src_text",
                BACKGROUND_TEXT_WIKI_SEARCH = "//*[@text='Search and read the free encyclopedia in your language']",
                HIST_WORD_IN_SEARCH = "//*[@text='{HIST_WORD}']";


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
        return this.waitForElementPresent(By.id(TITLE_SEARCH_STRING), "Не найдена строка поиска в Вики", 5);
    }

    public String getTitleSearch()
    {
        WebElement search_title_element = waitForSearchElement();
        return search_title_element.getAttribute("text");
    }



    public void waitForCancelButtonToAppiear()
    {
        this.waitForElementPresent(By.id(SEARCH_CANCEL_BUTTON), "Не нашел кнопку удаления текста в поиске ",5);
    }
    public void waitForCancelButtonToDisappiear()
    {
        this.waitForElementNotPresent(By.id(SEARCH_CANCEL_BUTTON), "Не нашел кнопку удаления текста в поиске ",5);
    }
    public void clickCancelSearch()
    {
        this.waitForElementAndClick(By.id(SEARCH_CANCEL_BUTTON), "Не нашел и не кликнул на кнопку отмены поика", 5);
        this.waitForElementPresent(By.xpath(BACKGROUND_TEXT_WIKI_SEARCH), "Присутствуют результаты поиска в Вики после отмены",15);
    }




    public void initSearchInput()
    {
        this.waitForElementAndClick(By.xpath(SEARCH_INIT_ELEMENT), "Не найдена переменная SEARCH_INIT_ELEMENT", 5);
        this.waitForElementPresent(By.xpath(SEARCH_INIT_ELEMENT), "Не найдена переменная SEARCH_INIT_ELEMENT после кликв", 5);
    }

    public void typeSearchLine(String search_line)
    {
        this.waitForElementAndSendKeys(By.xpath(SEARCH_INPUT), search_line,"Не найдена переменная SEARCH_INPUT" ,5);
    }

    public void  waitForSearchResult(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(By.xpath(search_result_xpath),"Не найден результат поиска" + substring , 5);
    }
    public void  clickByArticleWithSubstring(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(By.xpath(search_result_xpath),"Не найдена статья в поиске по заголовку"+ substring , 5);
    }
    public void  clickHistResultSearchSubstring(String hist_word)
    {
        String search_hist_result_xpath = getHistSearchElement(hist_word);
        this.waitForElementAndClick(By.xpath(search_hist_result_xpath), "Не найден сохраненный поиск в вики по слову" + hist_word, 5);

    }
}
