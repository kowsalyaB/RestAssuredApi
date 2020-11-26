package org.RestApi.TestCases;

import org.RestApi.BaseTest.Base;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_REQUEST extends Base {
	String name=RestUtils.Ename();
	String Sal=RestUtils.ESal();
	String age=RestUtils.EAge();

	@BeforeClass
	public void PostUserDetails()
	{
		logger.info("*********Strted TC002_POST_REQUEST*********");
		//Specify base URI
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";

		//Request Object has created
		httpRequest=RestAssured.given();

		//Request payload sending along with post request
		JSONObject requestParams=new JSONObject();
		requestParams.put("employee_name",name);
		requestParams.put("employee_salary",Sal);
		requestParams.put("employee_age",age);


		httpRequest.header("Content-Type","application/json");

		httpRequest.body(requestParams.toJSONString()); //Attach above data to request

		response=httpRequest.request(Method.POST,"/create"); 
	}
	
	@Test
	public void Resbody()
	{
		String ResponseBody=response.getBody().asString();
		Assert.assertEquals(ResponseBody.contains(name), true);
		Assert.assertEquals(ResponseBody.contains(Sal), true);
		Assert.assertEquals(ResponseBody.contains(age), true);
	}
}
