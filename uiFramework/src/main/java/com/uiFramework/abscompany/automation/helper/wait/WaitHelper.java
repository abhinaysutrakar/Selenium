package com.uiFramework.abscompany.automation.helper.wait;

import java.util.concurrent.TimeUnit;

import javax.swing.text.Element;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.uiFramework.abscompany.automation.helper.logger.LoggerHelper;

import okio.Timeout;

public class WaitHelper {
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(WaitHelper.class);
			
	public WaitHelper(WebDriver driver) {
		this.driver=driver;

	}
			
/**
 * This is Implicit wait method 
 * @param element
 * @param timeOutInSeconds
 */
	public void setImplicitWait(long timeout, TimeUnit unit) {
		log.info("Implicit Wait has been set to :"+ timeout);
		driver.manage().timeouts().implicitlyWait(timeout, unit);
	}
	
/**
 * This method will get WebDriver wait object.
 * @param timeOutInSeconds
 * @param PollingEveryInMiliSec
 * @return
 */
	
	private WebDriverWait getWait(int timeOutInSeconds,int PollingEveryInMiliSec) {
		
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		//wait.pollingEvery(java.time.Duration.ofMillis(PollingEveryInMiliSec));
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;
	}
	
	/**
	 * This is method is ensure to check element is visible
	 * @param element
	 * @param timeOutInSeconds
	 * @param PollingEveryInMiliSec
	 */
	public void WaitforElementVisibleWithPollingTime(WebElement element,int timeOutInSeconds, int PollingEveryInMiliSec)
	{
		log.info("waiting for :"+element.toString()+"for"+ timeOutInSeconds+"seconds");
		WebDriverWait wait = getWait(timeOutInSeconds, PollingEveryInMiliSec);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("element is visible now");
	}
	
/**
 * This method ensure that element is click able.
 * @param element
 * @param timeOutInSeconds
 */
	public void WaitforElementClickable(WebElement element,int timeOutInSeconds)
	{
		log.info("waiting for :"+element.toString()+"for"+ timeOutInSeconds+"seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		log.info("element is clickable now");
	}
	
/**
 * This method is ensure to invisibility of elements.
 * @param element
 * @param timeOutInSeconds
 * @return
 */
	public boolean WaitforElementNotPresent(WebElement element,long timeOutInSeconds)
	{
		log.info("waiting for :"+element.toString()+"for"+ timeOutInSeconds+"seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		boolean status = wait.until(ExpectedConditions.invisibilityOf(element));
		log.info("element is clickable now");
		return status;
	}
	
/**
 * This method will wait for frame and switch to it .
 * @param element
 * @param timeOutInSeconds
 */
	public void WaitforframeToBeAvailableAndSwitchToIt(WebElement element,long timeOutInSeconds)
	{
		log.info("waiting for :"+element.toString()+"for"+ timeOutInSeconds+"seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		log.info("frame is available and switched now");
		
	}
	
	//this method will give you fluent wait object 
	
	private Wait<WebDriver> getFluentWait(int timeOutInSeconds,int PollingEveryInMiliSec )
	{
	Wait<WebDriver> fWait = new FluentWait<WebDriver>(driver);
			//.withTimeout(java.time.Duration.ofSeconds(timeOutInSeconds))
			//.pollingEvery(java.time.Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
	return fWait;
		
	}
	
	public WebElement waitForElement(WebElement element,int timeOutInSeconds,int PollingEveryMiliSec)
	{

	Wait<WebDriver> fWait=getFluentWait(timeOutInSeconds,PollingEveryMiliSec);
	fWait.until(ExpectedConditions.visibilityOf(element));
	return element;
		
	}
	
	public void pageLoadTimeOut(long timeout,TimeUnit unit)
	{
		log.info("waiting for page to load for :"+unit);
		
		driver.manage().timeouts().pageLoadTimeout(timeout, unit);
		log.info("page Loaded..");
	}
}
