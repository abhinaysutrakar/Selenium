package com.uiFramework.abscompany.automation.helper.browserConfiguration.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import com.uiFramework.abscompany.automation.helper.browserConfiguration.BrowserType;
import com.uiFramework.abscompany.automation.helper.resource.ResourceHelper;

public class PropertyReader implements IConfigReader {
	private static FileInputStream file;
	public static Properties OR;

	public PropertyReader() {

		try {
			String filePath = ResourceHelper.getResourcePath("src\\main\\resources\\configfile\\config.properties");
			file = new FileInputStream(new File(filePath));
			OR = new Properties();
			OR.load(file);
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getImplicitWait() {
		// TODO Auto-generated method stub
		return Integer.parseInt(OR.getProperty("implicitwait"));

	}

	public int getExplicitWait() {
		// TODO Auto-generated method stub
		return Integer.parseInt(OR.getProperty("explicitwait"));
		

	}

	public int pageLoadTimeOut() {
		// TODO Auto-generated method stub
		return Integer.parseInt(OR.getProperty("pageloadtime"));
	}

	public BrowserType getBrowserType() {
		// TODO Auto-generated method stub
		return BrowserType.valueOf(OR.getProperty("browserType"));
	}

}
