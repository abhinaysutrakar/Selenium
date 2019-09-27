package com.uiFramework.abscompany.automation.testbase;

import java.io.File;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.uiFramework.abscompany.automation.helper.browserConfiguration.BrowserType;
import com.uiFramework.abscompany.automation.helper.browserConfiguration.ChromeBrowser;
import com.uiFramework.abscompany.automation.helper.browserConfiguration.FirefoxBrowser;
import com.uiFramework.abscompany.automation.helper.browserConfiguration.IexplorerBrowser;
import com.uiFramework.abscompany.automation.helper.browserConfiguration.config.IConfigReader;
import com.uiFramework.abscompany.automation.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.abscompany.automation.helper.browserConfiguration.config.PropertyReader;
import com.uiFramework.abscompany.automation.helper.logger.LoggerHelper;
import com.uiFramework.abscompany.automation.helper.resource.ResourceHelper;
import com.uiFramework.abscompany.automation.helper.wait.WaitHelper;
import com.uiFramework.abscompany.automation.utils.ExtentManager;

public class TestBase {
	public static ExtentReports extent;
	public static ExtentTest test;
	public WebDriver driver;
	private Logger log=LoggerHelper.getLogger(TestBase.class);
	public static File reportDirectory;
	
	@BeforeSuite
	public void beforeSuite()
	{
		extent= ExtentManager.getInstance();
		
	}
	
	@BeforeTest
	public void beforeTest() throws Exception {
		//IConfigReader reader =new PropertyReader();
		ObjectReader.reader=new PropertyReader();
		reportDirectory=new File(ResourceHelper.getResourcePath("src\\main\\resources\\screenShots"));
		setUpDriver(ObjectReader.reader.getBrowserType());
	}
	
	@BeforeClass
	public void beforeClass()
	{
		test= extent.createTest(getClass().getName());
				
	}
	
	@BeforeMethod
	public void beforeMethod(Method method)
	{
		test.log(Status.INFO,method.getName() +"test started");
				
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getThrowable());
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			test.log(Status.PASS, result.getName()+"is Pass");
		}
		else if(result.getStatus()==ITestResult.SKIP){
			test.log(Status.SKIP, result.getThrowable());
		}
		extent.flush();
				
	}
	
	public WebDriver getBrowserObject(BrowserType btype) throws Exception {
		try
		{
			
			switch(btype)
			{
			case Chrome:
			ChromeBrowser chrome=ChromeBrowser.class.newInstance();
			ChromeOptions option = chrome.getChromeOptions();
			return chrome.getChromeDriver(option);
			
			case Firefox:
				FirefoxBrowser firefox= FirefoxBrowser.class.newInstance();
				FirefoxOptions options=firefox.getFirefoxOptions();
				return firefox.getFirefoxDriver(options);
			case Iexplorer:
				IexplorerBrowser iexplorer= IexplorerBrowser.class.newInstance();
				InternetExplorerOptions optionsie=iexplorer.getIExplorerCapabilities();
				return iexplorer.getIExplorerDriver(optionsie);
			default:
				throw new Exception("Driver not Found"+btype.name());
			}
		}
		catch(Exception e) {
			log.info(e.getMessage());
			throw e;
		}
			
		}
	
public void setUpDriver(BrowserType btype) throws Exception {
driver =getBrowserObject(btype);
log.info("Initialize the WebDriver"+driver.hashCode());
WaitHelper wait = new WaitHelper(driver);
wait.setImplicitWait(ObjectReader.reader.getImplicitWait(),TimeUnit.SECONDS);
wait.pageLoadTimeOut(ObjectReader.reader.getExplicitWait(), TimeUnit.SECONDS);
driver.manage().window().maximize();

}

public String captureScreen(String fileName)
{
	if(driver==null)
	{
		log.info("driver is null");
		return null;
		
	}
	if(fileName=="") {
		fileName="blank";
	}
	File destFile=null;
	Calendar calendar=Calendar.getInstance();
	SimpleDateFormat formater=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
	File screFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try {
		destFile = new File(reportDirectory+"/"+fileName+formater.format(calendar.getTime())+".png");
		Files.copy(screFile.toPath(), destFile.toPath());
		Reporter.log("<a href='"+destFile.getAbsolutePath()+"'><img src='"+destFile.getAbsolutePath()+"'height='100' width='100'/></a>");
	}
	catch (Exception e) {
		
	}
	
	return fileName;
	
}

}


