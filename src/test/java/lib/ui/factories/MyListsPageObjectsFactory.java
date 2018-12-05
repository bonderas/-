package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.MyListsPageObjects;
import lib.ui.android.AndroidMyListsPageObjects;
import lib.ui.ios.iOSMyListsPageObjects;
import lib.ui.mobile_web.MWMyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MyListsPageObjectsFactory {


    public static MyListsPageObjects get(RemoteWebDriver driver)
    {
        if(Platform.getInstance().isAndroid()) {
            return new AndroidMyListsPageObjects(driver);
        }else if(Platform.getInstance().isIOS()){
            return new iOSMyListsPageObjects(driver);
        }else{
            return new MWMyListsPageObject(driver);
        }
    }

}
