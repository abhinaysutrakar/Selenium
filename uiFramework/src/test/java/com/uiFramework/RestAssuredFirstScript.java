package com.uiFramework;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class RestAssuredFirstScript {
	
@Test
public void HitEndpointGet() {
	
	//RestAssured is Class

	RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
	
	// Get the RequestSpecification of the request that you want to sent to the server. 
	//The server is specified by the BaseURI that we have // specified in the above step.
	RequestSpecification httpRequest =RestAssured.given();
	
	Response response = httpRequest.request(Method.GET,"/Mumbai");
	
	String responseBody= response.getBody().asString();
	String responseHeader= response.getHeader("Content-Type");
	
	System.out.println("Body :"+ responseBody);
	System.out.println("Header : " +responseHeader);
	//System.out.println("Header : " +);
	String str=RestAssured.baseURI.toString();
	System.out.println(str);
	System.out.println("Response status code"+response.getStatusCode());
	Assert.assertEquals(200, response.getStatusCode());
	boolean flag=responseBody.contains("Degree");
	System.out.println(flag);
	
}



}
