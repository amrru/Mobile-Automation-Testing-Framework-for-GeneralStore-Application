import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class baseTestIOS {


    IOSDriver driver;
    AppiumDriverLocalService service;  // ← متغير عشان نوصله في AfterTest
    WebDriver driverWeb;
    @BeforeTest
    public void setup() throws MalformedURLException, URISyntaxException {



        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\Amr\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        service.start();

        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("7c59a846");
         options.setApp("C:\\Users\\Amr\\IdeaProjects\\GeneralStore\\src\\main\\resources\\General-Store.apk"); // 👈 Your APK
        options.setNoReset(true);
        options.setFullReset(false);
        options.setCapability("dontStopAppOnReset", true);
        options.setCapability("skipDeviceInitialization", true);
        options.setCapability("ignoreHiddenApiPolicyError", true);
        options.setWdaLaunchTimeout(Duration.ofSeconds(20));
        options.setPlatformVersion("15.5");
        driver = new IOSDriver(
                new URI("http://127.0.0.1:4723").toURL(), options
        );
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
        if (driverWeb != null) {
            driverWeb.quit(); // 👈 قفل الكروم
        }
        if (service != null) {
            service.stop();
        }
    }

}
