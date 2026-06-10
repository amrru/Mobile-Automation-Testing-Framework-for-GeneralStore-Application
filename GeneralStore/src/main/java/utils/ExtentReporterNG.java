package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
   static ExtentReports extent;
    static ExtentTest test;

    public static ExtentReports setupReport() {
        ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\Amr\\IdeaProjects\\GeneralStore\\reports\\index.html");
        extent = new ExtentReports();
        spark.config().setReportName("Mobile Automation Results");
        spark.config().setDocumentTitle("Test Results");
        extent.attachReporter(spark);
        extent.setSystemInfo("Tester","Amr Khaled");
        return extent;
    }

}
