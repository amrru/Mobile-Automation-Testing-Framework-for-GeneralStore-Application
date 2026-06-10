package org;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import utils.Actions.Android_Actions;

import java.util.List;

public class cartPage extends Android_Actions {
    AndroidDriver driver;

    public cartPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
    }

    private List<WebElement> productNames() {
        return driver.findElements(
                AppiumBy.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName']")
        );
    }

    private List<WebElement> productPrices() {
        return driver.findElements(
                AppiumBy.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productPrice']")
        );
    }

    private WebElement productName(int index) {
        return productNames().get(index);
    }

    private WebElement productPrice(int index) {
        return productPrices().get(index);
    }

    private WebElement totalPrice(){
        return driver.findElement(
                AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/totalAmountLbl\"]")
        );
    }

    private WebElement checkBox(){
        return driver.findElement(
                AppiumBy.className("android.widget.CheckBox")
        );
    }

    private WebElement veiwBtn(){
        return driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed"));
    }
    private WebElement terms(){
        return driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/termsButton"));
    }

    public double getPrice(int index){
        String priceS = productPrice(index).getText();
        double price = Double.parseDouble(priceS.replace("$", "").trim());
        return price;
    }


    public double getTotalPrice(){
        String priceS = totalPrice().getText();
        double price = Double.parseDouble(priceS.replace("$", "").trim());
        return price;
    }

    public String getProductName(int index){
        return productName(index).getText();
    }


    public double totalSelectedPrice(){
        int sizeOfList = productPrices().size();
        double sum=0;
        for(int i = 0 ; i < sizeOfList ; i++){
            sum+=getPrice(i);
        }
        return sum;
    }

public void clickOnCheckBox(){
        checkBox().click();
}

public void clickOnBtn(){
        veiwBtn().click();
}
public void longPressterms(){
        longPressAction(terms());
}
}
