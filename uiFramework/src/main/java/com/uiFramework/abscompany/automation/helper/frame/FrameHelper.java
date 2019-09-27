package com.uiFramework.abscompany.automation.helper.frame;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uiFramework.abscompany.automation.helper.logger.LoggerHelper;

public class FrameHelper {
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(FrameHelper.class);
	
	public FrameHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	public void switchToFrame(int frameIndex)
	{
		driver.switchTo().frame(frameIndex);
		log.info("Switched to :"+frameIndex+"frame");
	}
	public void switchToFrame(String frameName)
	{
		driver.switchTo().frame(frameName);
		log.info("Switched to :"+frameName+"frame");
	}
	public void switchToFrame(WebElement element)
	{
		driver.switchTo().frame(element);
		log.info("Switched to :"+element.toString());
	}

}
