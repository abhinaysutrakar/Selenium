package com.uiFramework.abscompany.automation.helper.browserConfiguration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.uiFramework.abscompany.automation.helper.resource.ResourceHelper;

import net.bytebuddy.asm.Advice.Return;

public class ChromeBrowser {
	
	public ChromeOptions getChromeOptions()
	{
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--test-type");
		option.addArguments("--disable-popup-blocking");
		
		DesiredCapabilities chrome = DesiredCapabilities.chrome();
		
		chrome.setJavascriptEnabled(true);
		
		option.setCapability(ChromeOptions.CAPABILITY, chrome);
		
		if(System.getProperty("os.name").contains("linux"))
				{
			option.addArguments("--headless","window-size=1024,768","no-sandbox");
			
				}
		return option;
	}
	
	public WebDriver getChromeDriver(ChromeOptions cap)
	{
				
		if(System.getProperty("os.name").contains("Mac"))
				{
				System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath("C:/Users/abhinay.sutrakar/Desktop/uiFramework/chromedriver.exe"));
				return new ChromeDriver(cap);
				}
		else if(System.getProperty("os.name").contains("Window"))
		{
		System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath("chromedriver.exe"));
		return new ChromeDriver(cap);
		}
		else if(System.getProperty("os.name").contains("Linux"))
		{
		System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath("C:/Users/abhinay.sutrakar/Desktop/uiFramework/chromedriver.exe"));
		return new ChromeDriver(cap);
		}
		return null;
		
	}

}
