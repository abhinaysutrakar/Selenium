package com.uiFramework.abscompany.automation.helper.javaScript;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uiFramework.abscompany.automation.helper.logger.LoggerHelper;

public class javaScriptHelper {
	
	private WebDriver driver;
	
	private Logger log =LoggerHelper.getLogger(javaScriptHelper.class);
	
	public javaScriptHelper(WebDriver driver)
	{
		this.driver=driver;
		log.info("JavaScript Executor is initiated");
		
	}
	
	public Object executeScript(String script)
	{
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		return exe.executeScript(script);
	}
	
	public Object executeScript(String script,Object...args)
	{
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		return exe.executeScript(script,args);
	}

	public void scrollToElement(WebElement element)
	{
		log.info("Scroll to webelement");
		executeScript("window.scrollTo(arguments[0],arguments[1])",element.getLocation().x,element.getLocation().y);
	}
	
	public void scrollToElementAndClick(WebElement element)
	{
		scrollToElement(element);
		element.click();
		log.info("Scroll to element and clicked"+element.toString());
		
	}
	
	public void scrollIntoView(WebElement element)
		{
		log.info("Scroll till web element");
		executeScript("arguments[0].scrollIntoView()",element);
		
	}
	
	public void scrollIntoViewAndClick(WebElement element)
	{
		scrollIntoView(element);
		element.click();
		log.info("Scroll to element and clicked"+element.toString());
		
	}
	
	public void scrollDownVertically(WebElement element)
	{
		log.info("Scrolling down vertically");
		executeScript("window.scrollTo(0,document.body.scrollHeight)");
				
	}
	
	public void scrollUpVertically(WebElement element)
	{
		log.info("Scrolling up vertically");
		executeScript("window.scrollTo(0,-document.body.scrollHeight)");
				
	}
	
	public void scrollDownByPixel(int pixel)
	{
		log.info("Scrolling down vertically");
		executeScript("window.scrollBY(0,"+pixel+")");
				
	}
	
	public void scrollUpByPixel(int pixel)
	{
		log.info("Scrolling down vertically");
		executeScript("window.scrollBY(0,-"+pixel+")");
				
	}
	
	public void zoomInBy100Percentage()
	{
		log.info("Zoom in 100 %");
		executeScript("document.body.style.zoom='100%'");
				
	}
	
	public void zoomInBy60Percentage()
	{
		log.info("Zoom in 60%");
		executeScript("document.body.style.zoom='60%'");
				
	}
	
	public void ClickElement(WebElement element)
	{
		log.info("this method will click on top of window");
		executeScript("arguments[0].click();",element);
				
	}
}
