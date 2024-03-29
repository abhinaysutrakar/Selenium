package com.uiFramework.abscompany.automation.helper.browserConfiguration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.uiFramework.abscompany.automation.helper.resource.ResourceHelper;

public class FirefoxBrowser {
	
	public FirefoxOptions getFirefoxOptions()
	{
		DesiredCapabilities firefox = DesiredCapabilities.firefox();
		
		FirefoxProfile profile = new FirefoxProfile();
		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(true);
		
		firefox.setCapability(FirefoxDriver.PROFILE, profile);
		firefox.setCapability("marionette", true);
		
		FirefoxOptions firefoxOptions= new FirefoxOptions(firefox);
		
		if(System.getProperty("os.name").contains("Linux"))
		{
			firefoxOptions.addArguments("--headless","window-size=1024,768","no-sandbox");
		}
		return firefoxOptions;
	}

	public WebDriver getFirefoxDriver(FirefoxOptions cap)
	{
				
		if(System.getProperty("os.name").contains("Mac"))
				{
				System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath("C:\\Users\\abhinay.sutrakar\\Desktop\\uiFramework\\geckodriver"));
				return new FirefoxDriver(cap);
				}
		else if(System.getProperty("os.name").contains("Window"))
		{
		System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath("C:\\Users\\abhinay.sutrakar\\Desktop\\uiFramework\\geckodriver.exe"));
		return new FirefoxDriver(cap);
		}
		else if(System.getProperty("os.name").contains("Linux"))
		{
		System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath("C:\\Users\\abhinay.sutrakar\\Desktop\\uiFramework\\geckodriver"));
		return new FirefoxDriver(cap);
		}
		return null;
		
	}
}
