package com.uiFramework.absecompany.automation.testNG;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testNGBasics {
	
	private static final String Priority = null;
	private WebDriver driver = new ChromeDriver();

	@BeforeSuite
	public void setUp(){
			System.out.println("1.Before Suite: Install Chrome");
		}
	
	@BeforeTest
	public void launchBrowser()
		
	{
		System.out.println("2.Before Test: launch browser");
		driver.get("http://www.google.com");
	}

	@BeforeClass
	public void login()
	{
		System.out.println("3.Before Class : Login");
	}
	
	@BeforeMethod
	public void enterURL()
	{
		System.out.println("4.Before Method : enterURL");
	}
	
	//Invocation count will run the below test 5 times
	@Test(priority=1,groups="title",invocationCount = 5)
	public void googleTitleTest()
		
	{
		String title= driver.getTitle();
		System.out.println("5.Test 1 : Title is "+ title);
		Assert.assertEquals(title, "Google","title not matched");
	}
	
	/*@BeforeMethod
	public void enterURL1()
	{
		System.out.println("4.Before Method : enterURL");
	}*/
	
	@Test(priority=2,groups="logo")
	public void logoTest()
		
	{
		System.out.println("5.Test 2 : logoTest");
		//int i =9/0;
	}
	
	/*@BeforeMethod
	public void enterURL3()
	{
		System.out.println("4.Before Method : enterURL");
	}*/
	
	@Test(priority=3,groups="links",dependsOnMethods="logoTest",expectedExceptions=org.openqa.selenium.NoSuchElementException.class)
	public void links()
		
	{
		driver.findElement(By.xpath("abcd"));
		System.out.println("5.Test 3 : hyperlinks");
		
	}
	@Test(priority=4,groups="button",dependsOnMethods="logoTest" )
	public void search()
		
	{
		System.out.println("5.Test 4 : searchbutton");
		
	}
	@Test(groups="links")
	public void language()
		
	{
		System.out.println("5.Test 5 : language");
		
	}
	@Test(priority=6,groups="button",dependsOnMethods="logoTest" )
	public void gmailoption()
		
	{
		System.out.println("5.Test 6 : gmail");
		
	}
	
	@AfterMethod
	public void logOut()
		
	{
		System.out.println("6.After Method : Logout");
		
	}
	
	/*@AfterMethod
	public void logOut1()
		
	{
		System.out.println("6.After Method : Logout");
		
	}*/
	
	/*@AfterMethod
	public void logOut2()
		
	{
		System.out.println("6.After Method : Logout");
		
	}*/
	
		
	@AfterClass
	public void closeBrowser()
		
	{
		System.out.println("7.After Class :closeBrowser");
		driver.close();
		
	}
	
	@AfterTest
	public void deleteAllCookies()
		
	{
		System.out.println("8.After Test deleteCookies");
		
	}
	
	@AfterSuite
	public void generateTestReport()
		
	{
		System.out.println("9.generateTestReport");
		
	}
	
}
