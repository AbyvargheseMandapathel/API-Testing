package com.ust.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;



public class ExtendReportListener implements ITestListener {

    ExtentTest test;
    ExtentReports report;

   
    public void onStart(ITestContext context) {
       
        report = ReportManager.createIntance();
    }

   
    public void onTestStart(ITestResult result) {
      
        test = ReportManager.createTest(result, report);
    }

    
    public void onTestSuccess(ITestResult result) {
        
        test.log(Status.PASS, result.getName() + " Passed");
        
       
    }

    
    public void onTestFailure(ITestResult result) {
       
        test.log(Status.FAIL, result.getName() + " Failed");
        
       
        
    }

    
    public void onTestSkipped(ITestResult result) {
       
    }

    
    public void onFinish(ITestContext context) {
       
        report.flush();
    }
}
