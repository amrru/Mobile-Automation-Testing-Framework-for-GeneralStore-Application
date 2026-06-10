package utils.Actions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;

public class Appium_Utils {

    AppiumDriver driver;
    public Appium_Utils(AppiumDriver driver){
        this.driver = driver;
    }

    public double getFormattedAmount(String amount){
        double price = Double.parseDouble(amount.replace("$", "").trim());
        return price;
    }

    public static AppiumDriverLocalService startAppiumServer(String ipAddress,String port){
        AppiumDriverLocalService service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\Amr\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress(ipAddress)
                .usingPort(Integer.parseInt(port))
                .build();
        service.start();
        return service;

    }



}
