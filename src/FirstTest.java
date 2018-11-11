import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

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
    public void testSearchResulsDisabled()
    {
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

}
