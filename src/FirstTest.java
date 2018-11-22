import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.server.handler.WebElementHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.List;

public class FirstTest {

    private AppiumDriver driver;
    @Before
    public void setUp() throws Exception
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","AndroidTestDevice");
        capabilities.setCapability("platformVersion","6.0");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("appActivity",".main.MainActivity");
        capabilities.setCapability("app","C:\\Users\\SB\\Desktop\\JavaAppiumAutomation\\apks\\org.wikipedia.apk");

        driver =  new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
    }
    @After
    public void tearDown()
    {
        driver.quit();
    }

    @Test
    public void existWordSearch()
    {
        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia' input",
                5
        );
        WebElement search_element = waitForElementPresent(
                By.id("org.wikipedia:id/search_src_text"),
                "Не найдена строка поиска в Вики",
                15
        );
        String seach_word = search_element.getAttribute("text");
        Assert.assertEquals(
                "В строке поиска в Вики , нет слова Search",
                "Search…",
                seach_word

        );

    }

    @Test
    public void testSearchResulsDisabled() {
        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia' input",
                5
        );

        waitForElementPresent(
                By.id("org.wikipedia:id/search_src_text"),
                "Не найдена строка поиска в Вики",
                15
        );
        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search…')]"),
                "Ford",
                "Не найдена строка поиска в Вики",
                5
        );
        waitForElementPresent(
                By.xpath("//*[@class='android.widget.LinearLayout']//*[@text='Car model']"),
                "Не найдена третья строка в результатах поиска в Вики",
                20

        );

        waitForElementPresent(
                By.xpath("//*[@class='android.widget.LinearLayout']//*[@text='Automotive brand manufacturer']"),
                "Не найдена первая строка в результатах поиска в Вики",
                15

        );

        waitForElementAndClear(
                By.id("org.wikipedia:id/search_close_btn"),
                "Отсутствует кнопка очистки поиска",
                5
        );

        waitForElementPresent(
                By.xpath("//*[@text='Search and read the free encyclopedia in your language']"),
                "Присутствуют результаты поиска в Вики",
                15
        );
    }

    @Test
    public void testExistWordInEveryTitle() {
        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia' input",
                5
        );

        waitForElementPresent(
                By.id("org.wikipedia:id/search_src_text"),
                "Не найдена строка поиска в Вики",
                15
        );
        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search…')]"),
                "Ford",
                "Не найдена строка поиска в Вики",
                15
        );

        java.util.List<WebElement> textboxes = driver.findElements(By.id("org.wikipedia:id/page_list_item_title"));
        for (int i = 0; i<textboxes.size(); i++)
            {

                String text_textbox = textboxes.get(i).getAttribute("text");
                Assert.assertTrue("Не все результаты поиска содержат Ford",text_textbox.contains("Ford"));
            }
    }

    @Test
    public void testSaveTwoArticlesToMyList() {

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia' input",
                5
        );
        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search…')]"),
                "Ford",
                "Не найдена строка поиска в Вики",
                15
        );
        waitForElementPresent(
                By.id("org.wikipedia:id/search_src_text"),
                "Не найдена строка поиска в Вики",
                15
        );
        WebElement Article_1 = waitForElementPresent(
                By.xpath("//*[@class='android.widget.LinearLayout']//*[@text='Ford Motor Company']"),
                "Не найдена статья 1 в поиске в Вики",
                15
        );
        String title_article_1 =  Article_1.getAttribute("text");

        WebElement Article_2 = waitForElementPresent(
                By.xpath("//*[@class='android.widget.LinearLayout']//*[@text='Ford F-Series']"),
                "Не найдена статья 1 в поиске в Вики",
                15
        );
        String title_article_2 =  Article_2.getAttribute("text");

        waitForElementAndClick(
                By.xpath("//*[@text='"+title_article_1+"']"),
                "Не нашел статью 'Ford Motor Company' в поиске ",
                5
        );
        waitForElementAndClick(
                By.xpath("//*[@content-desc='Add this article to a reading list']"),
                "Не нашел кнопку добавления статьи в Избранное ",
                5
        );
        waitForElementAndClick(
                By.xpath("//*[@text='Got it']"),
                "Не нашел кнопку 'Got It' ",
                5
        );
        waitForElementAndClear(
                By.id("org.wikipedia:id/text_input"),
                "не нашел строку для заголовка",
                5
        );
        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/text_input"),
                "Bla-Bla",
                "Не найдена строка поиска в Вики",
                15
        );
        waitForElementAndClick(
                By.xpath("//*[@text='OK']"),
                "Не нашел кнопку 'OK' ",
                5
        );
        waitForElementAndClick(
                By.xpath("//*[@content-desc='Navigate up']"),
                "Не нашел Крестик закрытия статьи ",
                5
        );
        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia' input",
                5
        );
        waitForElementAndClick(
                By.xpath("//*[@text='Ford']"),
                "Не нашел историю поиска в Вики",
                5
        );
        waitForElementAndClick(
                By.xpath("//*[@text='"+title_article_2+"']"),
                "Не нашел вторую статью в поиске в Вики",
                5
        );
        waitForElementAndClick(
                By.xpath("//*[@content-desc='Add this article to a reading list']"),
                "Не нашел кнопку добавления статьи в Избраное ",
                5
        );
        waitForElementAndClick(
                By.xpath("//*[@text='Bla-Bla']"),
                "Не нашел папку состатьями",
                5
        );
        waitForElementAndClick(
                By.xpath("//*[@content-desc='Navigate up']"),
                "Не нашел Крестик закрытия статьи ",
                5
        );
        waitForElementAndClick(
                By.xpath("//*[@content-desc='My lists']"),
                "Не нашел кнопку Избраное",
                5
        );
        waitForElementAndClick(
                By.xpath("//*[@text='Bla-Bla']"),
                "Не нашел папку состатьями",
                5
        );
        waitForElementAndClick(
                By.id("org.wikipedia:id/item_container"),
                "Не нашел добавленные статейки в пакете",
                5
        );
        swipeElementToLeft(
                By.xpath("//*[@text='"+title_article_1+"']"),
                "Не найдена статья с первым заголовком"
        );
        WebElement  Articlebox = waitForElementPresent (
                    By.id("org.wikipedia:id/page_list_item_title"),
                    "Не найдена оставшаяся статья",
                10
        );

        String title_articlebox = Articlebox.getAttribute("text");
        Assert.assertFalse("Статья номер 1 не уделилась", title_articlebox.contains(title_article_1));
        Assert.assertTrue("Отсуствует статья номер 2", title_articlebox.contains(title_article_2));

        waitForElementAndClick(
                By.xpath("//*[@text='"+title_article_2+"']"),
                "Не нашел вторую сохраненную статью в папке",
                10
        );
        WebElement  Articlebox_2 = waitForElementPresent (
                By.id("org.wikipedia:id/view_page_title_text"),
                "Не найдена оставшаяся статья",
                10
        );
        String title_articlebox_2 = Articlebox_2.getAttribute("text");
        Assert.assertTrue("Заголовок статьи номер 2 не совпадает с изначальным", title_articlebox_2.contains(title_article_2));
    }

    @Test
    public void testSearchTitleInArticle() {

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia' input",
                5
        );
        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search…')]"),
                "Ford",
                "Не найдена строка поиска в Вики",
                15
        );
        waitForElementPresent(
                By.id("org.wikipedia:id/search_src_text"),
                "Не найдена строка поиска в Вики",
                15
        );

        waitForElementAndClick(
                By.id("org.wikipedia:id/page_list_item_container"),
                "Не нашел статью в поиске ",
                5
        );

//        waitForElementPresent(
//                By.id("org.wikipedia:id/view_page_title_text"),
//                "Проверка работы метода assertElementPresent",
//                15
//        );

        assertElementPresent(
                By.id("org.wikipedia:id/view_page_title_text")
        );
    }




    private WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    private WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.click();
        return element;
    }

    private WebElement waitForElementAndClear(By by, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }
    private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

    protected void swipeElementToLeft(By by, String error_message) {

        WebElement element = waitForElementPresent(
                by,
                error_message,
                20);

        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y)/2;

        TouchAction action = new TouchAction(driver);
        action
                .press(right_x, middle_y)
                .waitAction(600)
                .moveTo(left_x, middle_y)
                .release()
                .perform();
    }

    private void assertElementPresent(By by) {
        List exist_title =  driver.findElements(by);
        int exist_element = exist_title.size();
        Assert.assertTrue("Не найден разыскиваемый элемент на странице",exist_element > 0 );

    }

}
