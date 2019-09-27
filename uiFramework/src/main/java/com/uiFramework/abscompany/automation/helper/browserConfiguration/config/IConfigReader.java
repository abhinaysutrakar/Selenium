package com.uiFramework.abscompany.automation.helper.browserConfiguration.config;

import com.uiFramework.abscompany.automation.helper.browserConfiguration.BrowserType;

public interface IConfigReader {
	
	public int getImplicitWait();
	public int getExplicitWait();
	public int pageLoadTimeOut();
	public BrowserType getBrowserType();
}
