package com.uiFramework.absecompany.automation.testNG;

import org.testng.annotations.Test;

public class InvocationCount {

	@Test(invocationCount = 10)
	public void test1() {
		int i=10;
		int j=20;
		int k=i+j;
		
		System.out.println("sum is :"+k);
		
	}
}
