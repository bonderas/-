package lib;
import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;



public class CoreTestCase extends TestCase {

    private final static String PLATFORM_ANDROID = "android";
    private final static String PLATFORM_IOS = "iOS";

    protected AppiumDriver driver;
    protected Platform Platform;


    @Override
    protected void setUp() throws Exception {
        super.setUp();
        this.Platform = new Platform();
        driver = this.Platform.getDriver();
    }

    @Override
    protected void tearDown() throws Exception {
        driver.quit();

        super.tearDown();
    }




}
