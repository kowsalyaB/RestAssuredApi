package DemoAPI;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_REQUEST {

	@Test
	public void PostUserDetails()
	{
		//Specify base URI
		RestAssured.baseURI="https://reqres.in/api";
		
		//Request Object has created
		RequestSpecification httpRequest=RestAssured.given();
		
		//Request payload sending along with post request
		JSONObject requestParams=new JSONObject();
		requestParams.put("id", 1);
		requestParams.put("name", "Sizzelen");
		requestParams.put("year", 2015);
		requestParams.put("color", "#98B2D1");
		requestParams.put("pantone_value", "15-4020");
		
		httpRequest.header("Content-Type","application/json");
		
		httpRequest.body(requestParams.toJSONString()); //Attach above data to request
		
		Response response=httpRequest.request(Method.POST,"/users"); 
		
		//Print response in console window
		String ResponseBody=response.getBody().asString();
		System.out.println("Response Body Is: "+ResponseBody);
		
		//Status code & Status Line validation
		int Statuscode=response.getStatusCode();
		System.out.println("Status Code Is: "+Statuscode);
		Assert.assertEquals(Statuscode, 201);
		
		String Successcode=response.jsonPath().get("SuccessCode");
		Assert.assertEquals(Successcode, null);
	}
}
