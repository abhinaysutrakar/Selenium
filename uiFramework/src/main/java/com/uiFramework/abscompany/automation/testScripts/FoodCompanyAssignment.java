package com.uiFramework.abscompany.automation.testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.uiFramework.abscompany.automation.testbase.TestBase;

public class FoodCompanyAssignment extends TestBase {
	
	@Test (priority = 1)
	public void login() {
		driver.get("https://clubkitchen.at/");
		WebElement menubutton= driver.findElement(By.xpath("//span[@class='btn__text'] [contains(text(),'Zur Speisekarte')]"));
		menubutton.click();
		captureScreen("firstScreen");
	}
	
	@Test(priority = 2)
	public void enterAddress() {
		WebElement enteradress= driver.findElement(By.xpath("//input[@id='address-input']"));
		enteradress.sendKeys("Semperstraße 44, 1180 Wien, Austria");
		captureScreen("firstScreen");
	}
	
	@Test(priority = 3)
	public void submitaddress() {
		WebElement submitadress= driver.findElement(By.xpath("//input[@class='btn--honest blattgold--form-banner-submit']"));
		submitadress.click();
		captureScreen("firstScreen");
		//button[@class='buybox--button bare-element'] [contains(text(),'Cheesy Pork Burrito')]
	}
	
	@Test(priority = 4)
	public void additem() {
		WebElement additems= driver.findElement(By.xpath("//a[@class='product--title' and @title=\"Cheesy Pork Burrito\"]"));
		additems.click();
		captureScreen("firstScreen");
		//button[@class='buybox--button bare-element'] [contains(text(),'Cheesy Pork Burrito')]
	}

	@Test(priority = 5)
	public void addextra() {
		WebElement addextras= driver.findElement(By.xpath("//button[@id='topup-modal--close']"));
		addextras.click();
		captureScreen("firstScreen");
		//button[@class='buybox--button bare-element'] [contains(text(),'Cheesy Pork Burrito')]
	}
	

	
}
