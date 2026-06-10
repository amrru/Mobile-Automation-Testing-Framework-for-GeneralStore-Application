package org;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import utils.Actions.Android_Actions;
public class formPage extends Android_Actions {
    AndroidDriver driver;

    public formPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private WebElement nameField() {
        return driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.androidsample.generalstore:id/nameField\"]"));
    }
    private WebElement country() {
        return driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry"));
    }
    private WebElement maleOption() {
        return driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioMale"));
    }
    private WebElement femaleOption() {
        return driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale"));
    }
    private WebElement submitBtn() {
        return driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop"));
    }

    public void setNameField(String name) {
        nameField().sendKeys(name);
    }
    public void setMaleOption() {
        maleOption().click();
    }
    public void setFemaleOption() {
        femaleOption().click();
    }
    public void selectCountry(String country) {
        scrollToElementByText(country);
        driver.findElement(AppiumBy.xpath(
                "//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"" + country + "\"]"
        )).click();
    }

    public productsCatalogue clickButton() {
        submitBtn().click();
        return new productsCatalogue(driver);
    }

}