package com.uiFramework.absecompany.automation.retryAnalyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer
{
 int counter =0;
 int retrylimit=3;
 
 public boolean retry(ITestResult result)
 {
	 if (counter<retrylimit)
	 {
		 counter++;
		 return true;
	 }
	 else {
		 return false;
	 }
	 
 }
}
