package com.uiFramework.abscompany.automation.helper.select;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.uiFramework.abscompany.automation.helper.logger.LoggerHelper;

public class DropdownHelper {
	private WebDriver driver;
	
	private Logger log = LoggerHelper.getLogger(DropdownHelper.class);
	
	
public DropdownHelper(WebDriver driver)
{
	this.driver=driver;
	log.info("DropDownHelper  object initialized..");
}

public void selectUsingValue(WebElement element,String value)
{
	Select select = new Select(element);
	log.info("select dropdown using value" + value);
	select.selectByValue(value);
	
}
	
public void selectUsingIndex(WebElement element,int index)
{
	Select select = new Select(element);
	log.info("select dropdown using idex" + index);
	select.selectByIndex(index);
	
}

public void selectUsingVisibleText(WebElement element,String visibleText)
{
	Select select = new Select(element);
	log.info("select dropdown using idex" + visibleText);
	select.selectByVisibleText(visibleText);
	
}


public void deselectUsingValue(WebElement element,String value)
{
	Select select = new Select(element);
	log.info("select dropdown using value" + value);
	select.deselectByValue(value);
	
}
	
public void deselectUsingIndex(WebElement element,int index)
{
	Select select = new Select(element);
	log.info("select dropdown using idex" + index);
	select.deselectByIndex(index);
	
}

public void deselectUsingVisibleText(WebElement element,String visibleText)
{
	Select select = new Select(element);
	log.info("select dropdown using idex" + visibleText);
	select.deselectByVisibleText(visibleText);
	
}

public List<String> getAllDropDownData(WebElement element)
{
	Select select = new Select(element);
	List<WebElement> elementlist = select.getOptions();
	List<String> valuelist = new LinkedList<String>();
	
	for(WebElement ele :elementlist)
	{
	log.info(ele.getText());	
	valuelist.add(ele.getText());
	}
	return valuelist;
}

}
