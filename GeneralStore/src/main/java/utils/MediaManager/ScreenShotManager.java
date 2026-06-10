package utils.MediaManager;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScreenShotManager {


    public static void captureScreenshot(AndroidDriver driver, String screenshotName) throws IOException {
        Path dest = Paths.get("./screenshots",screenshotName+".jpg");
        Files.createDirectories(dest.getParent());
        FileOutputStream out = new FileOutputStream(dest.toString());
        out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
        out.close();
    }

}
