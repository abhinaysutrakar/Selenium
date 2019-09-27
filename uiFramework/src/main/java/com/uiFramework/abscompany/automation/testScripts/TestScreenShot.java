package com.uiFramework.abscompany.automation.testScripts;

import org.testng.annotations.Test;

import com.uiFramework.abscompany.automation.testbase.TestBase;

public class TestScreenShot extends TestBase {
	
	@Test
	public void testScreen() {
		driver.get("https://www.google.co.in/maps/");
		captureScreen("firstScreen");
	}
	
	
}
