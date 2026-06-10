package utils.Actions;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Map;

public class IOS_Actions extends Appium_Utils {
    IOSDriver driver;
    public IOS_Actions(IOSDriver driver){
        super(driver);
        this.driver = driver;
    }


    public void longPressIOS(WebElement element){
        Map<String, Object> params = new HashMap<>();
        params.put("element",((RemoteWebElement) element).getId());
        params.put("duration",3);
        driver.executeScript("mobile:touchAndHold", params);
    }


    public void scrollIOS(WebElement element){
        driver.executeScript("mobile: scroll", ImmutableMap.of(
                "direction", "down",
                "element", ((RemoteWebElement) element).getId()
        ));    }

    public void swipeOnElementIOS(WebElement element){
        driver.executeScript("mobile: swipe", ImmutableMap.of(
                "direction", "left",
                "element", ((RemoteWebElement) element).getId()
        ));
    }

    public void simpleSwipeIOS(WebElement element){
        driver.executeScript("mobile: swipe", ImmutableMap.of(
                "direction", "left",
                "velocity", 500
        ));
    }

    public void SlideIOS(WebElement element,String Value){
        element.sendKeys(Value+"%");
    }


}
