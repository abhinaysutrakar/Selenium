package com.uiFramework.abscompany.automation.helper.window;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.uiFramework.abscompany.automation.helper.logger.LoggerHelper;

public class windowHelper {

	private WebDriver driver;
	private Logger log =LoggerHelper.getLogger(windowHelper.class);
		
public windowHelper (WebDriver driver) {
		this.driver=driver;
		
	}

//this method will switch to parent window
public void swtichToParentWindow()
{
	log.info("Switching to parent window");
	driver.switchTo().defaultContent();
}


//this method will switch to child window based on child window
public void swtichToWindow(int index)
{
	log.info("Switching to "+index+"th Window");
	Set<String> windows = driver.getWindowHandles();
	int i = 1;
	for (String window:windows)
		if (i==index)
		{
			log.info("switched to : " +index+ "window");
			driver.switchTo().window(window);
		}
		else
		{
			i++;
		}
	
}

/**
 * this method will close all windows
 */

public void closeAllTabsandSwitchtoMainWindow()
{
	Set<String> windows = driver.getWindowHandles();
	String mainWindow=driver.getWindowHandle();
	for(String window: windows)
	{
	if (!window.equalsIgnoreCase(mainWindow))
	{
		log.info("switch to close all tabs");
		driver.close();
	}
	}
	log.info("switch to mainwindow");
	driver.switchTo().window(mainWindow);
}    

/**
 * this method will do browser back navigation back
 */
public void navigateBack() {
	driver.navigate().back();
}

/**
 * this method will do browser back navigation forward
 */
public void navigateForward()
{
	driver.navigate().forward();
}

public void refreshpage()
{
	driver.navigate().refresh();
}

}
















