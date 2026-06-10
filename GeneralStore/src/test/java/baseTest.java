import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.formPage;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.Actions.Appium_Utils;
import utils.MediaManager.ScreenShotManager;
import utils.WaitManager;
import utils.dataReaders.JsonReader;
import utils.dataReaders.PropertyReader;

import java.io.IOException;
import java.util.Arrays;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class baseTest {

    AndroidDriver driver;
    AppiumDriverLocalService service;  // ← متغير عشان نوصله في AfterTest
    public formPage loginPage;
    ExtentReports extent;
    ExtentTest test;

    @BeforeClass
    public void setup() throws MalformedURLException, URISyntaxException {
        service = Appium_Utils.startAppiumServer(PropertyReader.getPropertyValue("ipAddress"),PropertyReader.getPropertyValue("port"));
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("7c59a846");
        options.setChromedriverExecutable("C:\\Users\\Amr\\Desktop\\iti-testing\\drivers\\chromedriver-win64\\chromedriver.exe");
        options.setApp("C:\\Users\\Amr\\IdeaProjects\\GeneralStore\\src\\main\\resources\\General-Store.apk"); // 👈 Your APK
        options.setNoReset(true);
        options.setFullReset(false);
        options.setCapability("dontStopAppOnReset", true);
        options.setCapability("skipDeviceInitialization", true);
        options.setCapability("ignoreHiddenApiPolicyError", true);

        driver = new AndroidDriver(
                new URI("http://127.0.0.1:4723").toURL(), options
        );
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        loginPage = new formPage(driver);
    }



    @AfterMethod
    public void screenshotOnFailure(@NotNull ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            System.out.println("Failed!");
            System.out.println("Taking a screenshot");
            try {
                ScreenShotManager.captureScreenshot(driver,result.getName());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @BeforeMethod
    public void restartApp() throws InterruptedException {
        driver.terminateApp("com.androidsample.generalstore");
        Thread.sleep(2000);
        driver.activateApp("com.androidsample.generalstore");
        Thread.sleep(3000);
    }




    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.terminateApp("com.androidsample.generalstore");
            driver.quit();
        }

        if (service != null) {
            service.stop();
        }
    }
}