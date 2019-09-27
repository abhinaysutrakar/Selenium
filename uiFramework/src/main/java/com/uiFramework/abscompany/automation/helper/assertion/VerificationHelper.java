package com.uiFramework.abscompany.automation.helper.assertion;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uiFramework.abscompany.automation.helper.logger.LoggerHelper;

public class VerificationHelper {
	private WebDriver driver;
	
private Logger log =LoggerHelper.getLogger(VerificationHelper.class);
	
public VerificationHelper(WebDriver driver) {
	this.driver=driver;
	
}

public boolean isDisplayed(WebElement element) {
	try {
		element.isDisplayed();
		log.info("element is Displayed.."+element.getText());
		return true;
	}
	
	catch(Exception e)
	{
		log.info("element is not Displayed",e.getCause());
		return false;
	}

}
public boolean isNotDisplayed(WebElement element) {
		try {
			element.isDisplayed();
			log.info("element is not Displayed.."+element.getText());
			return false;
		}
		
		catch(Exception e)
		{
			log.info("element is  Displayed",e.getCause());
			return true;
		}
		}

public String getText(WebElement element)
{
	if(null==element) {
		log.info("WebElement is null");
	return null;
	}
	
	boolean status=isDisplayed(element);
	if(status)
	{
		log.info("element text is .. "+element.getText());
		return element.getText();
		
	}
	else {
		return null;
	}
}

	public boolean isEnabled(WebElement element) {
		try {
			element.isEnabled();
			log.info("element is enabled.."+element.getText());
			return true;
		}
		
		catch(Exception e)
		{
			log.info("element is not enabled",e.getCause());
			return false;
		}
		}

	public boolean isSelected(WebElement element) {
		try {
			element.isSelected();
			log.info("element is selected.."+element.getText());
			return true;
		}
		
		catch(Exception e)
		{
			log.info("element is not selected",e.getCause());
			return false;
		}
		}
	
	public String getTitle()
	{
		log.info("Title of the page is"+driver.getTitle());
		return driver.getTitle();
		
	}

}
