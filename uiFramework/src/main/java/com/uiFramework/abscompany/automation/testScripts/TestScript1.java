package com.uiFramework.abscompany.automation.testScripts;

import org.testng.annotations.Test;

import com.uiFramework.abscompany.automation.helper.assertion.AssertionHelper;
import com.uiFramework.abscompany.automation.testbase.TestBase;

public class TestScript1 extends TestBase{
	
	@Test
	public void testLogin()
	{
		AssertionHelper.makeTrue();
	}
	@Test
	public void testLogin1()
	{
		AssertionHelper.makeFalse();
	}
	@Test
	public void testLogin2()
	{
		AssertionHelper.makeTrue();
		
	}
	@Test
	public void testLogin3()
	{
		AssertionHelper.makeFalse();
		
	}
	
	
}
