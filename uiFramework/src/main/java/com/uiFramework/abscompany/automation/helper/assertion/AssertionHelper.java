package com.uiFramework.abscompany.automation.helper.assertion;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.uiFramework.abscompany.automation.helper.logger.LoggerHelper;

public class AssertionHelper {
	private Logger log=LoggerHelper.getLogger(AssertionHelper.class);
	
public static void verifyText(String s1,String s2)
{
	Assert.assertEquals(s1, s2);
}

public static void makeTrue()
{
	Assert.assertTrue(true);
}

public static void makeTrue(String message)
{
	Assert.assertTrue(true,message);
}

public static void makeFalse()
{
	Assert.assertTrue(false);
}

public static void makeFalse(String message)
{
	Assert.assertTrue(false,message);
}

}
