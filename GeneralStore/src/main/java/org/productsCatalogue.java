package org;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import utils.Actions.Android_Actions;

import java.util.List;
public class productsCatalogue extends Android_Actions {
    AndroidDriver driver;

    public productsCatalogue(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
    }

    // ✅ كلها methods مش fields
    private List<WebElement> addToCartBtns() {
        return driver.findElements(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\" and @text=\"ADD TO CART\"]"));
    }
    private List<WebElement> productPrices() {
        return driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productPrice"));
    }
    private List<WebElement> productNames() {
        return driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productName"));
    }
    private WebElement cartBtn() {
        return driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart"));
    }
    private WebElement backBtn() {
        return driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_back"));
    }

    public WebElement addToCartBtnsByIndex(int index) {
        return addToCartBtns().get(index);
    }
    public WebElement findProductPriceByIndex(int index) {
        return productPrices().get(index);
    }
    public WebElement findProductNameByIndex(int index) {
        return productNames().get(index);
    }
    public void addProductToCartByIndex(int index) {
        scrollToElementByText("ADD TO CART");

        addToCartBtnsByIndex(index).click();
    }
    public WebElement findProductByName(String productName) {
        return driver.findElement(AppiumBy.xpath(
                "//android.widget.TextView[@text='" + productName + "']/following::android.widget.LinearLayout[2]/android.widget.TextView[@text='ADD TO CART']"
        ));
    }
    public void addProductToCartByName(String productName) {
        scrollToElementByText(productName);
        findProductByName(productName).click();
    }
    public cartPage goToCartPage() throws InterruptedException {
        cartBtn().click();
        Thread.sleep(2000);
        return new cartPage(driver);
    }
}