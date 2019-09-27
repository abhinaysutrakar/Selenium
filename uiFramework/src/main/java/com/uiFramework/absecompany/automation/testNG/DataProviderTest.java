package com.uiFramework.absecompany.automation.testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.uiFramework.abscompany.automation.helper.excel.excelReader;

public class DataProviderTest {
	
		WebDriver driver;
		
		@DataProvider
		public String[][] getTestData()
		{
			excelReader ExcelReader= new excelReader(); 
			String excellocation="C:/Users/abhinay.sutrakar/Desktop/uiFramework/TestData.xlsx";
			String sheetName="Data";
			String[][] data=ExcelReader.getExcelData(excellocation,sheetName);
			return data;
		}
		
		
		@Test(dataProvider="getTestData")
	
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
			driver.findElement(By.xpath("//div[@class='h_menu_drop_button hidden-xs']//i[@class='fa fa-align-justify']")).click();
			driver.findElement(By.xpath("//button[@class='search_btn' and text()='LOGIN']")).click();
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userId")));
			driver.findElement(By.id("userId")).sendKeys(username);;
			driver.findElement(By.id("pwd")).sendKeys(password);
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
				
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.xpath("//span[@class=\"RveJvd snByac\"]")).click();
			
			driver.manage().deleteAllCookies();
			driver.close();
		}

}
