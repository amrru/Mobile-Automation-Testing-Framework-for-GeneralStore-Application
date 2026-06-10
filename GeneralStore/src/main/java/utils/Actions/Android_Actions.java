package utils.Actions;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class Android_Actions extends Appium_Utils {
    AndroidDriver driver ;

    public Android_Actions(AndroidDriver driver){
        super(driver);
        this.driver = driver;
    }

    public  void longPressAction(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of(
                        "elementId", ((RemoteWebElement) element).getId(),
                        "duration", 2000
                )
        );
    }

    public  WebElement scrollToElementByText(String text) {
        return driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\"" + text + "\"))"
        ));
    }

    public  WebElement scrollToElementByResourceId(String resourceId) {
        return driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().resourceId(\"" + resourceId + "\"))"
        ));
    }

    public  WebElement scrollToElementByClassName(String className) {
        return driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().className(\"" + className + "\"))"
        ));
    }

    public  boolean scrollbyPercent(String direction, int percent){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (boolean) js.executeScript("mobile: scrollGesture", ImmutableMap.of("left",100,"top",100,"width",200,
                "height",200,"direction",direction,"percent",percent));
    }

    public  void scrolluntilTheEnd(String direction, int percent){
        do{scrollbyPercent(direction,percent);

        }while(scrollbyPercent(direction,percent));
    }

    public  void SwipeByPercent(String direction, int percent){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("mobile: swipeGesture", ImmutableMap.of("left",100,"top",100,"width",200,
                "height",200,"direction",direction,"percent",percent));


    }

    public  void SwipeInsideElement(String direction, long percent,WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript( "mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(), // restrict swipe to this element
                "direction", direction,   // swipe direction: up, down, left, right
                "percent", percent ));
    }

    public  void dragAndDropByCoords(WebElement startElement, long x, long y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) startElement).getId(),
                "endX", x,
                "endY", y
        ));
    }
    public  void dragAndDropToAnotherElement(WebElement startElement, WebElement endElement){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) startElement).getId(),
                "endX", endElement.getLocation().getX(),
                "endY", endElement.getLocation().getY()

        ));

    }
}
