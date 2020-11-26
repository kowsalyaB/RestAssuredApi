package org.RestApi.TestCases;

import org.RestApi.BaseTest.Base;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class TC00_DELETE_REQUEST extends Base {

	@BeforeClass
	public void PostUserDetails()
	{
		logger.info("*********Strted TC002_POST_REQUEST*********");
		//Specify base URI
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpRequest=RestAssured.given();
		response=httpRequest.request(Method.GET,"/employees"); 
	
		JsonPath jsonpath=response.jsonPath();
		String idIs=jsonpath.get("[0].id");
		response=httpRequest.request(Method.DELETE,"/delete/"+idIs);
	}
	
	@Test
	public void Resbody()
	{
		String ResponseBody=response.getBody().asString();
		Assert.assertEquals(ResponseBody.contains("successfully! deleted Records"), false);
	}
}
