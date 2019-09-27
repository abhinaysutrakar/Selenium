package com.uiFramework.abscompany.automation.helper.alert;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uiFramework.abscompany.automation.helper.logger.LoggerHelper;

public class AlertHelper {
private WebDriver driver;
	
private Logger log =LoggerHelper.getLogger(AlertHelper.class);

private AlertHelper(WebDriver driver)
{
	this.driver=driver;
	log.info("Alert Object is Created");
}

public Alert getAlert()
{
	log.info("alert test : " + driver.switchTo().alert().getText());
	return driver.switchTo().alert();
}

public void acceptAlert()
{
	getAlert().accept();
	log.info("alert accepted");

}

public void dismissAlert()
{
	getAlert().dismiss();
	log.info("alert dismissed");

}

public String getAlertText()
{
	String text= getAlert().getText();
	
	log.info("alert text"+text);
	
	return text;

}


public boolean isAlertPresent()
{
	try {
		driver.switchTo().alert();
		log.info("Alert is present");
		return true;
	}
	catch(NoAlertPresentException e)
	{
	log.info(e.getCause());	
	return false;
	}
}


public void acceptAlertIfPresent()
{
	if(isAlertPresent())
	{
		acceptAlert();
	}
	else {
		log.info("Alert is not present");
	}
}

public void dismissAlertIfPresent()
{
	if(isAlertPresent())
	{
		dismissAlert();
		}
	else {
		log.info("Alert is not present");
	}
}

public void acceptPrompt(String text)
{
	if(isAlertPresent())
	{
		Alert alert = getAlert();
		alert.sendKeys(text);
		alert.accept();
		log.info("accept aler is done");
	}
}

}
