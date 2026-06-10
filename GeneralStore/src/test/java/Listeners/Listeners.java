package Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ExtentReporterNG;
import utils.MediaManager.ScreenShotManager;
import java.io.File;
import java.io.IOException;

import static utils.ExtentReporterNG.setupReport;

public class Listeners implements ITestListener {

    ExtentReports extent=  ExtentReporterNG.setupReport();
    ExtentTest test;

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS,"Test Passed" );
    }

    @Override
    public void onTestFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Failed!");
            System.out.println("Taking a screenshot");

            try {
                AndroidDriver driver = (AndroidDriver) result.getInstance()
                        .getClass()
                        .getField("driver")
                        .get(result.getInstance());

                ScreenShotManager.captureScreenshot(driver, result.getName());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        test.fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test skipped");
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush(); // Write the report at the end
    }


}
