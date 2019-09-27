package com.uiFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DynamicWebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

System.setProperty("webdriver.chrome.driver","C:\\Users\\abhinay.sutrakar\\Desktop\\uiFramework\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		String scity="Dubai";
		
		driver.get("http://toolsqa.com/automation-practice-table/");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		String sRow="1";
		String sCol="2";
		//dynamic wait
		
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		
		String sCellValue= driver.findElement(By.xpath("//*[@id='content']/table/tbody/tr["+sRow+"]/td["+sCol+"]")).getText();
		System.out.println(sCellValue);
		
		
		
		String sRowValue="Clock Tower Hotel";
		for(int i=1;i<=5;i++)
		{
			String sCellValue2=null;
			sCellValue2= driver.findElement(By.xpath("//*[@id='content']/table/tbody/tr["+ i +"]/th")).getText();
			System.out.println(sCellValue2);
			
			if(sCellValue2.equalsIgnoreCase(sRowValue)) {
				
				for(int j=1; j<=5;j++) {
					String sColumnValue=driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[" + i + "]/td["+ j +"]")).getText();
				System.out.println(sColumnValue);
				}
				break;
			}
			
		//	driver.manage().timeouts()
		
		}
		
		//Thread.sleep(3000);
		
				driver.close();
		
		
	}

}
