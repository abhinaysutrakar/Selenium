package com.uiFramework.absecompany.automation.testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersTest {
	WebDriver driver;
	
	@Test
	@Parameters({"env","browser","url","username","password"})
	public void gmailLoginTest(String env,String browser,String url,String username,String password) {
		if(browser.equals("chrome")) {
			driver =new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver =new FirefoxDriver();
		}
		else if(browser.equals("ie"))
		{
			driver =new InternetExplorerDriver();
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@type='email']")).clear();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(username);
		driver.findElement(By.xpath("//span[@class=\"CwaK9\"]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))); 
			
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//span[@class=\"RveJvd snByac\"]")).click();
		
		driver.manage().deleteAllCookies();
		driver.close();
	}

}
