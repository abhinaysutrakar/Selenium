package com.uiFramework.abscompany.automation.testScripts;




import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Driver;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.uiFramework.abscompany.automation.helper.logger.LoggerHelper;

public class identifybrokenlinks {

	private WebDriver driver;
	
	private Logger log =LoggerHelper.getLogger(identifybrokenlinks.class);
	
		public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.geckodriver.exe", "C:\\Users\\abhinay.sutrakar\\Desktop\\uiFramework\\geckodriver.exe");
		WebDriver drivers= new FirefoxDriver();
		drivers.manage().window().maximize();
		drivers.get("https://www.google.com/");
		
		List<WebElement> links = drivers.findElements(By.tagName("a"));
		
		System.out.println("Total number of Links are "+links.size());
		
		for(int i=0;i<links.size();i++)
		{
			WebElement ele = links.get(i);
			String url =ele.getAttribute("href");
			verifylinkActive(url);
			
		}

	}
		public static void verifylinkActive(String linksurl)
		{
			
			try {
				URL url = new URL(linksurl);
				HttpURLConnection httpURLConnect =(HttpURLConnection)url.openConnection();
				httpURLConnect.setConnectTimeout(3000);
				httpURLConnect.connect();
				if (httpURLConnect.getResponseCode()==200)
				{
					System.out.println(linksurl+ ""+httpURLConnect.getResponseMessage());
				}
				if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)
				{
					System.out.println(linksurl+"-"+httpURLConnect.getResponseMessage()+""+HttpURLConnection.HTTP_NOT_FOUND);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
}
