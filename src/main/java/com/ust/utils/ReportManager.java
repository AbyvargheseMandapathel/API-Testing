package com.ust.utils;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ReportManager {
   
    public static ExtentReports extent;
    public static ExtentSparkReporter htmlReporter;
    public static ExtentTest test;
    
    
    public static ExtentReports createIntance() {
       
        String repname = "TestReport-" + System.currentTimeMillis()+".html";
       
        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//reports//" + repname);
        
        htmlReporter.config().setDocumentTitle("Extent Report Demo");
        htmlReporter.config().setReportName("Test Report");
        htmlReporter.config().setTimelineEnabled(true);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setTimeStampFormat("MM/dd/yyyy HH:mm:ss");
        
        extent = new ExtentReports();
       
        extent.attachReporter(htmlReporter);
       
        extent.setSystemInfo("Os", "Windows");
        extent.setSystemInfo("HostName", "localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("UserName", "Aby");
        return extent;
    }

   
    public static ExtentTest createTest(ITestResult result, ExtentReports report) {
        
    	String testName = "Test " + result.getName();
        test = report.createTest(testName);
        return test;
    }
}
