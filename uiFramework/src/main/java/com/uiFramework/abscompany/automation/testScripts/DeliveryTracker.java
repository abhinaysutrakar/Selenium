package com.uiFramework.abscompany.automation.testScripts;

import java.util.concurrent.TimeUnit;
import com.google.maps.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.uiFramework.abscompany.automation.helper.javaScript.javaScriptHelper;
import com.uiFramework.abscompany.automation.helper.wait.WaitHelper;
import com.uiFramework.abscompany.automation.testbase.TestBase;

public class DeliveryTracker extends TestBase {
	
public String srcLocation="LogiNext Solutions, A901 Supreme Business Park,, South Avenue,, Near Hiranandani Gardens,, Powai, Mumbai, Maharashtra 400076";	
public String destLocation="Magarpatta, Hadapsar, Pune, Maharashtra";	

@Test(description="Open browser and redirect to Google Map Application",priority=1)
	public void openGoogleMaps()
	{
		driver.get("https://www.google.co.in/maps/");
		
	}
	
	@Test(description="Search Destination Location",priority=2)
	public void enterDestinationLocation()
	{
		WebElement destSearch= driver.findElement(By.id("searchboxinput"));
		destSearch.sendKeys(destLocation);
		destSearch.sendKeys(Keys.ENTER);
	}
	
	@Test(description="route for direction",priority=3)
	public void directionsoption()
	{
		WebElement direction= driver.findElement(By.xpath("//*[@class=\"iRxY3GoUYUY__taparea\" and @data-value=\"Directions\"]"));
		System.out.println(direction);
		direction.click();
	}
	
	@Test(description="Search source Location",priority=3)
	public void entersourceLocation()
	{	
		WaitHelper wait=new WaitHelper(driver);
		wait.pageLoadTimeOut(30,TimeUnit.SECONDS);
		WebElement srcSearch= driver.findElement(By.xpath("//*[@id='directions-searchbox-0']/child::div/div/input[@class='tactile-searchbox-input']"));
		System.out.println(srcSearch);
		srcSearch.click();
		wait.setImplicitWait(10, TimeUnit.SECONDS);
		srcSearch.sendKeys(srcLocation);
		srcSearch.sendKeys(Keys.ENTER);
	}
	
	@Test(description="Click on Marker",priority=4)
	public void selectMarker()
	{	
				
		WebElement destMarker= driver.findElement(By.xpath("//title[contains(text(),'Magarpatta, Hadapsar, Pune, Maharashtra')]"));
	    WebElement srcMarker= driver.findElement(By.xpath("//title[contains(text(),'LogiNext Solutions')]"));
		Actions action = new Actions(driver);
	    action.moveToElement(destMarker).click().build().perform();
		
		destMarker.click();
	    srcMarker.click();
		
		
	}
}
