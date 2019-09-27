package com.uiFramework.absecompany.automation.testNG;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryTest {
	
	@Test(retryAnalyzer = com.uiFramework.absecompany.automation.retryAnalyzer.RetryAnalyzer.class)
	
	public void test1()
	{
		Assert.assertEquals(false, true);
	}
	
	@Test
	public void test2()
	{
		Assert.assertEquals(false, true);
	}
}
