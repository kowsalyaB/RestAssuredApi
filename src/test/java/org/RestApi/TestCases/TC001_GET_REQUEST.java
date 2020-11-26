package org.RestApi.TestCases;

import org.RestApi.BaseTest.Base;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_REQUEST extends Base {

	@BeforeClass
	public void GetUser()
	{
		logger.info("*********Strted TC001_GET_REQUEST*********");
		RestAssured.baseURI="https://reqres.in/api/users";
		 httpRequest=RestAssured.given();
		 response=httpRequest.request(Method.GET,"/"+EmpID);
	}

	@Test
	public void GetUserDetails()
	{
		logger.info("*********Checking REsponse body*********");
		String ResponseBody=response.getBody().asString();
		logger.info("Response Body==>"+ResponseBody);
		Assert.assertTrue(ResponseBody!=null);
	}
	
	@Test
	public void CheckStstuscode()
	{
		logger.info("*********Check status code*********");
		int Statuscode=response.getStatusCode();
		System.out.println("Status Code Is: "+Statuscode);
		Assert.assertEquals(Statuscode, 200);
	}
	
	@Test
	public void CheckStstusLine()
	{
		logger.info("*********Check status Line*********");
		String Statusline=response.statusLine();
		System.out.println("Status Line Is: "+Statusline);
		Assert.assertEquals(Statusline, "HTTP/1.1 200 OK");
	}

}
