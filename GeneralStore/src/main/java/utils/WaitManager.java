package utils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import utils.Actions.Appium_Utils;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;
import java.util.ArrayList;

public class WaitManager extends Appium_Utils {

    private AppiumDriver driver;

    public WaitManager(AppiumDriver driver){
        super(driver);
        this.driver = driver;
    }

    public FluentWait<AppiumDriver> fluentWait(){

        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(2))
                .pollingEvery(Duration.ofMillis(100))
                .ignoreAll(getExceptions());
    }

    private ArrayList<Class<? extends Exception>> getExceptions() {
        ArrayList<Class<? extends Exception>> exceptions = new ArrayList<>();
        // Reflection / field issues
        exceptions.add(NoSuchFieldException.class);
        exceptions.add(NoSuchMethodException.class);
        exceptions.add(IllegalAccessException.class);
        exceptions.add(InstantiationException.class);

        // I/O and file handling
        exceptions.add(IOException.class);
        exceptions.add(FileNotFoundException.class);
        exceptions.add(EOFException.class);

        // Runtime / unchecked exceptions
        exceptions.add(NullPointerException.class);
        exceptions.add(IndexOutOfBoundsException.class);
        exceptions.add(ArrayIndexOutOfBoundsException.class);
        exceptions.add(IllegalArgumentException.class);
        exceptions.add(ClassCastException.class);
        exceptions.add(ArithmeticException.class);

        // Class loading
        exceptions.add(ClassNotFoundException.class);

        // Threading / concurrency
        exceptions.add(InterruptedException.class);

        // Parsing / formatting
        exceptions.add(NumberFormatException.class);
        exceptions.add(ParseException.class);

        return exceptions;
    }

    public WebElement waitForVisibility(AppiumBy locator) {
        return fluentWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForClickability(AppiumBy locator) {
        return fluentWait().until(ExpectedConditions.elementToBeClickable(locator));
    }



}

/*

WebElement element = waitManager.fluentWait()

        .until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.widget.TextView[@text='ADD TO CART']")
        ));

WebElement button = waitManager.fluentWait()
        .until(ExpectedConditions.elementToBeClickable(
                AppiumBy.id("com.androidsample.generalstore:id/btnProceed")
        ));
button.click();


*/