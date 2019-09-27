package com.uiFramework.abscompany.automation.helper.resource;

import org.apache.log4j.Logger;

import com.uiFramework.abscompany.automation.helper.logger.LoggerHelper;

public class ResourceHelper {
	
	private static Logger log =LoggerHelper.getLogger(ResourceHelper.class);
	public static String getResourcePath(String path) {
	String basePath=System.getProperty("user.dir");
	//log.info("resource path"+basePath+"/"+path);
	System.out.println(basePath+"\\"+path);
	
	return basePath+"\\"+path;
	}
	
	
	
}
