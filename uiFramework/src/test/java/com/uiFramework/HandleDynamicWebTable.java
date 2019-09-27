package com.uiFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandleDynamicWebTable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//
		System.setProperty("webdriver.chrome.driver","C:\\Users\\abhinay.sutrakar\\Desktop\\uiFramework\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.freecrm.com");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//dynamic wait
		
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[@class=\"btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left\"]")).click();
		
		//Thread.sleep(3000);
		
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("abhinay.sutrakar@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Selenium@123");
		
		driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();
		
		
		driver.findElement(By.xpath("//a[@class='item' and @href='/contacts']")).click();
		
		//method 1
		driver.navigate().refresh();
		//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);//*[text()[contains(.,'def pqr')]]//parent::td//preceding-sibling::td//label
		WebElement checkbox = driver.findElement(By.xpath("//*[text()[contains(.,'def pqr')]]//parent::td//preceding-sibling::td//label"));
		Actions action = new Actions(driver);
		action.moveToElement(checkbox).click().build().perform();
		//"//*[text()[contains(.,'def pqr')]]//parent::td//preceding-sibling::td//input[@name='id']
		
		//checkbox.click();
		
		driver.close();
		
		
	}

}
